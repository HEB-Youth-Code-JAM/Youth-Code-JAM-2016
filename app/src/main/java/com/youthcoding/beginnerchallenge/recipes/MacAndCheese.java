package com.youthcoding.beginnerchallenge.recipes;


import com.youthcoding.beginnerchallenge.groceryItems.macAndCheese.Butter;
import com.youthcoding.beginnerchallenge.groceryItems.macAndCheese.Milk;
import com.youthcoding.beginnerchallenge.groceryItems.macAndCheese.Noodles;
import com.youthcoding.beginnerchallenge.groceryItems.sharedIngredients.Cheese;

/**
 * Created by r730819 on 8/15/2016.
 *
 * Mac and cheese recipe with 3 ingredients
 */
public class MacAndCheese extends RecipeSuper {


    public MacAndCheese(){
        ingredients.add(new Cheese());
        ingredients.add(new Butter());
        ingredients.add(new Noodles());
        ingredients.add(new Milk());

        description = "Mac and cheese!\n\n" +
                "Needs:\n" +
                "Cheese\n" +
                "Noodles\n" +
                "Butter\n" +
                "Milk";

    }

}
