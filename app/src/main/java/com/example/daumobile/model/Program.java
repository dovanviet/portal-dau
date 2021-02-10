package com.example.daumobile.model;

import java.util.Objects;
import java.util.UUID;

public class Program {
    //STT->	Tên chương trình đào tạo->	Mã học phần	->Tên học phần->	Loại học phần->	ĐVHT/STC  -> học kỳ -> Năm
    String id = UUID.randomUUID().toString();
    String stt;
    String tenLop;
    String maHP;
    String tenHP;
    String loaiHP;
    String stc;
    int hocky;
    String nam;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return hocky == program.hocky &&
                Objects.equals(id, program.id) &&
                Objects.equals(stt, program.stt) &&
                Objects.equals(tenLop, program.tenLop) &&
                Objects.equals(maHP, program.maHP) &&
                Objects.equals(tenHP, program.tenHP) &&
                Objects.equals(loaiHP, program.loaiHP) &&
                Objects.equals(stc, program.stc) &&
                Objects.equals(nam, program.nam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stt, tenLop, maHP, tenHP, loaiHP, stc, hocky, nam);
    }

    public String getId() {
        return id;
    }

    public String getStt() {
        return stt;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getMaHP() {
        return maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public String getLoaiHP() {
        return loaiHP;
    }

    public String getStc() {
        return stc;
    }

    public int getHocky() {
        return hocky;
    }

    public String getNam() {
        return nam;
    }

    public Program(String stt, String tenLop, String maHP, String tenHP, String loaiHP, String stc, int hocky, String nam) {
        this.stt = stt;
        this.tenLop = tenLop;
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.loaiHP = loaiHP;
        this.stc = stc;
        this.hocky = hocky;
        this.nam = nam;
    }

    public Program(String id, String stt, String tenLop, String maHP, String tenHP, String loaiHP, String stc, int hocky, String nam) {
        this.id = id;
        this.stt = stt;
        this.tenLop = tenLop;
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.loaiHP = loaiHP;
        this.stc = stc;
        this.hocky = hocky;
        this.nam = nam;
    }

    public Program() {
    }
}
