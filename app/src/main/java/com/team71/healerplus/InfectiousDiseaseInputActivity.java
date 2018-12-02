package com.team71.healerplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.team71.healerplus.model.DiseaseModel;

public class InfectiousDiseaseInputActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText diseaseNameEt,diseaseSymptomsEt,diseaseTreatmentEt,diseaseMedicineEt,campNameEt,diseaseTypeEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_infectious_disease_input);

        diseaseNameEt = findViewById(R.id.disease_name_et);
        diseaseSymptomsEt = findViewById(R.id.disease_symp_et);
        diseaseTreatmentEt = findViewById(R.id.disease_treatment_et);
        diseaseMedicineEt = findViewById(R.id.disease_medicine_et);
        campNameEt = findViewById(R.id.camp_name_et);
        diseaseTypeEt = findViewById(R.id.disease_type_et);


//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    //getting artist
//                    DiseaseModel obj = postSnapshot.getValue(DiseaseModel.class);
//                    //adding artist to the list
//                    diseaseSymptomsEt.append(obj.getName());
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//
//            }
//        });

    }

    public void saveBtnClick(View v){

        // Write a message to the database

        mDatabase = FirebaseDatabase.getInstance().getReference(campNameEt.getText().toString());

        DiseaseModel obj = new DiseaseModel(diseaseTypeEt.getText().toString(),diseaseNameEt.getText().toString()
                ,diseaseSymptomsEt.getText().toString(),diseaseTreatmentEt.getText().toString(),diseaseMedicineEt.getText().toString());

        String id = mDatabase.push().getKey();

        mDatabase.child(id).setValue(obj);

    }

}
