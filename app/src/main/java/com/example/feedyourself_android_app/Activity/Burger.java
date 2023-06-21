package com.example.feedyourself_android_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.feedyourself_android_app.Adapter.FoodDataAdapter;
import com.example.feedyourself_android_app.MainActivity;
import com.example.feedyourself_android_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Burger extends AppCompatActivity {

    private List<FoodData> foodList;
    private RecyclerView foodRecyclerView;
    private FoodDataAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        foodRecyclerView = findViewById(R.id.FoodList);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodRecyclerView.setHasFixedSize(true);

        foodList = new ArrayList<>(); // Initialize the list

        // Create and set the adapter
        foodAdapter = new FoodDataAdapter(foodList);
        foodRecyclerView.setAdapter(foodAdapter);

        // Retrieve data from Firebase Realtime Database
        FirebaseDatabase.getInstance().getReference("Burger")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @SuppressLint("NotifyDataSetChanged")
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot foodSnapshot : dataSnapshot.getChildren()) {
                            String name = foodSnapshot.child("name").getValue(String.class);
                            String price = foodSnapshot.child("price").getValue(String.class);
                            String ingredients = foodSnapshot.child("ingredients").getValue(String.class);
                            String imageUrl = foodSnapshot.child("imageUrl").getValue(String.class);

                            FoodData food = new FoodData(name, price, ingredients, imageUrl);
                            foodList.add(food);
                        }

                        // Notify the adapter that the data has changed
                        foodAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }

                });

        View homeBtn = findViewById(R.id.homebtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Burger.this, MainActivity.class));
            }
        });

        View profileBtn = findViewById(R.id.profilebtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Burger.this, Profile.class));
            }
        });

    }
}