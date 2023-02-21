package com.myApp.yourRestaurant.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Arrays;

@Entity
public class Comment {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String text;
    @ColumnInfo
    private String dateComment;

    @Override
    public String toString() {
        return "Comment{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", dateComment='" + dateComment + '\'' +
                ", commentPhoto=" + Arrays.toString(commentPhoto) +
                '}';
    }

    public Comment(long id, String title, String text, String dateComment, byte[] commentPhoto) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateComment = dateComment;
        this.commentPhoto = commentPhoto;
    }

    @ColumnInfo
    private byte[] commentPhoto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }

    public byte[] getCommentPhoto() {
        return commentPhoto;
    }

    public void setCommentPhoto(byte[] commentPhoto) {
        this.commentPhoto = commentPhoto;
    }
}
