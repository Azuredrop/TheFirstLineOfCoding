package com.azuredrop.android.materialtest;

/**
 * Created by AzureDrop on 2017/5/8.
 */

public class Fruit {
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
}
