package com.youthcoding.beginnerchallenge.views.startScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.youthcoding.beginnerchallenge.R;
import com.youthcoding.beginnerchallenge.views.storyOptionsScreen.StoryOptionsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button startChallenge = (Button) findViewById(R.id.start_button);

        startChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startChallenge();
            }
        });

    }


    /**
     * Once the user clicks the start challenge
     * button the next screen will come into view
     */
    void startChallenge(){
        Intent storyOptionsIntent = new Intent(this, StoryOptionsActivity.class);

        startActivity(storyOptionsIntent);
    }
}
