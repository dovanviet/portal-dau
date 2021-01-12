package com.example.daumobile.Model.authen;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Login {
     String id;
     String password;
     int type;

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Login() {
    }

    public Login(String id, String password, int type) {
        this.id = id;
        this.password = password;
        this.type = type;
    }
}
