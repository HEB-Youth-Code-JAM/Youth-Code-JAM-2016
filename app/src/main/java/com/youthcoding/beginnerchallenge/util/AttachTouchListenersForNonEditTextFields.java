package com.youthcoding.beginnerchallenge.util;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by r730819 on 8/18/2016.
 *
 * Utility set up class that is called
 * after setContentView to attach a
 * onClick listener to every element
 * that is not an edit text view so
 * it will automatically hide the
 * keyboard.
 *
 * More info here:
 * http://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext
 */
public class AttachTouchListenersForNonEditTextFields extends AppCompatActivity {
    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    HideSoftKeyboard.hide(AttachTouchListenersForNonEditTextFields.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
}
