package com.example.leidong.listencalls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by leido on 2017/4/13.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(MainActivity.PHONE_STATE)){
            doReceivePhone(context, intent);
        }
    }

    /**
     * 处理电话广播
     * @param context
     * @param intent
     */
    public void doReceivePhone(Context context, Intent intent) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int state = telephonyManager.getCallState();
        switch (state){
            case TelephonyManager.CALL_STATE_RINGING:
                Toast.makeText(context, "电话来啦\n电话来啦\n电话来啦\n电话来啦", Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Toast.makeText(context, "电话打完啦\n电话打完啦\n电话打完啦\n电话打完啦", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
