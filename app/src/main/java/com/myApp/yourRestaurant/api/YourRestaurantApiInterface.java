package com.myApp.yourRestaurant.api;

import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.domain.Restaurant;
import com.myApp.yourRestaurant.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface YourRestaurantApiInterface {
    @GET("comments")
    Call<List<Comment>> getComments();

    @GET("restaurants")
    Call<List<Restaurant>> getRestaurants();

    @POST("user")
    Call<User> addUser(@Body User user);

    @DELETE("comment/{commentId}")
    Call<Void> deleteComment(@Path("commentId") String commentId);
}
