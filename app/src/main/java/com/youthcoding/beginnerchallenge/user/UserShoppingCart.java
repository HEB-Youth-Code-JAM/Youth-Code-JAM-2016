package com.youthcoding.beginnerchallenge.user;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;

import java.util.ArrayList;

/**
 * Created by r730819 on 8/16/2016.
 * <p/>
 * This class represents the users
 * shopping cart that is maintained
 * throughout the story.
 * <p/>
 * Initialized to an empty arraylist
 * and as they find items they are
 * added to this list.
 * <p/>
 * Used in RecipeSuper.java to compare
 * the cart to required items
 */
public class UserShoppingCart {
    private static ArrayList<GroceryItemSuper> shoppingCart = new ArrayList<>();


    /**
     * Getters and setters
     */
    public static ArrayList<GroceryItemSuper> getShoppingCart() {
        return shoppingCart;
    }

    public static void setShoppingCart(ArrayList<GroceryItemSuper> shoppingCart) {
        UserShoppingCart.shoppingCart = shoppingCart;
    }


    /**
     * Clearing all contents of the users shopping cart
     */
    public static void clearCart() {
        UserShoppingCart.shoppingCart.clear();
    }


}
