package com.example.feedyourself_android_app.Activity;

import java.io.Serializable;

public class FoodData implements Serializable {
    private String name;
    private String price;
    private String ingredients;

    private String imageUrl;

    public FoodData(String name, String price, String ingredients, String imageUrl) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
