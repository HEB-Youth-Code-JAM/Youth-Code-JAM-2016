package com.youthcoding.beginnerchallenge.user;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;

import java.util.ArrayList;


/**
 * Created by r730819 on 8/22/2016.
 * <p/>
 * This class contains the necessary
 * final variables and methods for various
 * positions around the store.  The UserSettings
 * position is changed with the positions spinner
 * overlaid on the map.
 */
public class UserSectionInStore {

    //User location choices
    public static final int ENTRANCE_1_SECTION = 1;
    public static final int ENTRANCE_2_SECTION = 2;
    public static final int PRODUCE_SECTION = 3;
    public static final int DELI_SECTION = 4;
    public static final int SEAFOOD_SECTION = 5;
    public static final int MEATS_SECTION = 6;
    public static final int FROZEN_SECTION = 7;
    public static final int GENERAL_PRODUCE_SECTION = 8;
    public static final int MISC_SECTION = 9;
    public static final int DAIRY_SECTION = 10;
    public static final int COOKING_SECTION = 11;


    // User variables
    private static int userLocation;
    private static Activity mActivity;
    public static Spinner userLocationSpinner;
    private static boolean spinnerFirstLoadFlag = true;

    //Location variables
    private static ArrayList<GroceryItemSuper> itemsInCurrentLocation = new ArrayList<>();

    public static ArrayList<GroceryItemSuper> getItemsInCurrentLocation() {
        return itemsInCurrentLocation;
    }

    public static void setItemsInCurrentLocation(ArrayList<GroceryItemSuper> itemsInCurrentLocation) {
        UserSectionInStore.itemsInCurrentLocation = itemsInCurrentLocation;
    }

    /**
     * Setter for activity when the activity is not set
     * in setMapSpinner() below.
     * <p/>
     * Only used in StoryOptionsActivity.java since
     * the choice spinner is not created in that intent
     * but only in the fragments.
     *
     * @param mActivity activity to start intent
     */
    public static void setmActivity(Activity mActivity) {
        UserSectionInStore.mActivity = mActivity;
    }


    /**
     * Getter and setter for user location
     *
     * @return int
     */
    public static int getUserLocation() {
        return userLocation;
    }

    public static void setUserLocation(int userLocation) {
        UserSectionInStore.userLocation = userLocation;
    }

    /**
     * Set the spinner to a static reference.
     * Also set the activity to parent activity
     * so new intents can be created.
     * <p/>
     * Also reset the flag for first spinner
     * load instantiation
     *
     * @param mapSpinner Spinner to change locations
     * @param activity   Parent activity
     */
    public static void setMapSpinner(Spinner mapSpinner, Activity activity) {

        userLocationSpinner = mapSpinner;

        spinnerFirstLoadFlag = true;

        mActivity = activity;

        Log.i("mActivity", activity.toString());
        Log.i("userLocationSpinner", userLocationSpinner.toString());

        createSwitchForLocationSpinner();

    }

    /**
     * Creates a switch for the location.
     * Based on the choice of the spinner,
     * the user location is updated with
     * the final int values above.
     * <p/>
     * After the user location is set, a new
     * activity is created and started.
     */
    private static void createSwitchForLocationSpinner() {

        userLocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //prevent event from firing on new spinner instantiation
                if (!spinnerFirstLoadFlag) {

                    switch (adapterView.getSelectedItem().toString()) {
                        //switch on position in store
                    }

                    Log.i("Adapter Selection", adapterView.getSelectedItem().toString());
                    StartActivityForUserLocation();

                }//end switch

                //needed to enable the spinner after load since first choice is fired on spinner init
                spinnerFirstLoadFlag = false;


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); //end on spinner select

    }//end method


    /**
     * Grabs the users location and will create a new
     * activity based off the users location.
     * <p/>
     * User location is set whenever the user location
     * spinner has a different value selected
     */
    public static void StartActivityForUserLocation() {
        Log.i("User LOCATION", String.valueOf(userLocation));
        switch (userLocation) {
            //switch and create intents
        }//end switch

        resetVariables();

    }//end method


    /**
     * Reset variables after new activity start
     * just for good measure
     */
    private static void resetVariables() {
        mActivity.finish();

        spinnerFirstLoadFlag = true;
        mActivity = null;
        userLocationSpinner = null;
    }
}//end class
