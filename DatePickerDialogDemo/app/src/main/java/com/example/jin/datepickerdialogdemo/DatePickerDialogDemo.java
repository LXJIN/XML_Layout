package com.example.jin.datepickerdialogdemo;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePickerDialogDemo extends AppCompatActivity {

    private TextView showdate;
    private Button setdate;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        showdate = (TextView)this.findViewById(R.id.showdate);
        setdate = (Button)this.findViewById(R.id.setdate);

        //初始化Calendar日历对象
        Calendar c = Calendar.getInstance(Locale.CHINA);
        //获取年月日
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        Date mydate = new Date();//获取当前日期
        c.setTime(mydate);//设置时间为当前日期
        setShowdate();//显示日期

        //添加单击事件——修改日期
        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog my_datePickDialog = new DatePickerDialog(
                        DatePickerDialogDemo.this,Datelistener,year,month,day);
                my_datePickDialog.show();//显示DatePickerDialog组件
            }
        });

    }

    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int y, int m, int d) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String time = y+"-"+m+"-"+d;
            String current_time = year+"-"+month+"-"+day;
            Date date = null;
            Date current_date = null;
            try{
                date = format.parse(time);
                current_date = format.parse(current_time);
            }catch(ParseException e){
                e.printStackTrace();
            }

            if(date.getTime() <= current_date.getTime()) {
                //修改日期
                year = y;
                month = m;
                day = d;
                //更新日期
                setShowdate();
            }else
                Toast.makeText(getApplicationContext(),"设置日期无效",Toast.LENGTH_SHORT).show();
        }
    };

    private void setShowdate(){
        //显示日期
        showdate.setText("当前日期：" + year + "-" + (month+1) + "-" + day);
    }
}
