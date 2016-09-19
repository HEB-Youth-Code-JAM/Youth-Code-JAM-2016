package com.youthcoding.beginnerchallenge.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Build;
import android.view.View;

public class ProgressBar {

    /**
     * Function that receives two views, a parent
     * view and a progress bar view. A boolean determines
     * if the user wants to show or hide the progress bar.
     *
     * Receives a context also for resources.
     *
     * @param parentView The view hosting the progress view
     * @param progressBarView The progress bar view
     * @param show Boolean to show or hide view
     * @param context The activity to get resources from
     */
    public void showProgress(final View parentView, final View progressBarView, final boolean show, Context context){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = context.getResources()
                    .getInteger(android.R.integer.config_shortAnimTime);

            parentView.setVisibility(show ? View.GONE : View.VISIBLE);
            parentView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    parentView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressBarView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressBarView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressBarView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressBarView.setVisibility(show ? View.VISIBLE : View.GONE);
            parentView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
        
    }
}
