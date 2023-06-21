package com.example.feedyourself_android_app.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.feedyourself_android_app.Activity.CheckoutActivity;
import com.example.feedyourself_android_app.Activity.FoodData;
import com.example.feedyourself_android_app.R;

import java.util.List;

public class FoodDataAdapter extends RecyclerView.Adapter<FoodDataAdapter.FoodViewHolder> {

    private static List<FoodData> foodList = null;

    public FoodDataAdapter(List<FoodData> foodList) {
        this.foodList = foodList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        FoodData food = foodList.get(position);
        holder.textViewName.setText(food.getName());
        holder.textViewPrice.setText("Price: $"+food.getPrice());
        holder.textViewIngredients.setText(String.valueOf(food.getIngredients()));

        String imageUrl = food.getImageUrl(); // Assume you have a method getImageUrl() in FoodData

        Glide.with(holder.itemView.getContext()) // Use the Context from the itemView
                .load(imageUrl)
                .apply(RequestOptions.placeholderOf(R.drawable.user_picture_test)
                        .error(R.drawable.user_picture_test))
                .into(holder.urlImage); // Use the ImageView in your ViewHolder
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewPrice;
        TextView textViewIngredients;

        ImageView urlImage;

        public FoodViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.item_food_name);
            textViewPrice = itemView.findViewById(R.id.item_food_price);
            textViewIngredients = itemView.findViewById(R.id.item_food_ingredients);
            urlImage = itemView.findViewById(R.id.item_food_image);
            View cardView = itemView.findViewById(R.id.food_cardview);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        FoodData clickedDataItem = foodList.get(position);
                        Intent intent = new Intent(view.getContext(), CheckoutActivity.class);
                        intent.putExtra("FoodData", clickedDataItem);
                        view.getContext().startActivity(intent);
                    }
                }
            });
        }
    }


}