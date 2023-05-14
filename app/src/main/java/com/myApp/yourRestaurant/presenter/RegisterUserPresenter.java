package com.myApp.yourRestaurant.presenter;

import android.app.Notification;
import android.content.Context;
import android.widget.Toast;

import com.myApp.yourRestaurant.contract.RegisterUserContract;
import com.myApp.yourRestaurant.domain.User;
import com.myApp.yourRestaurant.model.RegisterUserModel;
import com.myApp.yourRestaurant.view.RegisterUserView;

public class RegisterUserPresenter implements RegisterUserContract.Presenter, RegisterUserContract.Model.OnAddUserListener, RegisterUserContract.Model.OnModifyUserListener {

    private final RegisterUserModel model;
    private final RegisterUserView view;

    private Context context;

    public RegisterUserPresenter(RegisterUserView view) {
        this.context = view.getApplicationContext();
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
    public void addUser(User user) {
            model.addRegisterUser(this, user);
        }

}
