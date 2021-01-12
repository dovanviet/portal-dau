package com.example.daumobile.Model.authen;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return type == login.type &&
                id.equals(login.id) &&
                password.equals(login.password);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, password, type);
    }
}
