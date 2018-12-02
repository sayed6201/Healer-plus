package com.team71.healerplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.team71.healerplus.model.DiseaseModel;

import java.util.ArrayList;

public class InfectiousActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    String diseaseTips= "";
    String camp;

    ArrayList<String> infectiousDiseaseList = new ArrayList<>();
    ArrayList<String> urlList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ListView ls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infectious);

        ls = findViewById(R.id.infectiousDiseaseList);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        camp="kutupalong";

        if(getIntent().getExtras()!=null){
            Intent i = getIntent();
            camp = i.getStringExtra("camp");
        }

        infectiousDiseaseRetrieve(camp);


        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) ls.getItemAtPosition(position);
                String url = urlList.get(position);

                Intent i = new Intent(InfectiousActivity.this,InfectiousDiseaseActivity.class);
                i.putExtra("camp",camp);
                i.putExtra("diseaseName",name);
                i.putExtra("imgUrl",url);
                startActivity(i);
            }
        });
    }


    public void infectiousDiseaseRetrieve(String camp){
        // Read from the database

        myRef.child(camp)
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot disease: dataSnapshot.getChildren()){
                            DiseaseModel obj = disease.getValue(DiseaseModel.class);
                            if(obj.getDiseaseType().equals("infectious")){
                                infectiousDiseaseList.add(obj.getName());
                                urlList.add(obj.getImgUrl());
                            }
                        }
                        arrayAdapter=new ArrayAdapter<String>(InfectiousActivity.this,
                                android.R.layout.simple_list_item_1,android.R.id.text1,infectiousDiseaseList);
                        //setting adapter to ListView
                        ls.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
    }

//    public String infectiousDiseaseTipsRetrieve(String countryName, String diseaseName){
//        // Read from the database
//
//        myRef.child("infectious").child(countryName).child(diseaseName)
//                .addValueEventListener(new ValueEventListener() {
//
//
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        diseaseTips = (String) dataSnapshot.child("tips").getValue();
////                            diseaseKey.add((String) disease.getValue());
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//
//                    }
//                });
//
//        return diseaseTips;
//    }
}
