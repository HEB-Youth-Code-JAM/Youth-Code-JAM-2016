package com.youthcoding.beginnerchallenge.recipes;


import com.youthcoding.beginnerchallenge.groceryItems.hamburger.Bacon;
import com.youthcoding.beginnerchallenge.groceryItems.hamburger.HamburgerPatty;
import com.youthcoding.beginnerchallenge.groceryItems.hamburger.HamburgerBun;
import com.youthcoding.beginnerchallenge.groceryItems.sharedIngredients.Cheese;


/**
 * Created by r730819 on 8/16/2016.
 *
 * Chili cheese hot dog recipe with 4 items
 */
public class Hamburger extends RecipeSuper {

    public Hamburger(){
        ingredients.add(new Cheese());
        ingredients.add(new HamburgerBun());
        ingredients.add(new HamburgerPatty());
        ingredients.add(new Bacon());


        description = "A burger with BACON!\n\n" +
                "Needs:\n" +
                "Cheese\n" +
                "Hamburger Bun\n" +
                "Hamburger Patty\n" +
                "Bacon";

    }

}
