package com.ahmadarif.simpledaggerjava.helper;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by ARIF on 14-Jun-17.
 */

public class View {

    public static ProgressDialog progressDialog(Context context, String message) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(message);
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.cancel();
        return dialog;
    }

}
