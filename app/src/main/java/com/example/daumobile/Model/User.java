package com.example.daumobile.Model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    String ma_sv;
    String ten;
    String lop;
    Date ngay_sinh;
    String nien_khoa;

    public User() {
    }

    public User(String masv, String name, String _class, Date date, String schoolYear) {
        this.ma_sv = masv;
        this.ten = name;
        this.lop = _class;
        this.ngay_sinh = date;
        this.nien_khoa = schoolYear;
    }

    public String getMa_sv() {
        return ma_sv;
    }

    public void setMa_sv(String ma_sv) {
        this.ma_sv = ma_sv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getNien_khoa() {
        return nien_khoa;
    }

    public void setNien_khoa(String nien_khoa) {
        this.nien_khoa = nien_khoa;
    }
}
