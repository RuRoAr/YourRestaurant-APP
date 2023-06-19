package com.myApp.yourRestaurant.model;

import android.content.Context;

import com.myApp.yourRestaurant.api.YourRestaurantApi;
import com.myApp.yourRestaurant.api.YourRestaurantApiInterface;
import com.myApp.yourRestaurant.contract.CommentListContract;
import com.myApp.yourRestaurant.domain.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentListModel implements CommentListContract.Model {
    private Context context;

    public CommentListModel(Context context){
        this.context =context;
    }
    public void loadAllComments(OnLoadCommentsListener listener) {
        YourRestaurantApiInterface api =  YourRestaurantApi.buildInstance();
        Call<List<Comment>> callComments = api.getComments();
        callComments.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                List<Comment> products = response.body();
                listener.onLoadCommentsSuccess(products);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                listener.onLoadCommentsError("Se ha producido un error al conectar con el servidor");
                t.printStackTrace();
            }
        });

    }
    @Override
    public void deleteComment(OnDeleteCommentListener listener, String commentId) {
        YourRestaurantApiInterface api = YourRestaurantApi.buildInstance();
        Call<Void> callComments = api.deleteComment(commentId);
        callComments.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                listener.onDeleteCommentSuccess();
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onDeleteCommentError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }

}
