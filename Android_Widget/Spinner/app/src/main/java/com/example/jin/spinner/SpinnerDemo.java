package com.example.jin.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by JIN on 2017/4/21.
 */

public class SpinnerDemo extends Activity {
    private static final String[] countriesStr = {"广州","从化","深圳","珠海","武汉"};
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter adapter;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myTextView = (TextView) findViewById(R.id.myTextView);
        mySpinner = (Spinner) findViewById(R.id.mysp);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item ,countriesStr);
        /*myspinner_dropdown为自定义下拉菜单样式，定义在res/layout下*/
        adapter.setDropDownViewResource(R.layout.myspinner_drordown);
        /*将ArrayAdapter对象加入到Spinner对象中*/
        mySpinner.setAdapter(adapter);

        /*将Spinner加入OnSelectedItemListener*/
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            /*A.	AdapterView在哪里被选择发生，本例中是mySpinner
            B.	显示点击的AdapterView
            C.	选择的项目在适配器的位置
            D.	选定的项目的行ID                                    */
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myTextView.setText("选择的是" + countriesStr[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //取得Animation定义，在res/anim目录下
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.anim);
        /*将Spinner加入OnTouchListener*/
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.startAnimation(myAnimation);//将mySpinner执行Animation
                v.setVisibility(View.INVISIBLE);//将mySpinner隐藏
                return false;
            }
        });
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meun, menu);
        return true;
    }
}
