package com.team71.healerplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

public class ContactAdapter extends BaseAdapter {

    ArrayList<String> countryName;
    ArrayList<String> countryDetail;
    int[] flags;
    Context context;
    LayoutInflater layoutInflater;
    Set<View> viewSet;

    public ContactAdapter(Context context, ArrayList<String> countryName, ArrayList<String> countryDetail){
        this.countryName = countryName;
        this.countryDetail = countryDetail;
        this.context = context;
//        viewSet = new android.support.v4.util.ArraySet<View>();

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
            convertView = layoutInflater.inflate(R.layout.row_layout,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView countryTextview = convertView.findViewById(R.id.textViewDetail);
        TextView countryTextview1 = convertView.findViewById(R.id.textViewCountryName);

        imageView.setImageResource(R.drawable.ic_call_black_24dp);
        countryTextview.setText(countryName.get(position));
        countryTextview1.setText(countryDetail.get(position));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //write yyrbrgotypoty
            }
        });

        return convertView;
    }
}
