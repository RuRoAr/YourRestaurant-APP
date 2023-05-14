package com.myApp.yourRestaurant.domain;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Arrays;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private String fullName;
    @ColumnInfo
    private String userName;
    @ColumnInfo
    private String password;
    @ColumnInfo
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userPhoto=" + Arrays.toString(userPhoto) +
                '}';
    }

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] userPhoto;

    public User(long id, String fullName, String userName, String password1, String Password2, String email, byte[] userPhoto) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userPhoto = userPhoto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(byte[] userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Ignore
    public User(){
    }


}
