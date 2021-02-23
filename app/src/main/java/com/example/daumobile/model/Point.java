package com.example.daumobile.model;

import java.util.Objects;
import java.util.UUID;


public class Point {
    String id = UUID.randomUUID().toString();
    String mssv;
    String tenHp;
    int tinChi;
    double diemTrungBinh;
    double diemLan1;
    double diemLan2;
    int hocKy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return tinChi == point.tinChi &&
                Double.compare(point.diemTrungBinh, diemTrungBinh) == 0 &&
                Double.compare(point.diemLan1, diemLan1) == 0 &&
                Double.compare(point.diemLan2, diemLan2) == 0 &&
                Objects.equals(id, point.id) &&
                Objects.equals(mssv, point.mssv) &&
                Objects.equals(tenHp, point.tenHp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mssv, tenHp, tinChi, diemTrungBinh, diemLan1, diemLan2);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTenHp() {
        return tenHp;
    }

    public void setTenHp(String tenHp) {
        this.tenHp = tenHp;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public double getDiemLan1() {
        return diemLan1;
    }

    public void setDiemLan1(double diemLan1) {
        this.diemLan1 = diemLan1;
    }

    public double getDiemLan2() {
        return diemLan2;
    }

    public void setDiemLan2(double diemLan2) {
        this.diemLan2 = diemLan2;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public Point() {
    }

    public Point(String id, String mssv, String tenHp, int tinChi, double diemTrungBinh,double diemLan1,double diemLan2) {
        this.id = id;
        this.mssv = mssv;
        this.tenHp = tenHp;
        this.tinChi = tinChi;
        this.diemTrungBinh = diemTrungBinh;
        this.diemLan1 = diemLan1;
        this.diemLan2 = diemLan2;
    }

    public Point(String mssv, String tenHp, int tinChi, double diemTrungBinh,double diemLan1,double diemLan2, int hocKy) {
        this.mssv = mssv;
        this.tenHp = tenHp;
        this.tinChi = tinChi;
        this.diemTrungBinh = diemTrungBinh;
        this.diemLan1 = diemLan1;
        this.diemLan2 = diemLan2;
        this.hocKy = hocKy;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id='" + id + '\'' +
                ", mssv='" + mssv + '\'' +
                ", tenHp='" + tenHp + '\'' +
                ", tinChi=" + tinChi +
                ", diemTrungBinh=" + diemTrungBinh +
                ", diemLan1=" + diemLan1 +
                ", diemLan2=" + diemLan2 +
                '}';
    }
}
