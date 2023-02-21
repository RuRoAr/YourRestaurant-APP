package com.myApp.yourRestaurant.contract;

import com.myApp.yourRestaurant.domain.Comment;

import java.util.List;

public interface CommentListContract  {
    interface Model{
        interface OnLoadCommentsListener{
            void onLoadCommentsSuccess(List<Comment> comments);
            void onLoadCommentsError(String error);

        }
        void loadAllComments(OnLoadCommentsListener listener);
    }

    interface view{
        void listAllComments(List<Comment> comments);
        void showErrorComments(String error);
    }

    interface presenter{
        void loadAllComments();
    }
}
