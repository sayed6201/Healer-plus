package com.team71.healerplus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;

public class SlideAdapter extends PagerAdapter {


    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.slide01,
            R.drawable.slide02,

    };
    // list of titles
    public String[] lst_title = {
            "Diseases",
            "Map",

    }   ;
    // list of descriptions
    public String[] lst_description = {
            "There are so many different diseases\n" +
                    " in different places all over the world.\n" +
                    "Before going to any places, you should \n" +
                    "know about diseases in that place.\n" +
                    "So if you want to know, \n" +
                    "this app is for you!",

            "it will give you real time info\n" +
                    "via Google map ",


    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(255,85,85),
            Color.rgb(1,85,215),

    };


    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        Button btnGo = view.findViewById(R.id.go_Btn);

        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);

        if(position == 1){
            btnGo.setVisibility(View.VISIBLE);
            btnGo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context,LocationActivity.class);
                    context.startActivity(i);
                    ((Activity)context).finish();
                }
            });
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
