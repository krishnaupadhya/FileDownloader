/*
 * Copyright © 2017, Smartivity
 */
package logistics.turvo.com.downloadfile;

import android.util.Log;


/**
 * Created by Abhishek V on 06/03/2017.
 * Wrapper class for android Log. Shows the log only in debug build type
 */
public class LogUtility {

    /**
     * Prints info log message
     * @param tag - Used to identify the source of a log message
     * @param msg - The message you would like logged.
     */
    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, msg);
        }
    }

    /**
     * Prints debug log message
     * @param tag - Used to identify the source of a log message
     * @param msg - The message you would like logged.
     */
    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }

    /**
     * Prints error log message
     * @param tag - Used to identify the source of a log message
     * @param msg - The message you would like logged.
     */
    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg);
        }
    }

    /**
     * Prints the stack trace of exception object passed
     * @param exception Exception object whose stack trace to be printed
     */
    public static void printStackTrace(Exception exception) {
        if (BuildConfig.DEBUG) {
            exception.printStackTrace();
        }
    }
}
