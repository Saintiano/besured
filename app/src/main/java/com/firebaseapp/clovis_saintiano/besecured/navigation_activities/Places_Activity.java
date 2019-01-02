package com.firebaseapp.clovis_saintiano.besecured.navigation_activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firebaseapp.clovis_saintiano.besecured.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Places_Activity extends AppCompatActivity {


    private static final int ACTIVITY_NUM = 3;

    private Context mContext = Places_Activity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_);


        //setup for bottom navigation
        setUpBottomNavigationView();

    }


    /**
     * bottom navigation view setup
     */

    private void setUpBottomNavigationView(){

        BottomNavigationViewEx buttomNavigationViewEx = ( BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        com.firebaseapp.clovis_saintiano.besecured.bottom_view_helper.BottomNavigationView.setUpBottomNavigationView(buttomNavigationViewEx);

        //Enable bottom activity in each activities / items
        com.firebaseapp.clovis_saintiano.besecured.bottom_view_helper.BottomNavigationView.enableNavigation(mContext, buttomNavigationViewEx);

        Menu menu = buttomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }

}
