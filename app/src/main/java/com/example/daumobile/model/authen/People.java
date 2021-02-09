package com.example.daumobile.model.authen;

import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {
    String id;
    String password;
    int type = PEOPLE_TYPE.ADMIN.getValue();
    String name, address, numberphone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return type == people.type &&
                Objects.equals(id, people.id) &&
                Objects.equals(password, people.password) &&
                Objects.equals(name, people.name) &&
                Objects.equals(address, people.address) &&
                Objects.equals(numberphone, people.numberphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, type, name, address, numberphone);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public People() {
    }

    public People(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public People(String id, String password, String name, String address, String numberphone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.numberphone = numberphone;
    }

    public People(String id, String password, int type, String name, String address, String numberphone) {
        this.id = id;
        this.password = password;
        this.type = type;
        this.name = name;
        this.address = address;
        this.numberphone = numberphone;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberphone='" + numberphone + '\'' +
                '}';
    }
}
