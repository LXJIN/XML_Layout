package com.example.jin.intentreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by JIN on 2017/4/28.
 */

public class OtherActivity extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //从Intent当中根据key取得value
        String value = intent.getStringExtra("testIntent");
        Log.e("IntentReceiver-->test" , value);
    }
}
