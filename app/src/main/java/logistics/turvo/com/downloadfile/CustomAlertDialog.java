package logistics.turvo.com.downloadfile;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;


/**
 * Created by Abhishek V on 19/04/2017.
 */

public class CustomAlertDialog extends BaseDialogFragment {
    private View.OnClickListener positiveBtnClickListener;
    private View.OnClickListener negativeBtnClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fragment_alert, null);
        ButterKnife.bind(this, view);
        builder.setView(view);
        initView(view);
        return builder.create();
    }

    private void initView(View view) {
        Bundle arguments = getArguments();
        setTitle(view, arguments);
        setMessage(view, arguments);
        setPositiveBtn(view, arguments);
        setnegativeBtn(view, arguments);
    }

    private void setTitle(View view, Bundle arguments) {
        TextView txtTitle = ButterKnife.findById(view, R.id.txt_title);
        String title = arguments.getString(Constants.INTENT_EXTRA_DIALOG_TITLE);
        if (!TextUtils.isEmpty(title)) {
            txtTitle.setText(title);
        } else {
            txtTitle.setVisibility(View.GONE);
        }
    }


    private void setMessage(View view, Bundle arguments) {
        TextView txtMessage = ButterKnife.findById(view, R.id.txt_message);
        String message = arguments.getString(Constants.INTENT_EXTRA_DIALOG_MESSAGE);
        if (!TextUtils.isEmpty(message)) {
            txtMessage.setText(message);
        } else {
            txtMessage.setVisibility(View.GONE);
        }
    }

    private void setPositiveBtn(View view, Bundle arguments) {
        TextView txtPositiveBtn = ButterKnife.findById(view, R.id.txt_positive_btn);
        String postiveBtnTxt = arguments.getString(Constants.INTENT_EXTRA_DIALOG_POSITIVE_BTN_TXT);
        if (!TextUtils.isEmpty(postiveBtnTxt)) {
            txtPositiveBtn.setText(postiveBtnTxt);
            txtPositiveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if (positiveBtnClickListener != null) {
                        positiveBtnClickListener.onClick(v);
                    }
                }
            });


        } else {
            txtPositiveBtn.setVisibility(View.GONE);
        }
    }

    private void setnegativeBtn(View view, Bundle arguments) {
        TextView txtNegativeBtn = ButterKnife.findById(view, R.id.txt_negative_btn);
        String negativeBtnTxt = arguments.getString(Constants.INTENT_EXTRA_DIALOG_NEGATIVE_BTN_TXT);
        if (!TextUtils.isEmpty(negativeBtnTxt)) {
            txtNegativeBtn.setText(negativeBtnTxt);
            txtNegativeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if (negativeBtnClickListener != null) {
                        negativeBtnClickListener.onClick(v);
                    }
                }


            });
        } else {
            txtNegativeBtn.setVisibility(View.GONE);
        }
    }


    public void setPositiveBtnClickListener(View.OnClickListener positiveBtnClickListener) {
        this.positiveBtnClickListener = positiveBtnClickListener;
    }

    public void setNegativeBtnClickListener(View.OnClickListener negativeBtnClickListener) {
        this.negativeBtnClickListener = negativeBtnClickListener;
    }
}
