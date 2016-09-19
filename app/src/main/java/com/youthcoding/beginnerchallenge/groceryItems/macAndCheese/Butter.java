package com.youthcoding.beginnerchallenge.groceryItems.macAndCheese;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class Butter extends GroceryItemSuper {


    public Butter(){
        setmName("Butter");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.DAIRY_SECTION); //borrows constant from user location class
        setmHint("If butter gets too warm it melts!");
    }
}
