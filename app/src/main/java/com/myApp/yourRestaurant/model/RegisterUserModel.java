package com.myApp.yourRestaurant.model;

import com.myApp.yourRestaurant.api.YourRestaurantApi;
import com.myApp.yourRestaurant.api.YourRestaurantApiInterface;
import com.myApp.yourRestaurant.contract.RegisterUserContract;
import com.myApp.yourRestaurant.domain.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUserModel implements RegisterUserContract.Model {
    @Override
    public void modifyVisit(OnModifyUserListener listener, String visitId, User user) {

    }

    @Override
    public void addRegisterUser(OnAddUserListener listener, User user) {
        YourRestaurantApiInterface api = YourRestaurantApi.buildInstance();
        Call<User> callUsers = api.addUser(user);
        callUsers.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                listener.OnAddUserSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.OnAddUserError("Se ha producido un error");
            }
        });
    }
}
