package com.youthcoding.beginnerchallenge.groceryItems.pizzaIngredients;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/15/2016.
 */
public class Tomatoes extends GroceryItemSuper {

    public Tomatoes(){
        setmName("Tomatoes");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.PRODUCE_SECTION); //borrows constant from user location class
        setmHint("Tomatoes are fruit, or vegetables, depends what side you're on.  Same place.");
    }

}
