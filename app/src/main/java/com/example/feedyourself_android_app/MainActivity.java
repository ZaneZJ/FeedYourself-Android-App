package com.example.feedyourself_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
//    private int timesClicked = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState){

        try {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

//            final Button button = findViewById(R.id.button);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(), "chau", Toast.LENGTH_SHORT).show();
//                    timesClicked++;
//                    button.setText(String.valueOf(timesClicked));
//                }
//            });

        } catch(Exception e) {
            Log.e(TAG,e.getMessage(),e);
        }

    }
}