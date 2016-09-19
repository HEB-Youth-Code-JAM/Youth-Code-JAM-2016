package com.youthcoding.beginnerchallenge.recipes;

import com.youthcoding.beginnerchallenge.groceryItems.pizzaIngredients.Pepperoni;
import com.youthcoding.beginnerchallenge.groceryItems.sharedIngredients.Cheese;
import com.youthcoding.beginnerchallenge.groceryItems.pizzaIngredients.PizzaCrust;
import com.youthcoding.beginnerchallenge.groceryItems.pizzaIngredients.Tomatoes;

/**
 * Pizza recipe with 4 ingredients.
 *
 * todo - Higher score with more ingredients? Or just balance to only 3
 */
public class Pizza extends RecipeSuper {

    public Pizza(){
        ingredients.add(new Tomatoes());
        ingredients.add(new Pepperoni());
        ingredients.add(new Cheese());
        ingredients.add(new PizzaCrust());

        description = "Cheese Pizza? Classic.\n\n" +
                "Needs:\n" +
                "Cheese\n" +
                "Pizza Crust\n" +
                "Tomatoes ";
    }


}