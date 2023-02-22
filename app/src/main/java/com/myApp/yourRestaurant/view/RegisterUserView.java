package com.myApp.yourRestaurant.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.api.Constants;
import com.myApp.yourRestaurant.contract.RegisterUserContract;
import com.myApp.yourRestaurant.domain.User;
import com.myApp.yourRestaurant.presenter.RegisterUserPresenter;


public class RegisterUserView extends AppCompatActivity implements RegisterUserContract.View {
    private User user;
    //private Constants.Action action;

    private EditText fullName;
    private EditText userName;
    private EditText email;
    private EditText password1;
    private EditText password2;
    private ImageView userPhoto;

    private Button btnRegister;

    private RegisterUserPresenter presenter;





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

    public void takePhoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }
    // Muestra la vista previa en un imageWiev de la foto tomada

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
