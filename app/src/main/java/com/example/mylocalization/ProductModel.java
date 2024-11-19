package com.example.mylocalization;

import androidx.annotation.NonNull;

public class ProductModel {
    private String name;
    private String price;
    private String store;
    private String date;
    private String rating;
    private String countRating;
    private String size;
    private String color;
    private String desc;
    private int image;

    public ProductModel(String name, String price, String store, String date, String rating, String countRating, String size, String color, String desc, int image) {
        this.name = name;
        this.price = price;
        this.store = store;
        this.date = date;
        this.rating = rating;
        this.countRating = countRating;
        this.size = size;
        this.color = color;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCountRating() {
        return countRating;
    }

    public void setCountRating(String countRating) {
        this.countRating = countRating;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return "ProductModel{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", store='" + store + '\'' +
                ", date='" + date + '\'' +
                ", rating='" + rating + '\'' +
                ", countRating='" + countRating + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", desc='" + desc + '\'' +
                ", image=" + image +
                '}';
    }
}
