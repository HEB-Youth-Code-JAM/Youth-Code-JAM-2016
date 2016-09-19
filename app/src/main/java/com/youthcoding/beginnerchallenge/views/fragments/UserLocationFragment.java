package com.youthcoding.beginnerchallenge.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.youthcoding.beginnerchallenge.R;
import com.youthcoding.beginnerchallenge.groceryItems.GroceryItemSuper;
import com.youthcoding.beginnerchallenge.user.UserSectionInStore;
import com.youthcoding.beginnerchallenge.user.UserShoppingCart;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserLocationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserLocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserLocationFragment extends Fragment {
    private OnFragmentInteractionListener mListener;


    public UserLocationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment UserLocationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserLocationFragment newInstance() {
        UserLocationFragment fragment = new UserLocationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_location, container, false);

        setUserLocationSpinner(view);

        int userLocation = UserSectionInStore.getUserLocation();

        //don't set items in location in entrances and cooking section
        if(UserSectionInStore.COOKING_SECTION != userLocation && UserSectionInStore.ENTRANCE_1_SECTION != userLocation
                && UserSectionInStore.ENTRANCE_2_SECTION != userLocation) {
            view.findViewById(R.id.shelf_text_view).setVisibility(View.VISIBLE);
            setItemsInLocation(view, userLocation);
        }

        return view;
    }

    /**
     * Sets the list for items in locations
     * @param view
     */
    private void setItemsInLocation(View view, int userLocation) {
        ListView itemsInLocationListView = (ListView) view.findViewById(R.id.items_in_location_list_view);

        ArrayList<GroceryItemSuper> itemsInLocation = UserSectionInStore.getItemsInCurrentLocation();

        //only items if no items set in location
        if(itemsInLocation.isEmpty()) {
            GroceryItemSuper emptyItem = new GroceryItemSuper();
            emptyItem.setmName("None");
            itemsInLocation.add(emptyItem);
        }

        final ArrayAdapter<GroceryItemSuper> adapter = new ArrayAdapter<GroceryItemSuper>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                itemsInLocation);

        itemsInLocationListView.setAdapter(adapter);

        itemsInLocationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroceryItemSuper groceryItem = (GroceryItemSuper)parent.getAdapter().getItem(position);

                if("None".equalsIgnoreCase(groceryItem.getmName())) {
                    //no items
                    Toast.makeText(view.getContext(), "This location has been cleaned out!", Toast.LENGTH_SHORT).show();
                } else {
                    UserShoppingCart.getShoppingCart().add(groceryItem);
                    Toast.makeText(view.getContext(), "Added " + groceryItem.getmName() + " to your shopping cart" ,Toast.LENGTH_SHORT).show();
                }
            }
        });

        Log.i("Items in Location", "Items in Location Created for " + userLocation);
    }

    /**
     * Sets the spinner to the
     *
     * @param view
     */
    private void setUserLocationSpinner(View view) {
        Spinner userLocationSpinner = (Spinner) view.findViewById(R.id.user_location_spinner);

        if(userLocationSpinner != null){
            UserSectionInStore.setMapSpinner(userLocationSpinner, getActivity());
            Log.i("Location", "User Location Spinner Created");
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
