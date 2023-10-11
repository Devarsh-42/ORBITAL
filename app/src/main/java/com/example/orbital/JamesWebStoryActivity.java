package com.example.orbital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class JamesWebStoryActivity extends AppCompatActivity {
    ImageView img;
    Button BTNInfo, PaperBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_james_web_story);
        img = findViewById(R.id.InfoVideo1);
        BTNInfo = findViewById(R.id.BTNInfo);
        PaperBTN = findViewById(R.id.BTNPaper);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://youtu.be/1C_zuHf6lP4?si=qItVTQJiK9g7Br5s");
            }
        });
        ImageView leftBackButton = findViewById(R.id.leftback);
        // Set an OnClickListener for the left back button
        leftBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an explicit Intent to open the DashboardActivity
                Intent intent = new Intent(JamesWebStoryActivity.this, Dashboard.class);

                // Start the DashboardActivity
                startActivity(intent);

                // Finish the current activity (optional, depending on your navigation flow)
                finish();
            }
        });

        BTNInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://webb.nasa.gov/");
            }
        });

        PaperBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://ui.adsabs.harvard.edu/#abs/2023Natur.621..267W/abstract");
            }
        });
    }
    private void gotourl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
