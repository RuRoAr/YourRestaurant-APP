package com.myApp.yourRestaurant.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.contract.CommentListContract;
import com.myApp.yourRestaurant.contract.RestaurantListContract;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.domain.Restaurant;
import com.myApp.yourRestaurant.presenter.CommentListPresenter;
import com.myApp.yourRestaurant.presenter.RestaurantListPresenter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListView extends AppCompatActivity implements RestaurantListContract.view, AdapterView.OnItemClickListener {
    private RestaurantListPresenter presenter;
    private ArrayAdapter<Restaurant> restaurantsArrayAdapter;
    private List<Restaurant> restaurantList;
    private String restaurantId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list_view);
        initializeRestaurantList();
        presenter = new RestaurantListPresenter(this);
        presenter.loadAllRestaurants();
    }
    private void initializeRestaurantList() {
        restaurantList = new ArrayList<>();
        restaurantsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurantList);
        ListView lvRestaurants = findViewById(R.id.restaurant_list);
        lvRestaurants.setAdapter(restaurantsArrayAdapter);
        lvRestaurants.setOnItemClickListener(this);
        registerForContextMenu(lvRestaurants);
    }
    protected void onResume() {
        super.onResume();
        presenter.loadAllRestaurants();
    }
    public void listAllRestaurants(List<Restaurant> messages) {
        restaurantList.clear();
        restaurantList.addAll(messages);
        restaurantsArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }


    @Override
    public void showErrorRestaurants(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String message) {
    }

}