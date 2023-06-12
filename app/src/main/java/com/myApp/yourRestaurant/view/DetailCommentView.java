package com.myApp.yourRestaurant.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.api.Constants;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.util.ImageUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DetailCommentView extends AppCompatActivity {
    private Constants.Action action;
    private Comment comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_comment);
            comment = getIntent().getParcelableExtra("comment");
            fillCommentDetails();
        }

    private void fillCommentDetails() {
        TextView etTitle = findViewById(R.id.title_comment);
        TextView etComment = findViewById(R.id.comment);
        TextView etDateComment = findViewById(R.id.comment_date);
//      CheckBox checkFavourite = findViewById(R.id.checkBox);
        ImageView etImageComment = findViewById(R.id.imageView);


        etTitle.setText(comment.getTitle());
        etComment.setText(comment.getText());
        etDateComment.setText(comment.getDate());
//      checkFavourite.setChecked(comment.isFavourite());
        if (comment.getCommentPhoto() == null){
//            etImageComment.setImageBitmap(ImageUtils.getBitmap(comment.getCommentPhoto()));
            comment.setCommentPhoto(null) ;
        }else{
            etImageComment.setImageBitmap(ImageUtils.getBitmap(comment.getCommentPhoto()));
        }
    }
}