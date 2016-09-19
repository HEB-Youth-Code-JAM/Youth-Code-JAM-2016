package com.youthcoding.beginnerchallenge.groceryItems.hamburger;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/16/2016.
 */
public class HamburgerPatty extends GroceryItemSuper {


    public HamburgerPatty(){
        setmName("Hamburger Patty");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.MEATS_SECTION); //borrows constant from user location class
        setmHint("Hamburgers are made out of?");
    }
}
