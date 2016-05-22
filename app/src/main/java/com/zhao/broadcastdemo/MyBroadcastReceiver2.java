package com.zhao.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Zhao on 2016/5/21.
 */
public class MyBroadcastReceiver2 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        TAG("BC2==========================");
        String str = intent.getStringExtra("msg");
        TAG(str);
    }
    public void TAG(String str){
        Log.d("BroadcastDemo_Dynamic",str);
    }
}
