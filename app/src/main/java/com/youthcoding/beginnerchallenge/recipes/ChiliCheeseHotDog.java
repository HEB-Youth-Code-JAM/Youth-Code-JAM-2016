package com.youthcoding.beginnerchallenge.recipes;


import com.youthcoding.beginnerchallenge.groceryItems.chiliCheeseHotDog.Chili;
import com.youthcoding.beginnerchallenge.groceryItems.chiliCheeseHotDog.HotDog;
import com.youthcoding.beginnerchallenge.groceryItems.chiliCheeseHotDog.HotDogBun;
import com.youthcoding.beginnerchallenge.groceryItems.sharedIngredients.Cheese;


/**
 * Created by r730819 on 8/16/2016.
 *
 * Chili cheese hot dog recipe with 4 items
 */
public class ChiliCheeseHotDog extends RecipeSuper {


    public ChiliCheeseHotDog(){
        ingredients.add(new Cheese());
        ingredients.add(new HotDog());
        ingredients.add(new HotDogBun());
        ingredients.add(new Chili());


        description = "Chili and cheese goodness.\n\n" +
                "Needs:\n" +
                "Cheese\n" +
                "Chili\n" +
                "Hot dog bun\n" +
                "Hot dog";

    }

}
