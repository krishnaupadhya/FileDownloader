/*
 * Copyright © 2017, Smartivity
 */
package logistics.turvo.com.downloadfile;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;

public class PermissionUtility {
    public static final int REQUEST_PERMISSION_SHOW_RATIONALE = 1;
    public static final int REQUEST_PERMISSION_DO_NOT_SHOW_RATIONALE = 0;
    public static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 100;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 101;

    public static boolean isVersionMarshmallowAndAbove() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M);
    }

    public static void openAppSettingPage(Context context){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivity(intent);
    }

    public static boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if (grantResults.length < 1) {
            return false;
        }
        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static int shouldShowRequestPermissionRationaleState(String[] permissions, int[] grantResults, String requestedPermission, Activity activity) {
        for (int i = 0, len = permissions.length; i < len; i++) {
            String permission = permissions[i];
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
                if (!showRationale) {
                    // user denied flagging NEVER ASK AGAIN
                    // you can either enable some fall back,
                    // disable features of your app
                    // or open another dialog explaining
                    // again the permission and directing to
                    // the app setting
                    return REQUEST_PERMISSION_DO_NOT_SHOW_RATIONALE;

                } else if (requestedPermission.equals(permission)) {
                    // user denied WITHOUT never ask again
                    // this is a good place to explain the user
                    // why you need the permission and ask if he want
                    // to accept it (the rationale)

                    return REQUEST_PERMISSION_SHOW_RATIONALE;
                }
                return -1;
            }
        }
        return -1;
    }


    public static void requestReadExternalPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_READ_EXTERNAL_STORAGE);
    }

    public static void requestWriteExternalPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE);
    }


    public static boolean checkReadExternalStoragePermission(Activity activity) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkWriteExternalStoragePermission(Activity activity) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }
}
