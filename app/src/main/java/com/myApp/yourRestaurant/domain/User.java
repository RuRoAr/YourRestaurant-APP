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
    private String password1;
    @ColumnInfo
    private String Password2;
    @ColumnInfo
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", password1='" + password1 + '\'' +
                ", getPassword2='" + Password2 + '\'' +
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
        this.password1 = password1;
        this.Password2 = Password2;
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

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return Password2;
    }

    public void setPassword2(String getPassword2) {
        this.Password2 = getPassword2;
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
