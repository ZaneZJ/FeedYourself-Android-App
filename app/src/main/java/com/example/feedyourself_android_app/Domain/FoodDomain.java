package com.example.feedyourself_android_app.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {

    private String title;
    private String pic;
    private String description;
    private Double feel;
    private int numberInCard;

    public FoodDomain(String title, String pic, String description, Double feel) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.feel = feel;
    }

    public FoodDomain(String title, String pic, String description, Double feel, int numberInCard) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.feel = feel;
        this.numberInCard = numberInCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFeel() {
        return feel;
    }

    public void setFeel(Double feel) {
        this.feel = feel;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }

}
