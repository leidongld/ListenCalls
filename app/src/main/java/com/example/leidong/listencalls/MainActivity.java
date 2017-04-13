package com.example.leidong.listencalls;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    public static final String PHONE_STATE = TelephonyManager.ACTION_PHONE_STATE_CHANGED;
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBroadcast();
    }

    /**
     * 注册广播
     */
    private void registerBroadcast() {
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PHONE_STATE);
        intentFilter.setPriority(Integer.MAX_VALUE);
        registerReceiver(myReceiver, intentFilter);
    }

    private void removeBroadcast(){
        unregisterReceiver(myReceiver);
    }
}
