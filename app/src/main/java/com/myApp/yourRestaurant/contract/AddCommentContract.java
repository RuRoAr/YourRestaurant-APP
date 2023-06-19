package com.myApp.yourRestaurant.contract;

import com.myApp.yourRestaurant.domain.Comment;

public interface AddCommentContract {
    interface Model {

        interface OnAddCommentListener {
            void OnAddCommentSuccess(Comment Comment);
            void OnAddCommentError(String message);
        }
        interface OnModifyCommentListener {
            void OnModifyCommentSuccess(Comment Comment);
            void OnModifyCommentError(String message);
        }
        void modifyComment(AddCommentContract.Model.OnModifyCommentListener listener, String visitId, Comment Comment);

        void addRegisterComment(AddCommentContract.Model.OnAddCommentListener listener, Comment Comment);
    }

    interface View {
        void modifyComment(android.view.View view);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void addComment(Comment Comment);
    }
}
