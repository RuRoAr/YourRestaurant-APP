package com.myApp.yourRestaurant.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.myApp.yourRestaurant.R;
import com.myApp.yourRestaurant.contract.CommentListContract;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.presenter.CommentListPresenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommentListView extends AppCompatActivity implements CommentListContract.view, AdapterView.OnItemClickListener {
   private CommentListPresenter presenter;

   private ArrayAdapter<Comment> commentsArrayAdapter;
   private List<Comment> commentList;
   private String commentId;
   private final String DEFAULT_STRING = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeCommentList();
        presenter = new CommentListPresenter(this);
        presenter.loadAllComments();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.actionbar_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void initializeCommentList() {
        commentList = new ArrayList<>();
        commentsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, commentList);
        ListView lvComments = findViewById(R.id.comment_list);
        lvComments.setAdapter(commentsArrayAdapter);
        lvComments.setOnItemClickListener(this);
        registerForContextMenu(lvComments);
        lvComments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent intent = new Intent(CommentListView.this, DetailCommentView.class);
                intent.putExtra("comment", commentList.get(position));
                startActivity(intent);
            }
        });

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


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.actionbar_edit, menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()) {
            case R.id.modify_comment:

            case R.id.detail_comment:
                //                Intent intent = new Intent(this, NewRestaurantView.class);
//                intent.putExtra("restaurant", restaurantList.get(position));
//                intent.putExtra("ACTION" , "PUT");
//                startActivity(intent);
                Intent intent1 = new Intent(this, DetailCommentView.class);
                intent1.putExtra("comment", commentList.get(position));
                startActivity(intent1);
                return true;
            case R.id.delete_comment:
                Comment comment = commentList.get(position);
                commentId = String.valueOf(comment.getId());
                deleteComment(commentId);
                presenter.loadAllComments();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    private void deleteComment(String commentId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.are_you_sure_delete_comment)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.deleteComment(commentId);
                        presenter.loadAllComments();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_restaurant) {
//            Intent intent = new Intent(this, NewRestaurantView.class);
//            intent.putExtra("ACTION", "POST");
//            startActivity(intent);
            return true;
        }else if (item.getItemId() == R.id.add_comment) {
//            Intent intent = new Intent(this, MapsActivity.class);
//            startActivity(intent);
        }else if (item.getItemId() == R.id.more_users) {
//            Intent intent = new Intent(this, OrderListView.class);
//            startActivity(intent);
        }else if (item.getItemId() == R.id.more_restaurants     ) {
            Intent intent = new Intent(this, RestaurantListView.class);
            startActivity(intent);
        }

        return false;
    }


}
