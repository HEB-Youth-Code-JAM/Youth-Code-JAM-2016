package com.youthcoding.beginnerchallenge.recipes;

import com.youthcoding.beginnerchallenge.groceryItems.pbjSandwich.Bread;
import com.youthcoding.beginnerchallenge.groceryItems.pbjSandwich.Jelly;
import com.youthcoding.beginnerchallenge.groceryItems.pbjSandwich.PeanutButter;

/**
 * Created by r730819 on 8/15/2016.
 *
 * Peanut butter and jelly recipe with 3 ingredients
 */
public class PeanutButterAndJelly extends RecipeSuper {


    public PeanutButterAndJelly(){
        ingredients.add(new Bread());
        ingredients.add(new Jelly());
        ingredients.add(new PeanutButter());

        description = "A delicious Peanut Butter and Jelly Sandwich" +
                " with only the finest ingredients.\n\n" +
                "Needs:\n" +
                "Peanut Butter\n" +
                "Jelly\n" +
                "Bread";

    }

}
