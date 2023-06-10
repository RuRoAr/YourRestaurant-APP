package com.myApp.yourRestaurant.domain;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Arrays;

@Entity
public class Comment implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String text;
    @ColumnInfo
    private String dateComment;


    protected Comment(Parcel in) {
        id = in.readLong();
        title = in.readString();
        text = in.readString();
        dateComment = in.readString();
        commentPhoto = in.readBlob();
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    @Override
    public String toString() {
        return  "- " + title  + '\n' + '\n'  + '\n' +
                "- "+ text + '\n' +
                "- " + dateComment ;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(title);
        parcel.writeString(text);
        parcel.writeString(dateComment);
        parcel.writeBlob(commentPhoto);
    }
}
