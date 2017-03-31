package com.example.jin.logactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LogActivity extends AppCompatActivity {
    static final String LIFT_TAG="LogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        Log.v(LogActivity.LIFT_TAG, "FirstAcvity ---> onCreate");
        Button myButton = (Button)findViewById(R.id.myButton);
        myButton.setOnClickListener(new ButtonOnClickListener());
    }

    class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(LogActivity.this,LogActivity2.class);
            LogActivity.this.startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        Log.v(LogActivity.LIFT_TAG,"FirstAcvity --->onDestory");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Log.v(LogActivity.LIFT_TAG, "FirstAcvity --->onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        Log.v(LogActivity.LIFT_TAG, "FirstAcvity --->onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Log.v(LogActivity.LIFT_TAG, "FirstAcvity --->onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        Log.v(LogActivity.LIFT_TAG, "FirstAcvity --->onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Log.v(LogActivity.LIFT_TAG, "FirstAcvity --->onStop");
        super.onStop();
    }
}
