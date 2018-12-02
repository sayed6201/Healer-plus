package com.team71.healerplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        iv = findViewById(R.id.imageView);

        Picasso.get()
            .load("https://firebasestorage.googleapis.com/v0/b/healerplus-39542.appspot.com/o/Capture.PNG?alt=media&token=611ee263-de1c-4ba9-805a-efa2e3e9a3b6")
            .placeholder(R.mipmap.ic_launcher)
            .fit()
            .centerCrop()
            .into(iv);


    }
}
