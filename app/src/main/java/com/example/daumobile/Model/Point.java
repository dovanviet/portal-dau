package com.example.daumobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmField;

public class Point extends RealmObject {
    @PrimaryKey
    @RealmField(name = "id_point")
    @SerializedName("id_point")
    @Expose
    private int idPoint;
    @RealmField(name = "ma_hp")
    @SerializedName("ma_hp")
    @Expose
    private String maHp;
    @RealmField(name = "ten_hp")
    @SerializedName("ten_hp")
    @Expose
    private String tenHp;
    @RealmField(name = "stc")
    @SerializedName("stc")
    @Expose
    private int stc;
    @RealmField(name = "loai_mon_hoc")
    @SerializedName("loai_mon_hoc")
    @Expose
    private boolean loaiMonHoc;
    @RealmField(name = "diem_lan_1")
    @SerializedName("diem_lan_1")
    @Expose
    private int diemLan1;
    @RealmField(name = "diem_lan_2")
    @SerializedName("diem_lan_2")
    @Expose
    private int diemLan2;
    @RealmField(name = "hoc_ky")
    @SerializedName("hoc_ky")
    @Expose
    private int hocKy;

    @Ignore
    private String diem_chu_lan_1;
    @Ignore
    private String diem_chu_lan_2;

    public Point() {
    }

    public Point(int idPoint, String maHp, String tenHp, int stc, boolean loaiMonHoc, int diemLan1, int diemLan2, int hocKy) {
        this.idPoint = idPoint;
        this.maHp = maHp;
        this.tenHp = tenHp;
        this.stc = stc;
        this.loaiMonHoc = loaiMonHoc;
        this.diemLan1 = diemLan1;
        this.diemLan2 = diemLan2;
        this.hocKy = hocKy;

        this.diem_chu_lan_1 = setDiem(diemLan1);
        this.diem_chu_lan_1 = setDiem(diemLan2);
    }

    private String setDiem(int diem_lan_1) {
        switch (diem_lan_1) {
            case 4:
                return "A";
            case 3:
                return "B";
            case 2:
                return "C";
            case 1:
                return "D";
            default:
                return "F";
        }
    }

    public int getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(int idPoint) {
        this.idPoint = idPoint;
    }

    public String getMaHp() {
        return maHp;
    }

    public void setMaHp(String maHp) {
        this.maHp = maHp;
    }

    public String getTenHp() {
        return tenHp;
    }

    public void setTenHp(String tenHp) {
        this.tenHp = tenHp;
    }

    public int getStc() {
        return stc;
    }

    public void setStc(int stc) {
        this.stc = stc;
    }

    public boolean isLoaiMonHoc() {
        return loaiMonHoc;
    }

    public void setLoaiMonHoc(boolean loaiMonHoc) {
        this.loaiMonHoc = loaiMonHoc;
    }

    public int getDiemLan1() {
        return diemLan1;
    }

    public void setDiemLan1(int diemLan1) {
        this.diemLan1 = diemLan1;
    }

    public int getDiemLan2() {
        return diemLan2;
    }

    public void setDiemLan2(int diemLan2) {
        this.diemLan2 = diemLan2;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public String getDiem_chu_lan_1() {
        return diem_chu_lan_1;
    }

    public void setDiem_chu_lan_1(String diem_chu_lan_1) {
        this.diem_chu_lan_1 = diem_chu_lan_1;
    }

    public String getDiem_chu_lan_2() {
        return diem_chu_lan_2;
    }

    public void setDiem_chu_lan_2(String diem_chu_lan_2) {
        this.diem_chu_lan_2 = diem_chu_lan_2;
    }
}
