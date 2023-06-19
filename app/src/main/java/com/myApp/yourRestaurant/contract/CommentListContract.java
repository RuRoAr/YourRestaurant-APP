package com.myApp.yourRestaurant.contract;

import com.myApp.yourRestaurant.domain.Comment;

import java.util.List;

public interface CommentListContract  {
    interface Model{
        interface OnLoadCommentsListener{
            void onLoadCommentsSuccess(List<Comment> comments);
            void onLoadCommentsError(String error);

        }interface OnDeleteCommentListener {
            ;
            void onDeleteCommentSuccess();
            void onDeleteCommentError(String message);
        }
        void loadAllComments(OnLoadCommentsListener listener);
        void deleteComment(OnDeleteCommentListener listener, String commentId);
    }

    interface view{
        void listAllComments(List<Comment> comments);
        void showErrorComments(String message);

        void showErrorMessage(String message);
    }

    interface presenter{
        void loadAllComments();
        void deleteComment(String commentId);
    }
}
