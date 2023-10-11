package com.example.orbital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SuccessStoriesActivity extends AppCompatActivity {
    ImageView leftBackButton;
    private LinearLayout[] LayoutViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(Color.BLACK);
        } else {
            // For versions below Android Marshmallow, use a translucent status bar
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            );
        }
        setContentView(R.layout.activity_success_stories);


        ImageView leftBackButton = findViewById(R.id.leftback);
        leftBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an explicit Intent to open the DashboardActivity
                Intent intent = new Intent(SuccessStoriesActivity.this, Dashboard.class);

                // Start the DashboardActivity
                startActivity(intent);

                // Finish the current activity (optional, depending on your navigation flow)
                finish();
            }
        });
        LayoutViews = new LinearLayout[4];
        LayoutViews[0] = findViewById(R.id.JamesWeb);
        LayoutViews[1] = findViewById(R.id.ARTEMIS2);
        LayoutViews[2] = findViewById(R.id.SolarProbe);
        LayoutViews[3] = findViewById(R.id.MoxieMarsOS);

        for (int i = 0; i < LayoutViews.length; i++) {
            final int layoutIndex = i;
            LayoutViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the click for the selected category
                    openNewActivity(layoutIndex);
                }
            });
        }
    }
    private void openNewActivity(int index) {
        Intent intent;

        // Check the index and choose the appropriate activity to launch
        switch (index) {
            case 0:
                intent = new Intent(this, JamesWebStoryActivity.class);
                break;
            case 1:
                intent = new Intent(this, ArtimesStoryActivity.class);
                break;
            case 2:
                intent = new Intent(this, SolarProbeStoryActivity.class);
                break;
            case 3:
                intent = new Intent(this, MoxieMarsStoryActivity.class);
                break;
            default:
                // Handle other cases or show an error message
                return;
        }

        // Pass any necessary data to the new activity using intent extras
        intent.putExtra("categoryName", "Category " + (index + 1));
        startActivity(intent);
    }
}
