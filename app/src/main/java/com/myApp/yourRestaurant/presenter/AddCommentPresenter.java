package com.myApp.yourRestaurant.presenter;

import android.content.Context;

import com.myApp.yourRestaurant.contract.AddCommentContract;
import com.myApp.yourRestaurant.contract.RegisterUserContract;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.domain.User;
import com.myApp.yourRestaurant.model.AddCommentModel;
import com.myApp.yourRestaurant.model.RegisterUserModel;
import com.myApp.yourRestaurant.view.AddCommentView;
import com.myApp.yourRestaurant.view.RegisterUserView;

public class AddCommentPresenter implements AddCommentContract.Presenter, AddCommentContract.Model.OnAddCommentListener, AddCommentContract.Model.OnModifyCommentListener{
    private final AddCommentModel model;
    private final AddCommentView view;

    private Context context;

    public AddCommentPresenter(AddCommentView view) {
        this.context = view.getApplicationContext();
        model = new AddCommentModel();
        this.view = view;
    }






    @Override
    public void addComment(Comment comment) {
        model.addRegisterComment(this, comment);
    }

    @Override
    public void OnAddCommentSuccess(Comment Comment) {

    }

    @Override
    public void OnAddCommentError(String message) {

    }

    @Override
    public void OnModifyCommentSuccess(Comment Comment) {

    }

    @Override
    public void OnModifyCommentError(String message) {

    }


}
