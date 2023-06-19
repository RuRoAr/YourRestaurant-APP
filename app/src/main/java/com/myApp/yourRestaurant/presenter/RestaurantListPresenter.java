package com.myApp.yourRestaurant.presenter;

import com.myApp.yourRestaurant.contract.CommentListContract;
import com.myApp.yourRestaurant.contract.RestaurantListContract;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.domain.Restaurant;
import com.myApp.yourRestaurant.model.CommentListModel;
import com.myApp.yourRestaurant.model.RestaurantListModel;
import com.myApp.yourRestaurant.view.CommentListView;
import com.myApp.yourRestaurant.view.RestaurantListView;

import java.util.List;

public class RestaurantListPresenter implements RestaurantListContract.presenter, RestaurantListContract.Model.OnLoadRestaurantsListener, RestaurantListContract.Model.OnDeleteRestaurantListener{
    private RestaurantListModel model;
    private RestaurantListView view;

    public RestaurantListPresenter(RestaurantListView view){
        model = new RestaurantListModel(view.getApplicationContext());
        this.view =view;
    }
    @Override
    public void onLoadRestaurantsSuccess(List<Restaurant> messages) {
        view.listAllRestaurants(messages);
    }

    @Override
    public void onLoadRestaurantsError(String error) {
        view.showErrorRestaurants(error);
    }

    @Override
    public void onDeleteRestaurantSuccess() {
        view.showErrorMessage("Borrado");
    }

    @Override
    public void onDeleteRestaurantError(String message) {
        view.showErrorMessage("Algo ha fallado");
    }

    @Override
    public void loadAllRestaurants() {
        model.loadAllRestaurants(this);
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
        model.deleteRestaurant( this, restaurantId);
    }
}
