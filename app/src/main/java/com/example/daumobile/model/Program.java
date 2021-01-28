package com.example.daumobile.model;

import java.util.Objects;

public class Program {
    String tenChuongTrinh;
    String maHP;
    String tenHP;
    String loaiHP;
    int soTinChi;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return soTinChi == program.soTinChi &&
                Objects.equals(tenChuongTrinh, program.tenChuongTrinh) &&
                Objects.equals(maHP, program.maHP) &&
                Objects.equals(tenHP, program.tenHP) &&
                Objects.equals(loaiHP, program.loaiHP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenChuongTrinh, maHP, tenHP, loaiHP, soTinChi);
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
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

    public Program() {
    }

    public Program(String tenChuongTrinh, String maHP, String tenHP, String loaiHP, int soTinChi) {
        this.tenChuongTrinh = tenChuongTrinh;
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.loaiHP = loaiHP;
        this.soTinChi = soTinChi;
    }
}
