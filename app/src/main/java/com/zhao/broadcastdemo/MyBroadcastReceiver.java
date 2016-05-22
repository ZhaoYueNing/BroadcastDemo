package com.zhao.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Zhao on 2016/5/21.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        TAG("BC2==========================");
        String str = intent.getStringExtra("msg");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TAG(str);
    }
    public void TAG(String str){
        Log.d("BroadcastDemo2",str);
    }
}
