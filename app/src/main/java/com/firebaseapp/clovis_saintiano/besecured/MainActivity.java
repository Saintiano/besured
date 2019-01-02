package com.firebaseapp.clovis_saintiano.besecured;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebaseapp.clovis_saintiano.besecured.navigation_activities.Home_Activity;

public class MainActivity extends AppCompatActivity {




    private ViewPager slideViewPager;
    private LinearLayout mDotslayout;

    private SliderAdapter sliderAdapter;

    //create an array textview to store slider dots
    private TextView[] mDots;

    //add fields for buttons
    private Button previousButton;
    private Button nextButton;

    //add an integer for the current page
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize
        slideViewPager = (ViewPager) findViewById(R.id.slide_view_pager);
        mDotslayout = (LinearLayout) findViewById(R.id.dots_layout);

        previousButton = (Button) findViewById(R.id.previousButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        sliderAdapter = new SliderAdapter(this);

        slideViewPager.setAdapter(sliderAdapter);

        //calling the add indicator dot method
        addDotsIndicator(0);

        //takes us to on slidepager
        slideViewPager.addOnPageChangeListener(viewListener);

        //adding on click listener to the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentPage == 0){

                    slideViewPager.setCurrentItem(currentPage + 1);

                }else if (currentPage == mDots.length - 1){

                    startActivity(new Intent(MainActivity.this, Login_Activity.class));
                    finish();

                }else{

                    slideViewPager.setCurrentItem(currentPage + 1);

                }


            }
        });


        //add on click listener for the previous button
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slideViewPager.setCurrentItem(currentPage - 1);

            }
        });



    }

    //create a methods for the dots, that counts the number of items needed
    public void addDotsIndicator(int position){

        //number of positions of our slider
        mDots = new TextView[3];

        //to remove all views if not, you get multiple dots in the views
        mDotslayout.removeAllViews();

        //looping through the length of dot indicators and assigning a text view to it
        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));

            //giving the text a size
            mDots[i].setTextSize(35);

            //setting the textcolor
            mDots[i].setTextColor(getResources().getColor(R.color.color_transparent_white));

            //add to out linearlayout
            mDotslayout.addView(mDots[i]);
        }

        if (mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.color_white));

        }

    }

    //A method to show the current slider we are on
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



        }

        @Override
        public void onPageSelected(int position) {

            //
            addDotsIndicator(position);

            //sets the current page to the integer
            currentPage = position;

            //using an if statement to block the user from going back and going to the next activity
            if (position == 0){

                nextButton.setEnabled(true);
                previousButton.setEnabled(false);

                //hide previous button on the first page
                previousButton.setVisibility(View.INVISIBLE);

                //set text on next button
                nextButton.setText("Next");
                previousButton.setText("");

            }else if (position == mDots.length - 1){

                nextButton.setEnabled(true);
                previousButton.setEnabled(true);

                //hide previous button on the first page
                previousButton.setVisibility(View.VISIBLE);

                //set text on next button
                nextButton.setText("Finish");
                previousButton.setText("Back");

            }else{

                nextButton.setEnabled(true);
                previousButton.setEnabled(true);

                //hide previous button on the first page
                previousButton.setVisibility(View.VISIBLE);

                //set text on next button
                nextButton.setText("Next");
                previousButton.setText("Back");


            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {



        }
    };

}
