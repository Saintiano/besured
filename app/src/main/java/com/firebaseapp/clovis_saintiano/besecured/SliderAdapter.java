package com.firebaseapp.clovis_saintiano.besecured;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){

        this.context = context;

    }

    //create Arrays to store our images
    public int[] slide_images = {

            R.drawable.be_secured_name,
            R.drawable.police,
            R.drawable.map

    };

    //create Arrays for storing headings
    public String[] slide_headings = {

            "BE SECURED, BE SAFE",
            "CALL FOR HELP",
            "KNOW YOUR SURROUNDINGS"

    };

    //create Arrays for storing descriptions
    public String[] slide_descriptions = {

            "Connect to your loved ones in real time. Control who knows where are, going to or will be.",
            "Have real time access to numbers from calling a police, a toll car, ambulance, to places to relax or check-in.  ",
            "Get realtime information of where you are or going to. Be alerted when you are visiting or passing a dangerous zone."

    };

    //you can create arrays for storing background too

    @Override
    public int getCount() {

        //return the total counts of headings
        return slide_headings.length;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        //return view of the slide layout
        return view == (RelativeLayout) object;

    }

    //create this to add slide effects
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        //initialize image and text views used in out slide layout
        ImageView slideImageView = (ImageView) view.findViewById(R.id.welcome_logo);
        TextView slideHeadings = (TextView) view.findViewById(R.id.heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.description);

        //set the position of the arrays images to appear on the views
        slideImageView.setImageResource(slide_images[position]);
        slideHeadings.setText(slide_headings[position]);
        slideDescription.setText(slide_descriptions[position]);

        //add view to container
        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        //destroys the view once we reach the last page
        container.removeView((RelativeLayout) object);


    }
}
