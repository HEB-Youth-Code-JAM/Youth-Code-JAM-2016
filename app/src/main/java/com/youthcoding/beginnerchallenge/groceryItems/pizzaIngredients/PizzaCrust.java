package com.youthcoding.beginnerchallenge.groceryItems.pizzaIngredients;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/15/2016.
 */
public class PizzaCrust extends GroceryItemSuper {

    public PizzaCrust(){
        setmName("Pizza Crust");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.GENERAL_PRODUCE_SECTION); //borrows constant from user location class
        setmHint("Pizza Crust is bread, should be close by");
    }


}
