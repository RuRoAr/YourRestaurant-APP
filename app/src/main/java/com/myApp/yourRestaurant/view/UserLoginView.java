package com.myApp.yourRestaurant.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.contract.UserLoginContract;
import com.myApp.yourRestaurant.presenter.CommentListPresenter;

public class UserLoginView extends AppCompatActivity implements UserLoginContract.View {


    private TextView singUp;
    private TextView inputEmail;
    private TextView inputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singUp= (TextView) findViewById(R.id.textViewSignUp);

        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginView.this, RegisterUserView.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void showErrorMessage(String message) {

    }
}
