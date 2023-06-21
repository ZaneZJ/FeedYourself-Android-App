package com.example.feedyourself_android_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.feedyourself_android_app.Adapter.FoodDataAdapter;
import com.example.feedyourself_android_app.MainActivity;
import com.example.feedyourself_android_app.R;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        RecyclerView recyclerView = findViewById(R.id.FoodList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FoodData foodData = (FoodData) getIntent().getSerializableExtra("FoodData");
        List<FoodData> foodDataList = new ArrayList<>();
        foodDataList.add(foodData);

        FoodDataAdapter adapter = new FoodDataAdapter(foodDataList);
        recyclerView.setAdapter(adapter);


        View homeBtn = findViewById(R.id.homebtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutActivity.this, MainActivity.class));
            }
        });

        View profileBtn = findViewById(R.id.profilebtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutActivity.this, Profile.class));
            }
        });


    }
}