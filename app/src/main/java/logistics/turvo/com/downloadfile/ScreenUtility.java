/*
 * Copyright © 2017, Smartivity
 */
package logistics.turvo.com.downloadfile;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Abhishek V on 06/03/2017.
 */

public class ScreenUtility {

    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }
}
