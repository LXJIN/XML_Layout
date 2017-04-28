package com.example.jin.intentreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentReceiver extends AppCompatActivity {
    private Button myButton = null;
    private final String nobody = "Who.care.the.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(new MyButtonListener());
    }

    class MyButtonListener implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(nobody);
            intent.putExtra("testIntent" , "1234567890");//添加键值对
            sendBroadcast(intent);
        }
    }
}
