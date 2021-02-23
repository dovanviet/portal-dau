package com.example.daumobile.model;

import java.util.UUID;

public class Schedule {
    String id = UUID.randomUUID().toString();
    String maHP;
    String tenHP;
    String loaiHP;
    int soTinChi;
    String lopHoc;
    int soTiet;
    String tenGiangVien;
    String thoiGianDayTrongTuan;
    long thoiGian;
    String buoi;
    String tiet;
    boolean tamdung;
    String hocky;
    String nam;
    String phong;
    int tuan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public String getLoaiHP() {
        return loaiHP;
    }

    public void setLoaiHP(String loaiHP) {
        this.loaiHP = loaiHP;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
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

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getThoiGianDayTrongTuan() {
        return thoiGianDayTrongTuan;
    }

    public void setThoiGianDayTrongTuan(String thoiGianDayTrongTuan) {
        this.thoiGianDayTrongTuan = thoiGianDayTrongTuan;
    }

    public long getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(long thoiGian) {
        this.thoiGian = thoiGian;
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

    public boolean isTamdung() {
        return tamdung;
    }

    public void setTamdung(boolean tamdung) {
        this.tamdung = tamdung;
    }

    public String getHocky() {
        return hocky;
    }

    public void setHocky(String hocky) {
        this.hocky = hocky;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getTuan() {
        return tuan;
    }

    public void setTuan(int tuan) {
        this.tuan = tuan;
    }

    public Schedule(String maHP, String tenHP, String loaiHP, int soTinChi, String lopHoc, int soTiet, String tenGiangVien, String thoiGianDayTrongTuan, long thoiGian, String buoi, String tiet, boolean tamdung, String hocky, String nam, String phong, int tuan) {
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.loaiHP = loaiHP;
        this.soTinChi = soTinChi;
        this.lopHoc = lopHoc;
        this.soTiet = soTiet;
        this.tenGiangVien = tenGiangVien;
        this.thoiGianDayTrongTuan = thoiGianDayTrongTuan;
        this.thoiGian = thoiGian;
        this.buoi = buoi;
        this.tiet = tiet;
        this.tamdung = tamdung;
        this.hocky = hocky;
        this.nam = nam;
        this.phong = phong;
        this.tuan = tuan;
    }

    public Schedule(String id, String maHP, String tenHP, String loaiHP, int soTinChi, String lopHoc, int soTiet, String tenGiangVien, String thoiGianDayTrongTuan, long thoiGian, String buoi, String tiet, boolean tamdung, String hocky, String nam, String phong, int tuan) {
        this.id = id;
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.loaiHP = loaiHP;
        this.soTinChi = soTinChi;
        this.lopHoc = lopHoc;
        this.soTiet = soTiet;
        this.tenGiangVien = tenGiangVien;
        this.thoiGianDayTrongTuan = thoiGianDayTrongTuan;
        this.thoiGian = thoiGian;
        this.buoi = buoi;
        this.tiet = tiet;
        this.tamdung = tamdung;
        this.hocky = hocky;
        this.nam = nam;
        this.phong = phong;
        this.tuan = tuan;
    }

    public Schedule() {
    }
}