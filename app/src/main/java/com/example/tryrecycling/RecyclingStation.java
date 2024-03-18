package com.example.tryrecycling;

public class RecyclingStation {
    private String name;
    private String address;
    private int imageResId;

    public RecyclingStation(String name, String address, int imageResId) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }
}