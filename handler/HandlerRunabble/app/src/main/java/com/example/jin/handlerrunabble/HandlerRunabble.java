package com.example.jin.handlerrunabble;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class HandlerRunabble extends AppCompatActivity {
    private Button btnStart = null;
    private Button btnEnd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        btnStart.setOnClickListener(new btnStartListener());
        btnEnd.setOnClickListener(new btnEndListener());
    }

    //1、创建一个Handler对象
    Handler handler  = new Handler();

    class btnStartListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //2、调用Handler的post方法，将要执行的线程对象添加到队列当中，同样下面也有停止按钮
            handler.post(updateThread);
        }
    }

    class  btnEndListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            handler.removeCallbacks(updateThread);
        }
    }

    //3、将要执行的操作写在线程对象的run方法当中
    Runnable updateThread =  new Runnable(){
        @Override
        public void run() {
            System.out.println("UpdateThread");
            Log.v("tag", "UpdateThread");
            //在run方法内部，执行postDelayed或者是post方法
            handler.postDelayed(updateThread, 2000);
        }

    };
}
