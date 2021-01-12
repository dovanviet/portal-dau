package com.example.daumobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmField;

public class Schedule extends RealmObject {
    @PrimaryKey
    @RealmField(name = "id_schema")
    @SerializedName("id_schema")
    @Expose
    private int idSchema;
    @RealmField(name = "ma_lop_hp")
    @SerializedName("ma_lop_hp")
    @Expose
    private String maLopHp;
    @RealmField(name = "ten_hp")
    @SerializedName("ten_hp")
    @Expose
    private String tenHp;
    @RealmField(name = "loai_hp")
    @SerializedName("loai_hp")
    @Expose
    private String loaiHp;
    @RealmField(name = "stc")
    @SerializedName("stc")
    @Expose
    private int stc;
    @RealmField(name = "lop_hoc")
    @SerializedName("lop_hoc")
    @Expose
    private String lopHoc;
    @RealmField(name = "so_tiet")
    @SerializedName("so_tiet")
    @Expose
    private int soTiet;
    @RealmField(name = "giang_vien")
    @SerializedName("giang_vien")
    @Expose
    private String giangVien;
    @RealmField(name = "ngay_hoc")
    @SerializedName("ngay_hoc")
    @Expose
    private String ngayHoc;
    @RealmField(name = "buoi")
    @SerializedName("buoi")
    @Expose
    private String buoi;
    @RealmField(name = "tiet")
    @SerializedName("tiet")
    @Expose
    private String tiet;
    @RealmField(name = "phong")
    @SerializedName("phong")
    @Expose
    private String phong;
    @RealmField(name = "thoi_gian")
    @SerializedName("thoi_gian")
    @Expose
    private String thoiGian;
    @RealmField(name = "tuan")
    @SerializedName("tuan")
    @Expose
    private int tuan;

    public Schedule() {
    }

    public int getIdSchema() {
        return idSchema;
    }

    public void setIdSchema(int idSchema) {
        this.idSchema = idSchema;
    }

    public String getMaLopHp() {
        return maLopHp;
    }

    public void setMaLopHp(String maLopHp) {
        this.maLopHp = maLopHp;
    }

    public String getTenHp() {
        return tenHp;
    }

    public void setTenHp(String tenHp) {
        this.tenHp = tenHp;
    }

    public String getLoaiHp() {
        return loaiHp;
    }

    public void setLoaiHp(String loaiHp) {
        this.loaiHp = loaiHp;
    }

    public int getStc() {
        return stc;
    }

    public void setStc(int stc) {
        this.stc = stc;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getBuoi() {
        return buoi;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getTuan() {
        return tuan;
    }

    public void setTuan(int tuan) {
        this.tuan = tuan;
    }

}