package com.team71.healerplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchActivity extends AppCompatActivity {

    Spinner sp;
    AutoCompleteTextView sp1;
    String[] spacecrafts={"JUn","Jully","Auguest"};
    String[] spacecrafts2={"akjdh","Jdfkjhdf","Adjuguest","Ffljdfkfdjarhan"};
    FirebaseDatabase database;
    DatabaseReference myRef;

//    ArrayList<String> countryNames;
    ArrayList<String> zoneNames;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String>adapter1;

//    String searchCountryName="";
    String searchZoneName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

//        countryNameRetrieve();
// add elements to al, including duplicates
//        Set<String> hs = new HashSet<>();
//        hs.addAll(countryNames);
//        countryNames.clear();
//        countryNames.addAll(hs);


        zoneNames = new ArrayList<>();
        zoneNames.add("kutupalong");
        zoneNames.add("tumbru");
        zoneNames.add("nayapara");
        zoneNames.add("balukhali");





//        countryNameRetrieve();

        sp = (Spinner) findViewById(R.id.sp);
//        sp1 = (AutoCompleteTextView) findViewById(R.id.sp1);

        adapter = new ArrayAdapter<>(this, R.layout.spinner_item, zoneNames);
//        adapter1=new ArrayAdapter<>(this ,R.layout.spinner_item,zoneNames);



        sp.setAdapter(adapter);
//        sp1.setAdapter(adapter1);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                if(adapter.getItem(position).equals("bangladesh")){
//                    zoneNames.clear();
//                    zoneNames.add("dhaka");
//                    zoneNames.add("chittagong");
//                    zoneNames.add("sylhet");
//                    zoneNames.add("mymensign");
//                    zoneNames.add("rangpur");
//
//                    adapter1.add(zoneNames);
//                }else if (adapter.getItem(position).equals("sudan")){
//                    zoneNames.clear();
//                    zoneNames.add("khartoum");
//                }else if (adapter.getItem(position).equals("papua New Guinea")){
//                    zoneNames.clear();
//                    zoneNames.add("port Moresby");
//                }else {
//                    zoneNames.add("No Zone added to Database for this country");
//                }
                searchZoneName = zoneNames.get(position);
//                Toast.makeText(SearchActivity.this, searchCountryName, Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });



//        sp1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                searchZoneName = adapter1.getItem(position);
////                Toast.makeText(SearchActivity.this, searchZoneName, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public void onClicker(View v){
        if(v.getId() == R.id.btn_display){
//            countryNameRetrieve();
// add elements to al, including duplicates
//            Set<String> hs = new HashSet<>();
//            hs.addAll(countryNames);
//            countryNames.clear();
//            countryNames.addAll(hs);
//             ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, countryNames);
//             ArrayAdapter<String>adapter1=new ArrayAdapter<>(this ,R.layout.spinner_item,spacecrafts2);

//            sp.setAdapter(adapter);
//            sp1.setAdapter(adapter1);

//            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                    Toast.makeText(SearchActivity.this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
//                }
//                @Override
//                public void onNothingSelected(AdapterView<?> parentView) {
//                    // your code here
//                }
//            });
//
//            sp1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(SearchActivity.this, adapter1.getItem(position), Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }

    public void searchAction(View v){
        if (v.getId() == R.id.search_btn){
            Intent i = new Intent(SearchActivity.this,LocationActivity.class);
            i.putExtra("camp",searchZoneName);
            searchZoneName = "";
            startActivity(i);
            finish();
        }
    }


//    public void countryNameRetrieve(){
//        // Read from the database
//        final ArrayList<String> countryList = new ArrayList<>();
//        final ArrayList<String> Key = new ArrayList<>();
//
//        myRef.child("seasonal/countryName")
//                .addValueEventListener(new ValueEventListener() {
//
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        for(DataSnapshot disease: dataSnapshot.getChildren()){
//                            countryList.add((String) disease.getValue());
//                            Key.add(disease.getKey());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//                    }
//
//                });
//
//
//        for( String s : countryList )
//        {
//            countryNames.add(s);
//        }
//
//        final ArrayList<String> countryList1 = new ArrayList<>();
//        final ArrayList<String> Key1 = new ArrayList<>();
//        myRef.child("infectious/countryName")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        for(DataSnapshot disease: dataSnapshot.getChildren()){
//                            countryList1.add((String) disease.getValue());
//                            Key1.add(disease.getKey());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//
//                    }
//                });
//
//        for( String s : countryList1 )
//        {
//            countryNames.add(s);
//        }
//
//        final ArrayList<String> countryList2 = new ArrayList<>();
//        final ArrayList<String> Key2 = new ArrayList<>();
//        myRef.child("epidemic/bangladesh/dhaka/summer/diseaseName")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        for(DataSnapshot disease: dataSnapshot.getChildren()){
//                            countryList2.add((String) disease.getValue());
//                            Key2.add(disease.getKey());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//
//                    }
//                });
//        for( String s : countryList2 )
//        {
//            countryNames.add(s);
//        }
//    }

}
