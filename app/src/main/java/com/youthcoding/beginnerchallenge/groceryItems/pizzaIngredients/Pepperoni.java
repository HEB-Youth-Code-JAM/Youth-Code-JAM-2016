package com.youthcoding.beginnerchallenge.groceryItems.pizzaIngredients;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;

/**
 * Created by r730819 on 8/15/2016.
 */
public class Pepperoni extends GroceryItemSuper {

    public Pepperoni(){
        setmName("Pepperoni");
        setmBitMap(null);//todo set
        setmLocation(UserSectionInStore.MEATS_SECTION); //borrows constant from user location class
        setmHint("Not necessarily refrigerated, but usually in a cool area ");
    }

}
