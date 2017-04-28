package com.example.jin.intentreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by JIN on 2017/4/28.
 */

public class SMSReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("receive message");

        Bundle bundle = intent.getExtras();//接收Intent的数据
        Object[] myOBJpdus = (Object[]) bundle.get("pdus");//Bundle对象中有一个属性名为pdus，属性值为Object数组
        SmsMessage[] messages = new SmsMessage[myOBJpdus.length];
        System.out.println(messages.length);
        for (int i=0; i < myOBJpdus.length ;i++) {
            messages[i] = SmsMessage.createFromPdu((byte[])myOBJpdus[i]);
            System.out.println(messages[i].getDisplayMessageBody());
        }
    }
}
