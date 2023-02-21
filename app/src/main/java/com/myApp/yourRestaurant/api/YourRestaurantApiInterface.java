package com.myApp.yourRestaurant.api;

import com.myApp.yourRestaurant.domain.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YourRestaurantApiInterface {
    @GET("comments")
    Call<List<Comment>> getComments();

}
