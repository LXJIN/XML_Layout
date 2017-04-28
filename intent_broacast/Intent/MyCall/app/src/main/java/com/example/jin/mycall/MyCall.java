package com.example.jin.mycall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button);
        final EditText phoneNum = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = phoneNum.getText().toString();
                if(PhoneNumberUtils.isGlobalPhoneNumber(call)){
                    //Intent <Intent_name> = new Intent(<Action>,<Date>);
                    //Intent I = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://114"));
                    Intent I = new Intent(Intent.ACTION_CALL, Uri.parse("tel://" + call));
                    startActivity(I);
                }else{
                    Toast.makeText(MyCall.this,R.string.notify_incorrect_phonenum ,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
