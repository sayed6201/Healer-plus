package com.team71.healerplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {



 Spinner spinner, customSpinner;

 List<String> list;


 @Override

protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spinner);



        /**Default Spinner**/

        spinner = (Spinner) findViewById(R.id.spinner);



        /**List Ready For Spinner/Drop Down**/

        prepareList();



        /**Set the List Values in Adaptor for Spinner**/

        ArrayAdapter<String> spinAdaptor = new ArrayAdapter<>(SpinnerActivity.this, android.R.layout.simple_spinner_item, list);

        spinner.setAdapter(spinAdaptor);

        /**When Select any item from Spinner**/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

         /**Store a Value of Selected Item**/

         String value = parent.getItemAtPosition(position).toString();

         Toast.makeText(SpinnerActivity.this, value+"", Toast.LENGTH_SHORT).show();


        }

        @Override

        public void onNothingSelected(AdapterView<?> parent) {

        }
        });


        /**Custom Spinner**/
        customSpinner = (Spinner) findViewById(R.id.customSpinner);

        ArrayAdapter<String> customSpinAdap = new ArrayAdapter<>(SpinnerActivity.this, android.R.layout.simple_spinner_item, list);

        /**Set the drop down resource with our custom dropdown layouts**/
        customSpinAdap.setDropDownViewResource(R.layout.custom_dropdown);

        customSpinner.setAdapter(customSpinAdap);

        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String value = parent.getItemAtPosition(position).toString();


        }



        @Override

         public void onNothingSelected(AdapterView<?> parent) {



        }

        });

 }



private void prepareList() {

 list = new ArrayList<>();

        /**Add Items in Spinner List**/

        list.add("Alpha");

        list.add("Beta");

        list.add("CupCake");

        list.add("Donut");

        list.add("Eclair");

        list.add("Froyo");

        list.add("GingerBread");

        list.add("HoneyComb");

        list.add("IceCream Sandwich");

        list.add("JellyBean");

        list.add("KitKat");
        list.add("Lollipop");

        list.add("MarshMellow");

        list.add("Nougat");

        list.add("Oreo");

 }

}
