package com.zhao.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb_isDynamic;
    private Button bt_sendBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final IntentFilter filter = new IntentFilter();
        filter.addAction("com.zhao.intentdemo.testbc_dynamic");
        final BroadcastReceiver receiver = new MyBroadcastReceiver2();
        //init
        cb_isDynamic = (CheckBox) findViewById(R.id.cb_isDynamic);
        bt_sendBroadcast = (Button) findViewById(R.id.bt_sendBroadcast);

        bt_sendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(false);
            }
        });
        findViewById(R.id.bt_sendOrderedBroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(true);
            }
        });

        cb_isDynamic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d("Broadcast_Dynamic","Resgister");
                    registerReceiver(receiver, filter);
                }else {
                    Log.d("Broadcast_Dynamic","UnResgister");
                    unregisterReceiver(receiver);

                }
            }
        });
    }

    private void send(boolean isOrdered) {
        Intent intent = new Intent("com.zhao.BroadcastDemo.MY_BROADCASTRECEIVER");
        if (isOrdered){
            sendOrderedBroadcast(intent,null);
            return;
        }
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new MyBroadcastReceiver2());
    }
}
