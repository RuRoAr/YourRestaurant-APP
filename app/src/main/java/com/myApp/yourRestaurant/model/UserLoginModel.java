package com.myApp.yourRestaurant.model;

import com.myApp.yourRestaurant.api.YourRestaurantApi;
import com.myApp.yourRestaurant.api.YourRestaurantApiInterface;
import com.myApp.yourRestaurant.contract.UserLoginContract;
import com.myApp.yourRestaurant.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginModel implements UserLoginContract.Model {


    @Override
    public void ValidateEmailAndPassword(UserLoginContract.Model.OnLoginValidateListener listener, String email, String password) {
        YourRestaurantApiInterface api = YourRestaurantApi.buildInstance();
        Call<List<User>> callVisits = api.getEmailAndPassword(email,password);
        callVisits.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                listener.loginValidateSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.loginValidateError("Se ha producido un error");
            }
        });
    }


}
