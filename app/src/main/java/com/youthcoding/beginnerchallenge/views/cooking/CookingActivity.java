package com.youthcoding.beginnerchallenge.views.cooking;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.youthcoding.beginnerchallenge.R;
import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSettings;
import com.youthcoding.beginnerchallenge.views.fragments.UserLocationFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CookingActivity extends AppCompatActivity implements UserLocationFragment.OnFragmentInteractionListener {

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cooking);

        mContentView = findViewById(R.id.fullscreen_content);

        createCookButton();

        createRecipeList();

    }

    /**
     * Creates button that will allow cooking.
     */
    private void createCookButton() {
        final Button cookRecipe = (Button) findViewById(R.id.cooking_stand_cook_button);

        cookRecipe.setEnabled(false);

        cookRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cookRecipe();
            }
        });

        Boolean readyToCook = checkUserCartForRecipeItems();

        if(readyToCook) {
            cookRecipe.setEnabled(true);
        }
    }

    /**
     * Cooks the recipe.
     */
    private void cookRecipe() {
        Toast.makeText(CookingActivity.this, "You've made your favorite recipe. CONGRATS!", Toast.LENGTH_SHORT).show();
        Log.i("Cooking started", "Cooking recipe");
    }

    /**
     * List that displays the required items for the recipe.
     */
    private void createRecipeList() {

        ListView recipeItemsListView = (ListView) findViewById(R.id.recipe_items_list_view);

        ArrayList<GroceryItemSuper> recipeList = UserSettings.getFavoriteRecipe().getIngredients();

        ArrayAdapter<GroceryItemSuper> adapter = new ArrayAdapter<GroceryItemSuper>(
                this,
                android.R.layout.simple_list_item_1,
                recipeList);

        recipeItemsListView.setAdapter(adapter);
    }

    /**
     * Checks the users shopping cart for all the items
     * needed for their recipe.
     *
     * If any items are returned in the required items list,
     * throw an error or disable a button.
     *
     */
    private boolean checkUserCartForRecipeItems() {

        Boolean ret = false;

        ListView requiredItemsListView = (ListView) findViewById(R.id.required_items_list_view);

        startListenerForGroceryItemPopup(requiredItemsListView);

        ArrayList<GroceryItemSuper> requiredItems = UserSettings.getFavoriteRecipe().checkForItems();

        if(requiredItems.size() > 0){

            Log.i("Required Items", "User does not have all the required items");

            for(GroceryItemSuper item : requiredItems){
                Log.i("Item required: ", item.getmName());
            }
        } else {
            //When there are no missing ingredients
            GroceryItemSuper emptyItem = new GroceryItemSuper();
            emptyItem.setmName("None");
            emptyItem.setmHint("Really, you got it. Go cook now!");
            requiredItems.add(emptyItem);

            ret = true;
        }

        ArrayAdapter<GroceryItemSuper> adapter = new ArrayAdapter<GroceryItemSuper>(
                this,
                android.R.layout.simple_list_item_1,
                requiredItems);

        requiredItemsListView.setAdapter(adapter);

        return ret;

    }


    /**
     * Makes a toast to give the hint of where might
     * the object might be in the store.
     *
     * Can handle this with a popup fragment, but a simple
     * toast is probably easier...
     *
     * @param requiredItemsListView the list view to put the listener on
     */
    private void startListenerForGroceryItemPopup(ListView requiredItemsListView) {

        requiredItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GroceryItemSuper groceryItem = (GroceryItemSuper)adapterView.getAdapter().getItem(i);

                Toast.makeText(CookingActivity.this, groceryItem.getmHint(),Toast.LENGTH_LONG ).show();
            }
        });
    }


    /**
     * Method that takes an ArrayList of groceries and
     * gets the name of each grocery and inserts into
     * their own list to be used in ListView.
     *
     * todo - Went with overriding toString method for the objects to display correctly in ListView
     *
     * @param groceries Arraylist to read from
     *
     * @return List of all grocery names
     */
    private List createListOfGroceryItemNames(ArrayList<GroceryItemSuper> groceries){
        List <String> groceryNames = new ArrayList<>();


        for(GroceryItemSuper itemSuper : groceries){
            groceryNames.add(itemSuper.getmName());
        }

        return groceryNames;
    }


    /**
     * Adds user location fragment.
     */
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