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
//        user.setId(user.getId());
//        user.setFullName(user.getFullName());
//        user.setUserName(user.getUserName());
//        user.setPassword1(user.getPassword1());
//        user.setPassword2(user.getPassword2());
//        user.setEmail(user.getEmail());
//        user.setUserPhoto(user.getUserPhoto());
//
//        model.addRegisterUser(this, user);

        if ((user.getUserName().equals("")) || (user.getFullName().equals("")) ||
                (user.getEmail().equals("")) || (user.getPassword1().equals("")) ||
                (user.getPassword2().equals(""))) {
            Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show();
        } if (user.getPassword1() != (user.getPassword2())) {
        Toast.makeText(context, "las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
    }else {
            model.addRegisterUser(this, user);
        }
       // view.cleanForm();
    }
}
