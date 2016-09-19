package com.youthcoding.beginnerchallenge.views.storyOptionsScreen;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.youthcoding.beginnerchallenge.R;
import com.youthcoding.beginnerchallenge.recipes.ChiliCheeseHotDog;
import com.youthcoding.beginnerchallenge.recipes.Hamburger;
import com.youthcoding.beginnerchallenge.recipes.MacAndCheese;
import com.youthcoding.beginnerchallenge.recipes.PeanutButterAndJelly;
import com.youthcoding.beginnerchallenge.recipes.Pizza;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;
import com.youthcoding.beginnerchallenge.user.UserSettings;
import com.youthcoding.beginnerchallenge.util.AttachTouchListenersForNonEditTextFields;


/**
 * This intent will have all the options
 * the user can enable/disable or set for
 * their story.
 */
public class StoryOptionsActivity extends AttachTouchListenersForNonEditTextFields {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_options);

        setupUI(findViewById(R.id.story_options_view));


        final EditText firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        final EditText nickNameEditText = (EditText) findViewById(R.id.nickNameEditText);
        final Button beginStoryButton = (Button) findViewById(R.id.begin_story_button);
        final Spinner recipeOptionsSpinner = (Spinner) findViewById(R.id.recipe_options_spinner);
        final TextView recipeDescriptionTextView = (TextView) findViewById(R.id.recipe_description_textview);
        final Spinner startingLocationSpinner = (Spinner) findViewById(R.id.starting_location_spinner);


        final ArrayAdapter<CharSequence> recipe_array_adapter = ArrayAdapter.createFromResource(this,
                R.array.recipes_array, android.R.layout.simple_spinner_item);
        recipe_array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recipeOptionsSpinner.setAdapter(recipe_array_adapter);

        final ArrayAdapter<CharSequence> location_options_adapter = ArrayAdapter.createFromResource(this,
                R.array.start_locations_array, android.R.layout.simple_spinner_item);
        location_options_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startingLocationSpinner.setAdapter(location_options_adapter);


        recipeOptionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                changeRecipeDescription(adapterView.getSelectedItem().toString(),
                        recipeDescriptionTextView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                beginStoryButton.setClickable(false);
            }
        });




        beginStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStoryWithOptions(firstNameEditText.getText().toString(),
                        nickNameEditText.getText().toString(),
                        recipeOptionsSpinner.getSelectedItem().toString(),
                        startingLocationSpinner.getSelectedItem().toString());

                //openMapActivity();
            }
        });
    }

    /**
     * Everytime the spinner selection is
     * changed, the recipes description will
     * be displayed on the screen so the user
     * knows which items they will have to find.
     *
     * @param recipe The recipe
     * @param recipeDescriptionTextView Where to put the description
     */
    void changeRecipeDescription(String recipe, TextView recipeDescriptionTextView) {
        switch (recipe){
            case "Pizza":{
                Pizza pizza = new Pizza();
                recipeDescriptionTextView.setText(pizza.getDescription());
                UserSettings.setFavoriteRecipe(pizza);
                break;
            }
            case "Peanut Butter and Jelly":{
                PeanutButterAndJelly pbj = new PeanutButterAndJelly();
                recipeDescriptionTextView.setText(pbj.getDescription());
                UserSettings.setFavoriteRecipe(pbj);
                break;
            }
            case "Mac and Cheese":{
                MacAndCheese macAndCheese = new MacAndCheese();
                recipeDescriptionTextView.setText(macAndCheese.getDescription());
                UserSettings.setFavoriteRecipe(macAndCheese);
                break;
            }
            case "Hamburger":{
                Hamburger hamburger = new Hamburger();
                recipeDescriptionTextView.setText(hamburger.getDescription());
                UserSettings.setFavoriteRecipe(hamburger);
                break;
            }
            case "Chili Cheese Hot Dog":{
                ChiliCheeseHotDog chiliCheeseHotDog = new ChiliCheeseHotDog();
                recipeDescriptionTextView.setText(chiliCheeseHotDog.getDescription());
                UserSettings.setFavoriteRecipe(chiliCheeseHotDog);
                break;
            }
        }
    }


    /**
     * Receives all the user story settings and
     * stores them in a static class UserSettings
     * to be referenced throughout the app
     * @param firstName String
     * @param nickname String
     * @param selectedRecipe String
     * @param startingLocation String converted to int
     */
    void startStoryWithOptions(String firstName, String nickname, String selectedRecipe,
                               String startingLocation){

        UserSettings.setFirstName(firstName);
        UserSettings.setNickName(nickname);
        UserSettings.setUserLocation(startingLocation);
        //users favorite recipe is set on the switch above

        //pull user location choice and send them there
        UserSectionInStore.setmActivity(this);
        UserSectionInStore.StartActivityForUserLocation();

        Log.i("FirstName", firstName);
        Log.i("Nickname", nickname);
        Log.i("Recipe", selectedRecipe);
        Log.i("Starting Location", startingLocation);

    }


}
