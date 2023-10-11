package com.example.orbital;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeText;
    private String fullText = "Welcome to ORBITAL";
    private int charIndex = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // For Android Marshmallow (API level 23) and above
            getWindow().setStatusBarColor(Color.BLACK);
        } else {
            // For versions below Android Marshmallow, you can use a translucent status bar
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            );
        }
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText(""); // Clear the text initially

        // Start displaying characters one by one
        displayTextOneByOne();
    }

    private void displayTextOneByOne() {
        if (charIndex < fullText.length()) {
            // Get the next character and append it to the TextView
            char nextChar = fullText.charAt(charIndex);
            welcomeText.append(String.valueOf(nextChar));

            // Increment the character index and post a delayed runnable
            charIndex++;
            handler.postDelayed(this::displayTextOneByOne, 100); // Delay between characters (adjust as needed)
        } else {
            // Text display is complete, start a new activity here
            startNewActivity();
        }
    }

    private void startNewActivity() {
        // Delay for at least 0.5 seconds (500 milliseconds)
        handler.postDelayed(() -> {
            // Create an Intent to start the new activity
            Intent intent = new Intent(this, Dashboard.class);
            startActivity(intent);

            // Finish the current activity if you want to close it
            finish();
        }, 1000); // Delay of 500 milliseconds
    }
}