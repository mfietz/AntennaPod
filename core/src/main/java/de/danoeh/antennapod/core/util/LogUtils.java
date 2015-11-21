package de.danoeh.antennapod.core.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class LogUtils {

    private static final String TAG = LogUtils.class.getSimpleName();

    private static Process p;
    private static File outputFile = new File(Environment.getExternalStorageDirectory(), "logcat.txt");

    public static void startLogging() {
        if(outputFile.exists()) {
            outputFile.delete();
        }
        try {
            Runtime.getRuntime().exec("logcat -c");
            p = Runtime.getRuntime().exec("logcat -f " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }

    public static boolean isLogging() {
        return p != null;
    }

    public static void stopLogging(final Context context){

        p.destroy();
        p = null;

        //send file using email
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        String to[] = {"Martin.Fietz@gmail.com"};
        emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
        // the attachment
        emailIntent .putExtra(Intent.EXTRA_STREAM, Uri.fromFile(outputFile));
        // the mail subject
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, "AntennaPod Logcat");
        context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

}