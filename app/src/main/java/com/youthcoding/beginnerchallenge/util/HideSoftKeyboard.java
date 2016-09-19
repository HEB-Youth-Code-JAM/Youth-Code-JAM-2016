package com.youthcoding.beginnerchallenge.util;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by r730819 on 8/18/2016.
 *
 * Utility class that will take an activity
 * and close the user keyboard for that activity.
 *
 */
public class HideSoftKeyboard {
    public static void hide(Activity activity){
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);

        if(activity.getCurrentFocus() != null){
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }

    }
}
