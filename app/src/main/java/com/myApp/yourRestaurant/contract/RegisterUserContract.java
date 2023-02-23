package com.myApp.yourRestaurant.contract;

import android.app.Notification;
import android.content.Context;

import com.myApp.yourRestaurant.domain.User;

public interface RegisterUserContract {
    interface Model {

        interface OnAddUserListener {
            void OnAddUserSuccess(User user);
            void OnAddUserError(String message);
        }
        interface OnModifyUserListener {
            void OnModifyUserSuccess(User user);
            void OnModifyUserError(String message);
        }
        void modifyVisit(OnModifyUserListener listener, String visitId, User user);

        void addRegisterUser(OnAddUserListener listener, User user);
    }

    interface View {
        void modifyUser(android.view.View view);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void addUser(User user);
    }
}
