package com.myApp.yourRestaurant.api;

import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface YourRestaurantApiInterface {
    @GET("comments")
    Call<List<Comment>> getComments();

    @POST("user")
    Call<User> addUser(@Body User user);

}
