package com.firebaseapp.clovis_saintiano.besecured.bottom_view_helper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.MenuItem;


import com.firebaseapp.clovis_saintiano.besecured.R;
import com.firebaseapp.clovis_saintiano.besecured.navigation_activities.GetHelp_Activity;
import com.firebaseapp.clovis_saintiano.besecured.navigation_activities.Home_Activity;
import com.firebaseapp.clovis_saintiano.besecured.navigation_activities.Map_Activity;
import com.firebaseapp.clovis_saintiano.besecured.navigation_activities.Places_Activity;
import com.firebaseapp.clovis_saintiano.besecured.navigation_activities.Profile_Activity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationView {

    //because we are going to be using this in many places

    public static void setUpBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    //How to be navigating between activities

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){

        view.setOnNavigationItemSelectedListener(new android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //implement a switch statement to navigate the items and fire the intents

                switch (item.getItemId()){

                    case R.id.ic_house:

                        Intent intent1 = new Intent(context, Home_Activity.class); //ACTIVITY_NUM = 0
                        context.startActivity(intent1);

                        break;

                    case R.id.ic_medications:

                        Intent intent2 = new Intent(context, GetHelp_Activity.class); //ACTIVITY_NUM = 1
                        context.startActivity(intent2);

                        break;

                    case R.id.ic_notifications:

                        Intent intent3 = new Intent(context, Map_Activity.class); //ACTIVITY_NUM = 2
                        context.startActivity(intent3);

                        break;

                    case R.id.ic_report:

                        Intent intent4 = new Intent(context, Places_Activity.class); //ACTIVITY_NUM = 3
                        context.startActivity(intent4);

                        break;

                    case R.id.ic_profile:

                        Intent intent5 = new Intent(context, Profile_Activity.class); //ACTIVITY_NUM = 4
                        context.startActivity(intent5);

                        break;

                }

                return false;
            }
        });

    }

}