package com.myApp.yourRestaurant.contract;

import com.myApp.yourRestaurant.domain.User;

public interface UserLoginContract {
interface Model{
    interface ValidateUserListener {
        void ValidateUserSuccess(User user);
        void ValidateUserError(String message);
    }
    void ValidateUser(ValidateUserListener listener, User user);


}
    interface View {

        void showErrorMessage(String message);
    }

    interface Presenter {
        void validateUser(User user);
    }
}
