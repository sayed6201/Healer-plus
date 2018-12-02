package com.team71.healerplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.team71.healerplus.model.DiseaseModel;

import java.util.ArrayList;

public class Disease extends AppCompatActivity {

    TextView diseaseNameTv,diseaseSymptomsTv,diseaseMedicineTv,diseaseTypeTv,diseaseTreatmentTv;
    ImageView profile_image;

    FirebaseDatabase database;
    DatabaseReference myRef;


    String camp = "";
    String diseaseName= "";
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        profile_image = findViewById(R.id.profile_image);

        Intent i;

        if( getIntent().getExtras() != null){
            i = getIntent();
            diseaseName = i.getStringExtra("diseaseName");
            camp = i.getStringExtra("camp");
            url = i.getStringExtra("imgUrl");
        }

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        Picasso.get()
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(profile_image);

        diseaseSymptomsTv = findViewById(R.id.disease_symptoms);
        diseaseNameTv = findViewById(R.id.disease_name);
        diseaseMedicineTv = findViewById(R.id.disease_medicine);
        diseaseTypeTv = findViewById(R.id.disease_type);
        diseaseTreatmentTv = findViewById(R.id.disease_treatment);

        infectiousDiseaseDetailRetrieve(camp,diseaseName);


    }


    public void infectiousDiseaseDetailRetrieve(String camp, final String diseaseName){
        // Read from the database

        myRef.child(camp)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot disease: dataSnapshot.getChildren()){
                            DiseaseModel obj = disease.getValue(DiseaseModel.class);

                            if(obj.getName().equals(diseaseName)){
                                diseaseSymptomsTv.setText("SYMPTOMS: "+obj.getSymptoms());
                                diseaseNameTv.setText("DISEASE NAME: "+obj.getName());
                                diseaseMedicineTv.setText("MEDICINE: "+obj.getMedicine());
                                diseaseTypeTv.setText("DISEASE TYPE: "+obj.getDiseaseType());
                                diseaseTreatmentTv.setText("TRATMENT: "+obj.getTreatment());
                                break;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });

    }
}
