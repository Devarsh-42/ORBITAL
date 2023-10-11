package com.example.orbital;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    private ImageView[] categoryImageViews;
    private LinearLayout[] LayoutViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the status bar color to black for Android Marshmallow and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(Color.BLACK);
        } else {
            // For versions below Android Marshmallow, use a translucent status bar
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            );
        }

        setContentView(R.layout.activity_dashboard);

        // Find the image views by their IDs
        categoryImageViews = new ImageView[3];
        categoryImageViews[0] = findViewById(R.id.horizontalImageView1);
        categoryImageViews[1] = findViewById(R.id.horizontalImageView2);
        categoryImageViews[2] = findViewById(R.id.horizontalImageView3);

        // Set OnClickListener for each image view
        for (int i = 0; i < categoryImageViews.length; i++) {
            final int categoryIndex = i;
            categoryImageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the click for the selected category
                    openNewActivity(categoryIndex);
                }
            });
        }

        // Linear Layout:
        LayoutViews = new LinearLayout[7];
        LayoutViews[0] = findViewById(R.id.AboutOS);
        LayoutViews[1] = findViewById(R.id.SS);
        LayoutViews[2] = findViewById(R.id.ComImpact);
        LayoutViews[3] = findViewById(R.id.ResourceFile);
        LayoutViews[4] = findViewById(R.id.ChallangesOS);
        LayoutViews[5] = findViewById(R.id.Future);
        LayoutViews[6] = findViewById(R.id.AboutUS);

        // Set OnClickListener for each LinearLayout
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

    private void openNewActivity1(int index) {
        Intent intent;
        switch (index) {
            case 0:
                intent = new Intent(this, Category1Activity.class);
                break;
            case 1:
                intent = new Intent(this, Category2Activity.class);
                break;
            case 2:
                intent = new Intent(this, Category3Activity.class);
                break;
            default:
                return;
        }
        intent.putExtra("categoryName", "Category " + (index + 1));
        startActivity(intent);
    }
    // Function to open a new activity based on the selected category index
    private void openNewActivity(int index) {
        Intent intent;

        // Check the index and choose the appropriate activity to launch
        switch (index) {
            case 0:
                intent = new Intent(this, AboutOpenScienceActivity.class);
                break;
            case 1:
                intent = new Intent(this, SuccessStoriesActivity.class);
                break;
            case 2:
                intent = new Intent(this, CommunityImpactActivity.class);
                break;
            case 3:
                intent = new Intent(this, OpenAccessResourceActivity.class);
                break;
            case 4:
                intent = new Intent(this, WhyNotOpenScienceActivity.class);
                break;
            case 5:
                intent = new Intent(this, FutureProspectsActivity.class);
                break;
            case 6:
                intent = new Intent(this, AboutUsActivity.class);
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
