package com.example.jin.intentreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentReceiver extends AppCompatActivity {
    private Button registButton = null;
    private Button unregistButton = null;
    private SMSReceiver smsReceiver = null;

    private static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        registButton = (Button) findViewById(R.id.regist);
        registButton.setOnClickListener(new RegistReceiverListener());
        unregistButton = (Button) findViewById(R.id.unregist);
        unregistButton.setOnClickListener(new UnRegistReceiverListener());
    }

    class RegistReceiverListener implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            smsReceiver = new SMSReceiver();//BroadcastReceiver对象
            IntentFilter filter = new IntentFilter();
            filter.addAction(SMS_ACTION);
            IntentReceiver.this.registerReceiver(smsReceiver,filter);
        }
    }

    class UnRegistReceiverListener implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            IntentReceiver.this.unregisterReceiver(smsReceiver);
        }
    }
}
