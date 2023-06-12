package com.myApp.yourRestaurant.presenter;

import com.myApp.yourRestaurant.contract.UserLoginContract;
import com.myApp.yourRestaurant.domain.User;
import com.myApp.yourRestaurant.model.UserLoginModel;
import com.myApp.yourRestaurant.view.UserLoginView;

import java.util.List;

public class UserLoginPresenter implements UserLoginContract.Presenter, UserLoginContract.Model.OnLoginValidateListener {
   private final UserLoginModel model;
   private final UserLoginView view;

    public UserLoginPresenter(UserLoginModel model, UserLoginView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void loginValidateSuccess(List<User> users) {

    }

    @Override
    public void loginValidateError(String message) {

    }


    @Override
    public void ValidateEmailAndPassword(String email, String password) {
            model.ValidateEmailAndPassword(this, email,password);
    }
}
