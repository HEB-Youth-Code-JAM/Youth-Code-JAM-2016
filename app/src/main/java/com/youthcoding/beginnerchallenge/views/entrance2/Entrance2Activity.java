package com.youthcoding.beginnerchallenge.views.entrance2;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.youthcoding.beginnerchallenge.R;
import com.youthcoding.beginnerchallenge.views.fragments.UserLocationFragment;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Entrance2Activity extends AppCompatActivity implements UserLocationFragment.OnFragmentInteractionListener {

    private View mContentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_entrance2);

        mContentView = findViewById(R.id.fullscreen_content);

    }


    private void addUserLocationFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.add(R.id.user_location_fragment, new UserLocationFragment());

        ft.commit();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


        mContentView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        addUserLocationFragment();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
