package com.myApp.yourRestaurant.model;

import android.content.Context;

import com.myApp.yourRestaurant.api.YourRestaurantApi;
import com.myApp.yourRestaurant.api.YourRestaurantApiInterface;
import com.myApp.yourRestaurant.contract.CommentListContract;
import com.myApp.yourRestaurant.contract.RestaurantListContract;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantListModel implements RestaurantListContract.Model{
    private Context context;
    public RestaurantListModel(Context context){
        this.context = context;
    }
    @Override
    public void loadAllRestaurants(OnLoadRestaurantsListener listener) {
        YourRestaurantApiInterface api =  YourRestaurantApi.buildInstance();
        Call<List<Restaurant>> callRestaurants = api.getRestaurants();
        callRestaurants.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                List<Restaurant> restaurants = response.body();
                listener.onLoadRestaurantsSuccess(restaurants);
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                listener.onLoadRestaurantsError("Se ha producido un error al conectar con el servidor");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void deleteRestaurant(OnDeleteRestaurantListener listener, String restaurantId) {

    }
}
