package com.myApp.yourRestaurant.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.api.Constants;
import com.myApp.yourRestaurant.contract.RegisterUserContract;
import com.myApp.yourRestaurant.domain.User;
import com.myApp.yourRestaurant.presenter.RegisterUserPresenter;
import com.myApp.yourRestaurant.util.ImageUtils;

import retrofit2.http.PUT;


public class RegisterUserView extends AppCompatActivity implements RegisterUserContract.View {
    private User user;
    //private Constants.Action action;
    private EditText fullName;
    private EditText userName;
    private EditText email;
    private EditText password1;
    private EditText password2;
    private String passwordOne;
    private String passwordTwo;
    private ImageView userPhoto;
    private Button btnRegister;
    private RegisterUserPresenter presenter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = getIntent();
        initializeViews();
        user = (User) intent.getSerializableExtra("user");
       // action = Constants.Action.valueOf(getIntent().getStringExtra("ACTION"));

        fullName = findViewById(R.id.inputFullName);
        userName = findViewById(R.id.inputUsername);
        email = findViewById(R.id.inputEmail);
        password1 = findViewById(R.id.inputPassword);
        password2 = findViewById(R.id.inputConformPassword);
        userPhoto = findViewById(R.id.userPhoto);

        presenter = new RegisterUserPresenter(this);
        user = new User();

        if (ContextCompat.checkSelfPermission(RegisterUserView.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(RegisterUserView.this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(RegisterUserView.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000
            );
        }


    }
    public void addUser(View view){
        user.setFullName(fullName.getText().toString().trim());
        user.setUserName(userName.getText().toString().trim());
        user.setEmail(email.getText().toString().trim());
        user.setPassword(password1.getText().toString().trim());
   //     user.setPassword2(password2.getText().toString().trim());
        passwordOne = password1.getText().toString().trim();
        passwordTwo = password2.getText().toString().trim();
        user.setUserPhoto(ImageUtils.fromImageViewToByteArray(userPhoto));

        if ((user.getUserName().equals("")) || (user.getFullName().equals("")) ||
                (user.getEmail().equals("")) || password1.equals("") ||
                (password2.equals(""))) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
        } else if (!passwordOne.equals( passwordTwo)) {
            Toast.makeText(this, "las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
        }
        else {
            presenter.addUser(user);
            Toast.makeText(this, "usuario añadido", Toast.LENGTH_SHORT).show();
        }
    }

    public void takePhoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            userPhoto.setImageBitmap(imageBitmap);
        }
    }
    @Override
    public void modifyUser(View view) {
    }
    @Override
    public void showErrorMessage(String message) {
    }
    private void initializeViews(){
    }
}
