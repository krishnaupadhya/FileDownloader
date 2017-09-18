package logistics.turvo.com.downloadfile;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    // declare the dialog as a member field of your activity
    ProgressDialog mProgressDialog;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        initProgressbar();
    }

    public void downloadFile(View view) {
// this is how you fire the downloader
        downloadPdf(this);
    }

    private void initProgressbar() {
        // instantiate it within the onCreate method
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("downloading Please wait");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);


    }

    public void downloadPdf(Activity activity) {

        if (PermissionUtility.isVersionMarshmallowAndAbove() && !PermissionUtility.checkReadExternalStoragePermission(activity)) {
            //If the OS version is marshmallow and read external storage permission is not given yet,
            // ask for the permission first
            PermissionUtility.requestWriteExternalPermission(activity);
        } else {
            mProgressDialog.show();
            Intent intent = new Intent(this, DownloadService.class);
            intent.putExtra("url", "http://maven.apache.org/maven-1.x/maven.pdf");
            intent.putExtra("receiver", new DownloadReceiver(new Handler()));
            startService(intent);
            LogUtility.d("pdf", "download started");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionUtility.REQUEST_CODE_WRITE_EXTERNAL_STORAGE) {
            if (PermissionUtility.verifyPermissions(grantResults)) {
                //permission is given
                downloadFile(null);
            } else {
                int rationalState = PermissionUtility.shouldShowRequestPermissionRationaleState(permissions, grantResults, Manifest.permission.WRITE_EXTERNAL_STORAGE, this);
                if (rationalState != PermissionUtility.REQUEST_PERMISSION_SHOW_RATIONALE) {
                    showReadExternalStorageAlertDialog(this, getSupportFragmentManager());
                }
            }

        }
    }

    private static void showReadExternalStorageAlertDialog(final Activity activity, FragmentManager manager) {
        try {

            DialogUtility.Builder builder = new DialogUtility.Builder()
                    .message(activity.getString(R.string.write_sdcard_permission_alert_msg))
                    .positiveBtnTxt(activity.getString(R.string.settings))
                    .positiveBtnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PermissionUtility.openAppSettingPage(activity);
                        }
                    })
                    .negativeBtnTxt(activity.getString(R.string.cancel));
            DialogUtility.showAlert(builder, manager);
        } catch (Exception e) {
            LogUtility.printStackTrace(e);
            LogUtility.e(TAG, "error displaying write External Storage AlertDialog");
        }
    }

    private class DownloadReceiver extends ResultReceiver {
        public DownloadReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, final Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == DownloadService.UPDATE_PROGRESS) {
                final int progress = resultData.getInt("progress");
                LogUtility.d(TAG, "progess  " + progress);
                runOnUiThread(new Runnable() {
                    public void run() {
                       // textView.setText(textView.getText() + "\n" + progress + "%");
                       mProgressDialog.setProgress(progress);
                    }
                });

                if (progress == 100) {
                   // mProgressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"completed!!",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
