package com.example.feedyourself_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.feedyourself_android_app.Activity.Burger;
import com.example.feedyourself_android_app.Activity.IntroActivity;
import com.example.feedyourself_android_app.Activity.LoginActivity;
import com.example.feedyourself_android_app.Activity.Pizza;
import com.example.feedyourself_android_app.Activity.Profile;
import com.example.feedyourself_android_app.Activity.myUser;
import com.example.feedyourself_android_app.Adapter.CategoryAdapter;
import com.example.feedyourself_android_app.Domain.CategoryDomain;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
//    private int timesClicked = 0;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                startActivity(new Intent(MainActivity.this, Pizza.class));
            }
        });

        ConstraintLayout constraintLayout1 = findViewById(R.id.mainLayout1);
        constraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                startActivity(new Intent(MainActivity.this, Burger.class));
            }
        });

        View profileBtn = findViewById(R.id.profilebtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Profile.class));
            }
        });

        myUser user = (myUser) getApplication();
        GoogleSignInAccount account = user.getGoogleSignInAccount();

        Uri personPhoto = account.getPhotoUrl();
        if (personPhoto != null) {
            Log.d("Profile Picture URL", String.valueOf(personPhoto));
        } else {
            Log.d("Profile Picture URL", "No picture URL");
        }

        ImageView profileImage = findViewById(R.id.roundedImageView);
        Glide.with(this)
                .load(personPhoto)
                .apply(RequestOptions.placeholderOf(R.drawable.user_picture_test)
                        .error(R.drawable.user_picture_test))
                .into(profileImage);

        String personName = account.getDisplayName();
        TextView t = (TextView) findViewById(R.id.textView2);
        if (t != null) {
            t.setText("Hi "+ personName + "!");
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