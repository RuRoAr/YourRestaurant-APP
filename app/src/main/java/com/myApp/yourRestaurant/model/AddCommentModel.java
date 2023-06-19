package com.myApp.yourRestaurant.model;

import com.myApp.yourRestaurant.api.YourRestaurantApi;
import com.myApp.yourRestaurant.api.YourRestaurantApiInterface;
import com.myApp.yourRestaurant.contract.AddCommentContract;
import com.myApp.yourRestaurant.domain.Comment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCommentModel implements AddCommentContract.Model{




    @Override
    public void modifyComment(OnModifyCommentListener listener, String visitId, Comment Comment) {

    }

    @Override
    public void addRegisterComment(AddCommentContract.Model.OnAddCommentListener listener, Comment comment) {
        YourRestaurantApiInterface api = YourRestaurantApi.buildInstance();
        Call<Comment> callComments = api.addComment(comment);
        callComments.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                listener.OnAddCommentSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                listener.OnAddCommentError("Se ha producido un error");
            }
        });
    }
}
