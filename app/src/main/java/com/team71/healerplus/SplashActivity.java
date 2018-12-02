package com.team71.healerplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {




    public void clickstart (View view){
        Intent intent=new Intent(SplashActivity.this,Slide1.class);
        startActivity(intent);
    }

    LinearLayout l1,l2;
    Button btnsub;
    private ImageView rocket;
    private ImageView imageView1;

    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnsub = (Button)findViewById(R.id.buttonsub);
        // rocket=(ImageView) findViewById(R.id.rocket);
        imageView1=(ImageView) findViewById(R.id.imageview1);

        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        //Animation cameraAnimation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.downtoup2);
        Animation cameraAnimation1= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.downtoup3);

        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
        //rocket.setAnimation(cameraAnimation);
        imageView1.setAnimation(cameraAnimation1);

    }
}
