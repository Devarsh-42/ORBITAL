package com.example.orbital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ArtimesStoryActivity extends AppCompatActivity {
    ImageView img;
    Button BTNInfo, PaperBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artimes_story);
        img = findViewById(R.id.InfoVideo1);
        BTNInfo = findViewById(R.id.BTNInfo);
        PaperBTN = findViewById(R.id.BTNPaper);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.youtube.com/watch?v=lPyl6d2FJGw");
            }
        });
        ImageView leftBackButton = findViewById(R.id.leftback);
        // Set an OnClickListener for the left back button
        leftBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an explicit Intent to open the DashboardActivity
                Intent intent = new Intent(ArtimesStoryActivity.this, Dashboard.class);

                // Start the DashboardActivity
                startActivity(intent);

                // Finish the current activity (optional, depending on your navigation flow)
                finish();
            }
        });
        BTNInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.nasa.gov/specials/artemis/");
            }
        });
        PaperBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.sciencedirect.com/science/article/pii/S0094576520304598?ref=pdf_download&fr=RR-2&rr=812f5a939b5629eb");
            }
        });
    }
    private void gotourl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}