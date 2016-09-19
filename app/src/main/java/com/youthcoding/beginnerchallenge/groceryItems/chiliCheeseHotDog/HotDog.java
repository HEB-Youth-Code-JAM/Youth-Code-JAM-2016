package com.youthcoding.beginnerchallenge.groceryItems.chiliCheeseHotDog;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class HotDog extends GroceryItemSuper {


    public HotDog(){
        setmName("Hot Dog");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.MEATS_SECTION); //borrows constant from user location class
        setmHint("What is a hot dog made out of?");
    }
}
