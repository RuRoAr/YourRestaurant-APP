package com.myApp.yourRestaurant.view;

import static com.myApp.yourRestaurant.api.Constants.Action.PUT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.api.Constants;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.domain.User;
import com.myApp.yourRestaurant.presenter.AddCommentPresenter;
import com.myApp.yourRestaurant.presenter.RegisterUserPresenter;
import com.myApp.yourRestaurant.util.ImageUtils;

public class AddCommentView extends AppCompatActivity {


//    private AddCommentPresenter presenter;
    private Constants.Action action;
    private Comment comment;
    private EditText title;
    private EditText text;
    private EditText dateComment;

    private ImageView commentPhoto;

    private Button btnRe;
    private AddCommentPresenter presenter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment_view);

        Intent intent = getIntent();
        comment = (Comment) intent.getSerializableExtra("Comment");
       // action = Constants.Action.valueOf(getIntent().getStringExtra("ACTION"));

        title = findViewById(R.id.titleComment);
        text = findViewById(R.id.textComment);
        dateComment = findViewById(R.id.dateComment);
        commentPhoto = findViewById(R.id.commentPhoto);

        presenter = new AddCommentPresenter(this);
        comment = new Comment();

        if (ContextCompat.checkSelfPermission(AddCommentView.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(AddCommentView.this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(AddCommentView.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000
            );
        }


    }


    public void addComment(View view){
        comment.setTitle(title.getText().toString().trim());
        comment.setText(text.getText().toString().trim());
        comment.setDate(dateComment.getText().toString().trim());
        comment.setCommentPhoto(ImageUtils.fromImageViewToByteArray(commentPhoto));

        if ((comment.getText().equals("")) || (comment.getTitle().equals("")) ||
                (comment.getDate().equals(""))) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
       // } else if(password1 != password2) {
    //        Toast.makeText(this, "las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
        }
        else {
            presenter.addComment(comment);
            Toast.makeText(this, "Comentario Añadido", Toast.LENGTH_SHORT).show();
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
            commentPhoto.setImageBitmap(imageBitmap);
        }
    }
}