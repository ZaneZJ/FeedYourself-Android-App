package com.example.feedyourself_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.feedyourself_android_app.Adapter.CategoryAdapter;
import com.example.feedyourself_android_app.Domain.CategoryDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
//    private int timesClicked = 0;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

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

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","pizza"));
        categoryList.add(new CategoryDomain("Burger","burger"));
        categoryList.add(new CategoryDomain("Salad","salad"));
        categoryList.add(new CategoryDomain("Dessert","dessert"));
        categoryList.add(new CategoryDomain("Soup","soup"));
        categoryList.add(new CategoryDomain("Coffee","coffee"));
        categoryList.add(new CategoryDomain("Cocktail","cocktail"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}