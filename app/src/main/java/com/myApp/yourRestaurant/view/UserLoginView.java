package com.myApp.yourRestaurant.view;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.contract.UserLoginContract;
import com.myApp.yourRestaurant.presenter.CommentListPresenter;
import com.myApp.yourRestaurant.util.StringHelper;

import java.util.HashMap;
import java.util.Map;

public class UserLoginView extends AppCompatActivity implements UserLoginContract.View {
    private TextView singIn;
    private TextView inputEmail;
    private TextView inputPassword;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singIn = (TextView) findViewById(R.id.textViewSignUp);
        buttonLogin = findViewById(R.id.btnlogin);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginView.this, RegisterUserView.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processFormField();
           //     authenticateUser();
                Intent intent = new Intent(UserLoginView.this, CommentListView.class);
                startActivity(intent);
            }
        });
    }
    public void authenticateUser(){
        if(!validateEmail() || !validatePasswordAndConfirm()){
            return;
        }
    }
    @Override
    public void showErrorMessage(String message) {
    }
    public void  processFormField(){
        if(!validateEmail() || !validatePasswordAndConfirm()){
            return;
        }
        RequestQueue queue = Volley.newRequestQueue(UserLoginView.this);
        String url = "http://localhost:8080/login";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equalsIgnoreCase("success")){
                    inputEmail.setText(null);
                    inputPassword.setText(null);

                }
                Toast.makeText(UserLoginView.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserLoginView.this, "Registration Un-Successful", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
               Map<String, String> params = new HashMap<>();
               params.put("email", inputEmail.getText().toString());
               params.put("password", inputPassword.getText().toString());
               return  params;
            }
        };
        queue.add(stringRequest);
    }

    public boolean validateEmail() {
        String email = inputEmail.getText().toString();
        if (email.isEmpty()) {
            inputEmail.setError("The email is empty!!");
            return false;
        } else if (!StringHelper.regexEmailValidationPattern(email)) {
            inputEmail.setError("Please enter a valid email");
        return false;
    }else{
        inputEmail.setError(null);
        return true;
    }
}
    //TODO
    public boolean validatePasswordAndConfirm(){
    //    String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if(password.isEmpty()){
            inputPassword.setError("The password is empty!!");
            return false;
        }else {
            inputPassword.setError(null);
        }return true;
    }
}
