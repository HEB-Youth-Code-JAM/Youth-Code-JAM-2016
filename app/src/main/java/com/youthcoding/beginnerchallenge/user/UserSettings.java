package com.youthcoding.beginnerchallenge.user;

import com.youthcoding.beginnerchallenge.recipes.RecipeSuper;

/**
 * Created by r730819 on 8/15/2016.
 * <p/>
 * All the users settings in one place.
 */
public class UserSettings {
    private static String firstName;
    private static String nickName;
    private static RecipeSuper favoriteRecipe;

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String userName) {
        UserSettings.firstName = userName;
    }

    public static String getNickName() {
        return nickName;
    }

    public static void setNickName(String nickName) {
        UserSettings.nickName = nickName;
    }

    public static RecipeSuper getFavoriteRecipe() {
        return favoriteRecipe;
    }

    public static void setFavoriteRecipe(RecipeSuper favoriteRecipe) {
        UserSettings.favoriteRecipe = favoriteRecipe;
    }


    /**
     * Receives a string from the story settings spinner
     * and either sets the users location to 1 or 2
     *
     * @param userLocation String -> int
     */
    public static void setUserLocation(String userLocation) {
        switch (userLocation) {
            case "Entrance 1": {
                UserSectionInStore.setUserLocation(UserSectionInStore.ENTRANCE_1_SECTION);
                break;
            }
            case "Entrance 2": {
                UserSectionInStore.setUserLocation(UserSectionInStore.ENTRANCE_2_SECTION);
                break;
            }
        }


    }


}
