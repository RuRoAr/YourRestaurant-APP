package com.myApp.yourRestaurant.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.api.Constants;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.util.ImageUtils;

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
        EditText etTitle = findViewById(R.id.title_comment);
        EditText etComment = findViewById(R.id.comment);
        EditText etDateComment = findViewById(R.id.comment_date);
//        CheckBox checkFavourite = findViewById(R.id.checkBox);
        ImageView etImageComment = findViewById(R.id.imageView);

        etTitle.setText(comment.getTitle());
        etComment.setText(comment.getText());
        etDateComment.setText(String.valueOf(comment.getDateComment()));
//        checkFavourite.setChecked(comment.isFavourite());
        etImageComment.setImageBitmap(ImageUtils.getBitmap(comment.getCommentPhoto()));
    }
}