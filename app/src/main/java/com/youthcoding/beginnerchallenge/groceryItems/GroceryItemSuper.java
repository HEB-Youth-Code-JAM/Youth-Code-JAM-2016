package com.youthcoding.beginnerchallenge.groceryItems;

import android.graphics.Bitmap;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by r730819 on 8/26/2016.
 *
 * Super class for all of the
 * grocery items
 */
public class GroceryItemSuper {
    private String mName;
    private Bitmap mBitMap;
    private int mLocation;
    private String mHint;

    //Getter and setter for ingredient name
    public String getmName(){
        return mName;
    }
    public void setmName(String setName){
        mName = setName;
    }


    //Getter and setter for the bitmap of the ingredient
    public Bitmap getmBitMap(){
        return mBitMap;
    }
    public void setmBitMap(Bitmap setBitMap){
        mBitMap = setBitMap;
    }



    //Getter and setter for the location of the item
    public int getmLocation() {
        return mLocation;
    }
    public void setmLocation(int mLocation) {
        this.mLocation = mLocation;
    }


    ///Getter and setter for the hint of the items location
    public String getmHint() {
        return mHint;
    }
    public void setmHint(String mHint) {
        this.mHint = mHint;
    }


    @Override
    public String toString() {
        return getmName();
    }

}
