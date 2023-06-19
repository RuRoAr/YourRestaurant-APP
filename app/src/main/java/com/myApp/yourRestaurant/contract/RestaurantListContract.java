package com.myApp.yourRestaurant.contract;

import com.myApp.yourRestaurant.domain.Restaurant;

import java.util.List;

public interface RestaurantListContract {
    interface Model{
        interface OnLoadRestaurantsListener{
            void onLoadRestaurantsSuccess(List<Restaurant> messages);
            void onLoadRestaurantsError(String error);

        }interface OnDeleteRestaurantListener {
            ;
            void onDeleteRestaurantSuccess();
            void onDeleteRestaurantError(String message);
        }
        void loadAllRestaurants(RestaurantListContract.Model.OnLoadRestaurantsListener listener);
        void deleteRestaurant(RestaurantListContract.Model.OnDeleteRestaurantListener listener, String restaurantId);
    }

    interface view{
        void listAllRestaurants(List<Restaurant> restaurants);
        void showErrorRestaurants(String message);

        void showErrorMessage(String message);
    }

    interface presenter{
        void loadAllRestaurants();
        void deleteRestaurant(String restaurantId);
    }
}
