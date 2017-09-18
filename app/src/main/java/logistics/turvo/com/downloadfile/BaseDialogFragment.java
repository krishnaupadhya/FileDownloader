package logistics.turvo.com.downloadfile;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.view.ViewGroup;


/**
 * Created by Abhishek V on 05/05/2017.
 */

public class BaseDialogFragment extends DialogFragment {

    @Override
    public void onStart() {
        super.onStart();
        try {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.getWindow()
                        .setLayout((int) (ScreenUtility.getScreenWidth(getActivity()) * Constants.CUSTOM_DIALOG_WIDTH_PERCENTAGE), ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        } catch (Exception e) {
            LogUtility.printStackTrace(e);
        }
    }
}
