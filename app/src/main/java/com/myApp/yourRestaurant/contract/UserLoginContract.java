package com.myApp.yourRestaurant.contract;

import com.myApp.yourRestaurant.domain.User;

import java.util.List;

public interface UserLoginContract {
    interface Model {
        interface ValidateUserListener {

        }

        interface OnLoginValidateListener {

            void loginValidateSuccess(List<User> users);

            void loginValidateError(String message);

        }


        void ValidateEmailAndPassword(OnLoginValidateListener listener, String email, String password);
    }


    interface View {
        void showErrorMessage(String message);
    }

    interface Presenter {
        void ValidateEmailAndPassword( String email, String password);
    }


}

