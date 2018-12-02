package com.team71.healerplus;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    TextView seasonalTv;

    final ArrayList<String> epidemicDiseaseList = new ArrayList<>();
    final ArrayList<String> epidemicDiseaseKey = new ArrayList<>();

    final HashMap<String,String> epidemicDiseaseHm = new HashMap<>();

    String epidemicDiseaseSymptoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seasonalTv = findViewById(R.id.seasonal_disease_tv);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }

    public void onClickAction(View v){

        seasonalTv.setText(getEpidemicDiseaseSymptom("papua New Guinea","port Moresby","Poliomyelitis"));


    }

    public void seasonalDiseaseRetrieve(){
        // Read from the database
        myRef.child("seasonal/bangladesh/dhaka/summer/diseaseName")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> diseaseList = new ArrayList<>();
                ArrayList<String> diseaseKey = new ArrayList<>();
                for(DataSnapshot disease: dataSnapshot.getChildren()){
                    diseaseList.add((String) disease.getValue());
                    diseaseKey.add(disease.getKey());
                }
                seasonalTv.setText(diseaseKey.toString()+" "+diseaseList.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    public HashMap<String,String> epidimicDiseaseRetrieve(String countryName, String zoneName){
        // Read from the database

        myRef.child("epidemic/"+countryName+"/"+zoneName+"/diseaseName")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot disease: dataSnapshot.getChildren()){
//                            epidemicDiseaseList.add((String) );
//                            epidemicDiseaseKey.add();
                            epidemicDiseaseHm.put(disease.getKey(), (String) disease.getValue());
                        }
//                        seasonalTv.setText(diseaseKey.toString()+" "+diseaseList.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });
        seasonalTv.setText(epidemicDiseaseList.toString());
        return epidemicDiseaseHm;
    }

    public String getEpidemicDiseaseSymptom(String countryName, String zoneName,String diseaseName){
        // Read from the database



        myRef.child("epidemic/"+countryName+"/"+zoneName+"/"+diseaseName+"/symptoms")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        epidemicDiseaseSymptoms = (String) dataSnapshot.getValue();
                    }


                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });

        return epidemicDiseaseSymptoms;
    }


    public void seasonalCountryNames(){
        // Read from the database
        myRef.child("seasonal/countryName")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ArrayList<String> countryList = new ArrayList<>();
                        ArrayList<String> countryKey = new ArrayList<>();
                        for(DataSnapshot disease: dataSnapshot.getChildren()){
                            countryList.add((String) disease.getValue());
                            countryKey.add(disease.getKey());
                        }
                        seasonalTv.setText(countryKey.toString()+" "+countryList.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });
    }

    public ArrayList<String> epidemicCountryNames(){

        final ArrayList<String> epidemicCountryList = new ArrayList<>();
        final ArrayList<String> epidemicCountryKey = new ArrayList<>();

        myRef.child("epidemic/countryName")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot disease: dataSnapshot.getChildren()){
                            epidemicCountryList.add((String) disease.getValue());
                            epidemicCountryKey.add(disease.getKey());
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });

        return epidemicCountryList;
    }

    public ArrayList<String> infectiousDisease(){
        // Read from the database
        final ArrayList<String> diseaseList = new ArrayList<>();
        final ArrayList<String> diseaseKey = new ArrayList<>();

        myRef.child("infectious/bangladesh/diseaseName")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {



                        for(DataSnapshot disease: dataSnapshot.getChildren()){
                            diseaseList.add((String) disease.getValue());
                            diseaseKey.add(disease.getKey());
                        }
//                        seasonalTv.setText(diseaseKey.toString()+" "+diseaseList.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }

                });
        return diseaseList;
    }

    public void aboutInfectiousDisease(String countryName, String diseaseName){
        // Read from the database
        myRef.child("infectious/"+countryName+"/"+diseaseName)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ArrayList<String> list = new ArrayList<>();
                        ArrayList<String> key = new ArrayList<>();
                        for(DataSnapshot disease: dataSnapshot.getChildren()){
                            list.add((String) disease.getValue());
                            key.add(disease.getKey());
                        }
                        seasonalTv.append(key.toString()+" "+list.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
    }

    public ArrayList<Double> getCountryLatLon(String countryName){
        ArrayList<Double> latlon = new ArrayList<Double>();

        if(latlon.size() == 0){
            latlon.add(23.6850);
            latlon.add(90.3563);
            return latlon;
        }
        return latlon;
    }




}
