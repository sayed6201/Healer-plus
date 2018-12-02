package com.team71.healerplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Emergency extends AppCompatActivity {

    ListView listView;

    ArrayList<String> countryName = new ArrayList<>();
    ArrayList<String> countryDetail = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference myRef;
//    int[] flags = {
//
//            R.drawable.emrgnc,
//            R.drawable.emrgnc
//    };

    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        listView = findViewById(R.id.lisviewId);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.child("emergencynumber")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot item: dataSnapshot.getChildren()){
                            countryDetail.add(item.getValue().toString());
                            countryName.add(item.getKey());
                        }
                        contactAdapter = new ContactAdapter(getApplicationContext(), countryName,countryDetail);
                        listView.setAdapter(contactAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });

//        countryName = getResources().getStringArray(R.array.countryName);
//        countryDetail = getResources().getStringArray(R.array.countryDetail);





    }

    public void onClicker(View v){

        getEmergencyNumbers();

    }

    public void getEmergencyNumbers(){
        // Read from the database
        myRef.child("emergencyNumber")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot item: dataSnapshot.getChildren()){
                            countryDetail.add(item.getValue().toString());
                            countryName.add(item.getKey());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
    }
}
