package com.team71.healerplus;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

public class LocationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnMapReadyCallback {

    private BottomSheetBehavior mBottomSheetBehavior;
    ImageButton buttonExpand;
    private GoogleMap mMap;
    private Double lat,lon;

    HashMap<String,Double> latHm = new HashMap<>();
    HashMap<String,Double> lonHm = new HashMap<>();
    HashMap<String,String> info = new HashMap<>();

    String camp = "kutupalong";


    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if( getIntent().getExtras() != null) {
            Intent i = getIntent();
            camp = i.getStringExtra("camp");
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lat = 21.242390;
        lon = 92.139720;


        latHm.put("balukhali",21.4272);
        latHm.put("tumbru",21.433920);
        latHm.put("nayapara",20.848652);
        latHm.put("kutupalong",21.242390);

        lonHm.put("balukhali",92.0058);
        lonHm.put("tumbru",91.987030);
        lonHm.put("nayapara",452.310846);
        lonHm.put("kutupalong",92.139720);

        info.put("balukhali","LOCATION: cox's bazar, population: 23,065.");
        info.put("tumbru","LOCATION: Gundum Bazar, POPULATION: 50,000.");
        info.put("nayapara","LOCATION: Teknaf,Cox's Bazar.");
        info.put("kutupalong","LOCATION: Ukhia, Cox's Bazar.");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);


        myDialog = new Dialog(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

//        HashMap<String,Double> latHm = new HashMap<>();
//        HashMap<String,Double> lonHm = new HashMap<>();
//        HashMap<String,String> info = new HashMap<>();

//        latHm.put("balukhali",23.8103);
//        latHm.put("tumbru",24.886436);
//        latHm.put("nayapara",24.7471);
//        latHm.put("kutupalong",21.00);
//
//        lonHm.put("balukhali",90.4125);
//        lonHm.put("tumbru",91.880722);
//        lonHm.put("nayapara",90.4203);
//        lonHm.put("kutupalong",92.00);

        info.put("balukhali","LOCATION: cox's bazar, population: 23,065.");
        info.put("tumbru","LOCATION: Gundum Bazar, POPULATION: 50,000.");
        info.put("nayapara","LOCATION: Teknaf,Cox's Bazar.government-run refugee camp.");
        info.put("kutupalong","LOCATION: Ukhia, Cox's Bazar.");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(LocationActivity.this,SearchActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();


            if (id == R.id.nav_emergency) {
                Intent i = new Intent(LocationActivity.this, Emergency.class);
                startActivity(i);


                // Handle the camera action
            } else if (id == R.id.nav_share) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Use our App to know more about Refugee Camps in Bangladesh";
                String shareSubject = "Download the App";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));

            } else if (id == R.id.nav_about) {
                Intent i = new Intent(LocationActivity.this, AboutActivity.class);
                startActivity(i);

            } else if (id == R.id.nav_gallery) {
                Intent i = new Intent(LocationActivity.this, GalleryActivity.class);
                startActivity(i);

            }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;

    }


    public void dialogPopUp(View view){

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        if( getIntent().getExtras() != null) {
            Intent i = getIntent();
            camp = i.getStringExtra("camp");
        }

        LatLng location = new LatLng(lat,lon);

        Toast.makeText(this, camp+"", Toast.LENGTH_SHORT).show();

        mMap = googleMap;


//         Add a marker in Sydney and move the camera
        if(camp == null ) camp = "balukhali";

        if(camp != null) {
            if (!camp.equals("")) {
                location = new LatLng(latHm.get(camp), lonHm.get(camp));
            }
        }

//        mMap.addMarker(new MarkerOptions().position(location).title("Disease Are availablein that area"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,14));

        Marker marker = mMap.addMarker(
                new MarkerOptions()
                        .position(new LatLng(latHm.get(camp), lonHm.get(camp)))
                        .title(camp+" Refugee Camp")
                        .snippet(info.get(camp)+"")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.tenticon)));
        marker.showInfoWindow();

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                return true;
            }
        });

    }

    public void epidemic(View v) {
        Intent i = new Intent(this,epidemic.class);
        i.putExtra("camp",camp);
        startActivity(i);
    }



    public void vectorBornClickAction(View v) {

            Intent i = new Intent(this,VectorBorneActivity.class);
            i.putExtra("camp",camp);
            startActivity(i);
    }

    public void infectious(View v){

            Intent i = new Intent(this,InfectiousActivity.class);
            i.putExtra("camp",camp);
            startActivity(i);

    }


}