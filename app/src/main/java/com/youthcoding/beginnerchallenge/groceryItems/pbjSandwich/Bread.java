package com.youthcoding.beginnerchallenge.groceryItems.pbjSandwich;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/15/2016.
 */
public class Bread extends GroceryItemSuper {

    public Bread(){
        setmName("Bread");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.GENERAL_PRODUCE_SECTION); //borrows constant from user location class
        setmHint("Not too hot...not too cold");
    }
}
