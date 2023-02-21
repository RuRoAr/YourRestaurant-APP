package com.myApp.yourRestaurant.api;

import static com.myApp.yourRestaurant.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YourRestaurantApi {

    public static YourRestaurantApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(YourRestaurantApiInterface.class);
    }
}
