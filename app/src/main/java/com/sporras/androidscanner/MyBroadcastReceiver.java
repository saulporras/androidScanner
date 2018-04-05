package com.sporras.androidscanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by sporras on 1/5/2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // On scan we update the object value with the information coming from the builtin scanner
        ObservableObject.getInstance().updateValue(intent.getStringExtra("com.datalogic.decode.intentwedge.barcode_string"));
    }
}