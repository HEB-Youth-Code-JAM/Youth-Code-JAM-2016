package com.youthcoding.beginnerchallenge.groceryItems.macAndCheese;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class Noodles extends GroceryItemSuper {


    public Noodles(){
        setmName("Noodles");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.GENERAL_PRODUCE_SECTION); //borrows constant from user location class
        setmHint("Close to a bread item technically...");
    }
}
