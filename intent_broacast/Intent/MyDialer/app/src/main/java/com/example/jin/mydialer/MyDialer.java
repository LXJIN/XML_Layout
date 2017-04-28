package com.example.jin.mydialer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyDialer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent <Intent_name> = new Intent(<Action>,<Date>);
                Intent I = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://13800138000"));
                startActivity(I);
            }
        });
    }
}
