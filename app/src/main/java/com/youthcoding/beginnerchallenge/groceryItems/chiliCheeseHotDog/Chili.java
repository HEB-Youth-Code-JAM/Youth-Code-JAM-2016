package com.youthcoding.beginnerchallenge.groceryItems.chiliCheeseHotDog;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class Chili extends GroceryItemSuper {

    public Chili(){
        setmName("Chili");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.MISC_SECTION); //borrows constant from user location class
        setmHint("A canned item");
    }

}
