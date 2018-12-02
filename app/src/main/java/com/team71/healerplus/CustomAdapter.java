package com.team71.healerplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> countryName;

    Context context;
    LayoutInflater layoutInflater;
    ;

    public CustomAdapter(Context context, ArrayList<String> countryName){
        this.countryName = countryName;
        this.context = context;
    }

    @Override
    public int getCount() {
        return countryName.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null ){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_ly_deases,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView countryTextview = convertView.findViewById(R.id.textViewCountryName);


        countryTextview.setText(countryName.get(position));

        return convertView;
    }
}
