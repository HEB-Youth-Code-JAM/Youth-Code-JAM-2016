package com.youthcoding.beginnerchallenge.groceryItems.sharedIngredients;


import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/15/2016.
 */
public class Cheese extends GroceryItemSuper {

    public Cheese(){
        setmName("Cheese");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.DAIRY_SECTION); //borrows constant from user location class
        setmHint("Cheeseeee, maybe not in the place you think");
    }

}
