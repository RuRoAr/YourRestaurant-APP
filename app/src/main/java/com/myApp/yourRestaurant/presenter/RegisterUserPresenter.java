package com.myApp.yourRestaurant.presenter;

import android.app.Notification;

import com.myApp.yourRestaurant.contract.RegisterUserContract;
import com.myApp.yourRestaurant.domain.User;
import com.myApp.yourRestaurant.model.RegisterUserModel;
import com.myApp.yourRestaurant.view.RegisterUserView;

public class RegisterUserPresenter implements RegisterUserContract.Presenter, RegisterUserContract.Model.OnAddUserListener, RegisterUserContract.Model.OnModifyUserListener {

    private final RegisterUserModel model;
    private final RegisterUserView view;

    public RegisterUserPresenter(RegisterUserView view) {
        model = new RegisterUserModel();
        this.view = view;
    }


    @Override
    public void OnAddUserSuccess(User user) {

    }

    @Override
    public void OnAddUserError(String message) {

    }

    @Override
    public void OnModifyUserSuccess(User user) {

    }

    @Override
    public void OnModifyUserError(String message) {

    }

    @Override
    public void addUser(User user, Notification.Action action) {
        user.setId(user.getId());
        user.setFullName(user.getFullName());
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setUserPhoto(user.getUserPhoto());

        model.addRegisterUser(this, user);

    }
}
