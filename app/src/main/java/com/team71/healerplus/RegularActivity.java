package com.team71.healerplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class RegularActivity extends AppCompatActivity {

        ArrayList<String> regularDiseaseList;
        ListView ls;
    ArrayAdapter<String> arrayAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_regular);

            ls = findViewById(R.id.regularDiseaseList);

            regularDiseaseList = new ArrayList<>();
            regularDiseaseList.add("fever: seen in rainy season");
            regularDiseaseList.add("chikongunya: seen in Summer season");
            regularDiseaseList.add("malaria: seen in rainy season");
            regularDiseaseList.add("fever: seen in raniy season");
            regularDiseaseList.add("sneezing: seen in winter season");


            arrayAdapter=new ArrayAdapter<>(RegularActivity.this,
                    android.R.layout.simple_list_item_1,android.R.id.text1,regularDiseaseList);

            //setting adapter to ListView

            ls.setAdapter(arrayAdapter);



//            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    String name = (String) ls.getItemAtPosition(position);
//                    Intent i = new Intent(com.team71.healerplus.InfectiousActivity.this,InfectiousDiseaseActivity.class);
//                    i.putExtra("diseaseName",name);
//                    startActivity(i);
//                }
//            });
        }

        public void onClicker(View v){

        }


    }
