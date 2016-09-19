package com.youthcoding.beginnerchallenge.groceryItems.macAndCheese;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class Milk extends GroceryItemSuper {

    public Milk(){
        setmName("Milk");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.DAIRY_SECTION); //borrows constant from user location class
        setmHint("You must refrigerate milk");
    }
}
