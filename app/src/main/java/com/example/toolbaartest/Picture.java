package com.example.toolbaartest;

/**
 * Created by Administrator on 2017/4/7.
 */

public class Picture {
    private int imageId;
    private String name;
    public  Picture(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public int getImageId(){
        return imageId;
    }

    public String getName(){
        return name;
    }
}
