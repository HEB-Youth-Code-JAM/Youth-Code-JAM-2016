package com.youthcoding.beginnerchallenge.groceryItems.hamburger;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class Bacon extends GroceryItemSuper {

    public Bacon(){
        setmName("Bacon");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.MEATS_SECTION); //borrows constant from user location class
        setmHint("Bacon bacon bacon...we know where that is...");
    }
}
