package com.youthcoding.beginnerchallenge.groceryItems.hamburger;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class HamburgerBun extends GroceryItemSuper {


    public HamburgerBun(){
        setmName("Hamburger Bun");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.GENERAL_PRODUCE_SECTION); //borrows constant from user location class
        setmHint("A bread item");
    }
}
