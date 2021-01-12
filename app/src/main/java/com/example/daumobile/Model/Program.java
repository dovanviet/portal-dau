package com.example.daumobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmField;

public class Program extends RealmObject {
    @RealmField(name = "id_program")
    @PrimaryKey
    @SerializedName("id_program")
    @Expose
    private int idProgram;
    @RealmField(name = "ten_chuong_trinh_dao_tao")
    @SerializedName("ten_chuong_trinh_dao_tao")
    @Expose
    private String tenChuongTrinhDaoTao;
    @RealmField(name = "ma_hp")
    @SerializedName("ma_hp")
    @Expose
    private String maHp;
    @RealmField(name = "ten_hp")
    @SerializedName("ten_hp")
    @Expose
    private String tenHp;
    @RealmField(name = "loai_hp")
    @SerializedName("loai_hp")
    @Expose
    private boolean loaiHp;
    @RealmField(name = "stc")
    @SerializedName("stc")
    @Expose
    private int stc;
    @RealmField(name = "hoc_ky")
    @SerializedName("hoc_ky")
    @Expose
    private int hocKy;

    public Program(int idProgram, String tenChuongTrinhDaoTao, String maHp, String tenHp, boolean loaiHp, int stc, int hocKy) {
        this.idProgram = idProgram;
        this.tenChuongTrinhDaoTao = tenChuongTrinhDaoTao;
        this.maHp = maHp;
        this.tenHp = tenHp;
        this.loaiHp = loaiHp;
        this.stc = stc;
        this.hocKy = hocKy;
    }

    public Program() {
    }

    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public String getTenChuongTrinhDaoTao() {
        return tenChuongTrinhDaoTao;
    }

    public void setTenChuongTrinhDaoTao(String tenChuongTrinhDaoTao) {
        this.tenChuongTrinhDaoTao = tenChuongTrinhDaoTao;
    }

    public String getMaHp() {
        return maHp;
    }

    public void setMaHp(String maHp) {
        this.maHp = maHp;
    }

    public boolean isLoaiHp() {
        return loaiHp;
    }

    public void setLoaiHp(boolean loaiHp) {
        this.loaiHp = loaiHp;
    }

    public int getStc() {
        return stc;
    }

    public void setStc(int stc) {
        this.stc = stc;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public String getTenHp() {
        return tenHp;
    }

    public void setTenHp(String tenHp) {
        this.tenHp = tenHp;
    }
}
