package com.example.jin.menusub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.SubMenu;

public class MenuSUB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu sub=menu.addSubMenu(R.string.title);
        sub.setIcon(android.R.drawable.ic_menu_search);
        sub.add(0,1,1,R.string.local);
        sub.add(0,2,2,R.string.network);
        return super.onCreateOptionsMenu(menu);
    }
}
