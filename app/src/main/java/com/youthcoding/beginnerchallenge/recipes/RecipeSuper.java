package com.youthcoding.beginnerchallenge.recipes;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserShoppingCart;
import java.util.ArrayList;

/**
 * Created by r730819 on 8/15/2016.
 *
 * Recipe super class to do the base
 * functions on all recipes
 */
public abstract class RecipeSuper{
    String description = "A generic food description to be overridden.";
    ArrayList<GroceryItemSuper> ingredients = new ArrayList<>();

    public ArrayList<GroceryItemSuper> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<GroceryItemSuper> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Loop through the users shopping cart.
     *
     * If the shopping cart does not contain
     * an item from the required ingredients
     * then the required item is added to a list.
     *
     * @return An Array list containing all missing items
     */
    public ArrayList<GroceryItemSuper> checkForItems() {

        ArrayList<GroceryItemSuper> requiredItems = new ArrayList<>();

        for(GroceryItemSuper requiredItem : ingredients){
            int counter = 0;

            for(GroceryItemSuper userShoppingCartItem : UserShoppingCart.getShoppingCart()){
                if(userShoppingCartItem.getClass().isInstance(requiredItem)){
                    counter++;
                }
            }

            if(counter == 0){
                requiredItems.add(requiredItem);
            }
        }

        return requiredItems;
    }

    public String getDescription(){
        return description;
    }



}
