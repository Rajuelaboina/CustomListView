package com.raju.myradiorecyclerview;

import static android.content.Context.CONNECTIVITY_SERVICE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    static NetworkCheckConn listener2;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
      /*  ConnectivityManager connect = (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfos = connect.getActiveNetworkInfo();*/

        listener2.onConnection(CheckNetworkInfo.checkNetWorkInfo(context));

        Log.e("RRRRRRRR",""+intent.getAction());
        intent.putExtra("Id","raju");
        intent.setAction("phy");
        context.sendBroadcast(intent);
    }
    public static void setListener(NetworkCheckConn listener){
        listener2= listener;
    }
}