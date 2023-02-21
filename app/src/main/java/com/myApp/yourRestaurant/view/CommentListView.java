package com.myApp.yourRestaurant.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.contract.CommentListContract;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.presenter.CommentListPresenter;

import java.util.ArrayList;
import java.util.List;

public class CommentListView extends AppCompatActivity implements CommentListContract.view, AdapterView.OnItemClickListener {
   private CommentListPresenter presenter;

   private ArrayAdapter<Comment> commentsArrayAdapter;
   private List<Comment> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeCommentList();

        presenter = new CommentListPresenter(this);
        presenter.loadAllComments();
    }


    private void initializeCommentList() {
        commentList = new ArrayList<>();
        commentsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, commentList);
        ListView lvComments = findViewById(R.id.comment_list);
        lvComments.setAdapter(commentsArrayAdapter);
        lvComments.setOnItemClickListener(this);
    }  @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllComments();
    }
    public void listAllComments(List<Comment> messages) {
        commentList.clear();
        commentList.addAll(messages);
        commentsArrayAdapter.notifyDataSetChanged();

    }

    @Override
    public void showErrorComments(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
