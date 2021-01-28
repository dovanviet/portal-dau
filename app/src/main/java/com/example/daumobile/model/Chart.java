package com.example.daumobile.model;

public class Chart {
    private double diem_trung_binh;
    private int so_tin_chi_rot;
    private long tong_tin_chi;
    private int hoc_ky;
    private int dem_diem_a;
    private int dem_diem_b;
    private int dem_diem_c;
    private int dem_diem_d;
    private int dem_diem_f;

    public Chart() {
    }

    public Chart(double diem_trung_binh, int so_tin_chi_rot, long tong_tin_chi, int hoc_ky, int dem_diem_a, int dem_diem_b, int dem_diem_c, int dem_diem_d, int dem_diem_f) {
        this.diem_trung_binh = diem_trung_binh;
        this.so_tin_chi_rot = so_tin_chi_rot;
        this.tong_tin_chi = tong_tin_chi;
        this.hoc_ky = hoc_ky;
        this.dem_diem_a = dem_diem_a;
        this.dem_diem_b = dem_diem_b;
        this.dem_diem_c = dem_diem_c;
        this.dem_diem_d = dem_diem_d;
        this.dem_diem_f = dem_diem_f;
    }

    public double getDiem_trung_binh() {
        return diem_trung_binh;
    }

    public void setDiem_trung_binh(double diem_trung_binh) {
        this.diem_trung_binh = diem_trung_binh;
    }

    public int getSo_tin_chi_rot() {
        return so_tin_chi_rot;
    }

    public void setSo_tin_chi_rot(int so_tin_chi_rot) {
        this.so_tin_chi_rot = so_tin_chi_rot;
    }

    public long getTong_tin_chi() {
        return tong_tin_chi;
    }

    public void setTong_tin_chi(long tong_tin_chi) {
        this.tong_tin_chi = tong_tin_chi;
    }

    public int getHoc_ky() {
        return hoc_ky;
    }

    public void setHoc_ky(int hoc_ky) {
        this.hoc_ky = hoc_ky;
    }

    public int getDem_diem_a() {
        return dem_diem_a;
    }

    public void setDem_diem_a(int dem_diem_a) {
        this.dem_diem_a = dem_diem_a;
    }

    public int getDem_diem_b() {
        return dem_diem_b;
    }

    public void setDem_diem_b(int dem_diem_b) {
        this.dem_diem_b = dem_diem_b;
    }

    public int getDem_diem_c() {
        return dem_diem_c;
    }

    public void setDem_diem_c(int dem_diem_c) {
        this.dem_diem_c = dem_diem_c;
    }

    public int getDem_diem_d() {
        return dem_diem_d;
    }

    public void setDem_diem_d(int dem_diem_d) {
        this.dem_diem_d = dem_diem_d;
    }

    public int getDem_diem_f() {
        return dem_diem_f;
    }

    public void setDem_diem_f(int dem_diem_f) {
        this.dem_diem_f = dem_diem_f;
    }
}
