package com.example.jin.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ListView extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] weekStrings =new String[] {"星期日" ,"星期一" , "星期二" , "星期三" , "星期四"
                , "星期五" , "星期六"};
        ArrayAdapter<String> adapter;

        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,weekStrings);
        this.setListAdapter(adapter);
        this.getListView().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ListView.this.setTitle( ( (TextView) view).getText() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ListView.this.setTitle("NothingSelected");
            }
        });
    }
}
