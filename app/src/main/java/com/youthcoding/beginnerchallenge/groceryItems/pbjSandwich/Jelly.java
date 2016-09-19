package com.youthcoding.beginnerchallenge.groceryItems.pbjSandwich;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/15/2016.
 */

public class Jelly extends GroceryItemSuper {

    public Jelly(){
        setmName("Jelly");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.GENERAL_PRODUCE_SECTION); //borrows constant from user location class
        setmHint("Usually located near the bread");
    }
}
