/*
 * Copyright © 2017, Smartivity
 */
package logistics.turvo.com.downloadfile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Abhishek V on 06/03/2017.
 */

public class DialogUtility {

    private static final String LOG_TAG = "DialogUtility";

    public static void showAlert(Builder builder, FragmentManager manager) {
        try {
            CustomAlertDialog customAlertDialog = new CustomAlertDialog();
            Bundle arguments = new Bundle();
            arguments.putString(Constants.INTENT_EXTRA_DIALOG_TITLE, builder.title);
            arguments.putInt(Constants.INTENT_EXTRA_DIALOG_ICON_RES_ID, builder.iconResId);
            arguments.putString(Constants.INTENT_EXTRA_DIALOG_ICON_URL, builder.iconUrl);
            arguments.putString(Constants.INTENT_EXTRA_DIALOG_MESSAGE, builder.message);
            arguments.putString(Constants.INTENT_EXTRA_DIALOG_POSITIVE_BTN_TXT, builder.positiveBtnTxt);
            arguments.putString(Constants.INTENT_EXTRA_DIALOG_NEGATIVE_BTN_TXT, builder.negativeBtnTxt);
            customAlertDialog.setArguments(arguments);
            customAlertDialog.setPositiveBtnClickListener(builder.positiveBtnClickListener);
            customAlertDialog.setNegativeBtnClickListener(builder.negativeBtnClickListener);
            customAlertDialog.show(manager, "customalert");
        } catch (Exception e) {
            LogUtility.e(LOG_TAG, "error showing dialog");
            LogUtility.printStackTrace(e);
        }
    }

    public static final class Builder {
        private String title;
        private String message;
        private int iconResId;
        private String iconUrl;
        private String positiveBtnTxt;
        private String negativeBtnTxt;
        private View.OnClickListener positiveBtnClickListener;
        private View.OnClickListener negativeBtnClickListener;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder iconResId(int iconResId) {
            this.iconResId = iconResId;
            return this;
        }

        public Builder iconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public Builder positiveBtnTxt(String positiveBtnTxt) {
            this.positiveBtnTxt = positiveBtnTxt;
            return this;
        }

        public Builder negativeBtnTxt(String negativeBtnTxt) {
            this.negativeBtnTxt = negativeBtnTxt;
            return this;
        }

        public Builder positiveBtnClickListener(View.OnClickListener positiveBtnClickListener) {
            this.positiveBtnClickListener = positiveBtnClickListener;
            return this;
        }

        public Builder negativeBtnClickListener(View.OnClickListener negativeBtnClickListener) {
            this.negativeBtnClickListener = negativeBtnClickListener;
            return this;
        }


    }

    public static ProgressDialog showProgressDialog(Context context, String message) {
        if (context == null) {
            return null;
        }

        ProgressDialog progressDialog = new ProgressDialog(context);

        try {
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            return progressDialog;
        } catch (IllegalArgumentException e) {
            LogUtility.e(LOG_TAG, "Error showing progress dialog");
            LogUtility.printStackTrace(e);
        } catch (Exception e) {
            LogUtility.e(LOG_TAG, "Error showing progress dialog");
            LogUtility.printStackTrace(e);
        }
        return null;
    }

    public static void showToastMessage(Activity activity, String message, int duration) {
        //Creating the LayoutInflater instance
        LayoutInflater li = activity.getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.lyt_toast, null);
        ((TextView) layout.findViewById(R.id.txt_toast_message)).setText(message);

        //Creating the Toast object
        Toast toast = new Toast(activity.getApplicationContext());
        toast.setDuration(duration);
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.BOTTOM, 0, 0);
        toast.setView(layout);
        toast.show();
    }


}
