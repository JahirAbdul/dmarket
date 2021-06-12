package com.compass.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Column(name = "password")
    @NotNull
    private String password;

    public User() {
        this.userId = -1;
        this.userName = null;
        this.password = null;
    }
    public User(String userName, String password) {
        this.userName=userName;
        this.password=password;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
