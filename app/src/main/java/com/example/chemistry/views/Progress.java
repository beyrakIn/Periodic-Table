package com.example.chemistry.views;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.chemistry.R;

public class Progress {
    private ProgressDialog progressDialog;
    private Context context;

    public Progress(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    public void start() {
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
        progressDialog.setCancelable(false);
    }

    public void stop() {
        progressDialog.dismiss();
    }
}
