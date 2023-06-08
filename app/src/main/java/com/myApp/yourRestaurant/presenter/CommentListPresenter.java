package com.myApp.yourRestaurant.presenter;

import com.myApp.yourRestaurant.contract.CommentListContract;
import com.myApp.yourRestaurant.domain.Comment;
import com.myApp.yourRestaurant.model.CommentListModel;
import com.myApp.yourRestaurant.view.CommentListView;

import java.util.List;

public class CommentListPresenter implements CommentListContract.presenter, CommentListContract.Model.OnLoadCommentsListener, CommentListContract.Model.OnDeleteCommentListener {
    private CommentListModel model;
    private CommentListView view;


    public CommentListPresenter(CommentListView view){
        model = new CommentListModel(view.getApplicationContext());
        this.view =view;
    }
    @Override
    public void onLoadCommentsSuccess(List<Comment> messages) {

        view.listAllComments(messages);
    }

    @Override
    public void onLoadCommentsError(String error) {
        view.showErrorComments(error);
    }

    @Override
    public void loadAllComments() {
        model.loadAllComments(this);
    }


    @Override
    public void deleteComment(String commentId) {
        model.deleteComment( this, commentId);
    }
    @Override
    public void onDeleteCommentSuccess() {
        view.showErrorMessage("Borrado");
    }

    @Override
    public void onDeleteCommentError(String message) {

        view.showErrorMessage("Algo ha fallado");
    }
}
