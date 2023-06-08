package com.phycae.mydrivekt.neverservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i(MyReceiver.class.getSimpleName(), "Service Stops! Oooooooooooooppppssssss!!!!");
        //context.startService(new Intent(context, MyService.class));
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startService(new Intent(context, MyService.class));
        } else {
            context.startService(new Intent(context, MyService.class));
        }*/
        Util.schedulerJob(context);
    }
}