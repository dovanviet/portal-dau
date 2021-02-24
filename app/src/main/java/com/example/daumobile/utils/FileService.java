package com.example.daumobile.utils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.model.Point;
import com.example.daumobile.model.Program;
import com.example.daumobile.model.Schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {
    private static final String TAG = "__LOG_FILE";
    private static FileService mInstance;
    private FirebaseManager mFirebaseManager;

    private FileService(@NonNull Context context) {
        mFirebaseManager = FirebaseManager.getInstance(context);
    }

    public static FileService getInstance(@NonNull Context context) {
        if (mInstance == null) {
            mInstance = new FileService(context);
        }
        return mInstance;
    }

    public void readPoint(Context context) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(context.getAssets().open("diem.dat"), "UTF-8"))) {

            // MSSV -> Tên học phần -> tín chỉ -> điểm ( hệ 10 ) -> điểm lần 1 -> điểm lần 2
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                if (mLine.trim().startsWith("//") || mLine.isEmpty()) {
                    continue;
                }
                Log.d(TAG, "readPoint: " + mLine);
                String[] splits = mLine.split("->");
                String mssv = splits[0].trim();
                String tenHp = splits[1].trim();
                int tinChi = Integer.parseInt(splits[2].trim());
                double diemTb = Integer.parseInt(splits[3].trim());
                String diem1 = splits[4].trim();
                String diem2 = "";
                int hocKy = Integer.parseInt(splits[6].trim());

                if (splits.length > 5) {
                    diem2 = splits[5].trim();
                }

                double diemDb1 = 0.0;
                double diemDb2 = 0.0;
                if (!diem1.isEmpty()) {
                    diemDb1 = Double.parseDouble(diem1);
                }
                if (!diem2.isEmpty()) {
                    diemDb2 = Double.parseDouble(diem2);
                }

                Point point = new Point(mssv, tenHp, tinChi, diemTb, diemDb1, diemDb2, hocKy);
                mFirebaseManager.addPoint(point);
            }
        } catch (IOException e) {
            //log the exception
        }
    }

    public void readProgram(Context context) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(context.getAssets().open("chuongtrinhdaotao.dat"), "UTF-8"))) {

            //STT->	Tên chương trình đào tạo->	Mã học phần	->Tên học phần->	Loại học phần->	ĐVHT/STC  -> học kỳ -> Năm
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                if (mLine.trim().startsWith("//")  || mLine.isEmpty()) {
                    continue;
                }
                String[] splits = mLine.split("->");

                String stt = splits[0].trim();
                String tenLop = splits[1].trim();
                String maHP = splits[2].trim();
                String tenHP = splits[3].trim();
                String loaiHP = splits[4].trim();
                String stc = splits[5].trim();
                int hocKy = Integer.parseInt(splits[6].trim());
                String nam = splits[7].trim();

                Program program = new Program(stt, tenLop, maHP, tenHP, loaiHP, stc, hocKy, nam);
                mFirebaseManager.addProgram(program);
            }
        } catch (IOException e) {
            //log the exception
        }
    }

    public void readSchedule(Context context) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(context.getAssets().open("lichhoc.dat"), "UTF-8"))) {

            //Mã lớp HP -> Tên học phần-> Loại học phần ->STC-> lớp học -> số tiết -> giảng viên -> ngày học -> buổi -> tiết -> phòng -> thời gian -> học kỳ -> Năm -> tạm dừng
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                if (mLine.trim().startsWith("//")  || mLine.isEmpty()) {
                    continue;
                }
                String[] splits = mLine.split("->");

                Log.d(TAG, "readSchedule: " + splits[0] + " - " + splits[1]);

                String maHP = splits[0].trim();
                String tenHP = splits[1].trim();
                String loaiHP = splits[2].trim();
                String stc = splits[3].trim();
                String lopHoc = splits[4].trim();
                String soTiet = splits[5].trim();
                String giangVien = splits[6].trim();
                String ngayHoc = splits[7].trim();
                String buoi = splits[8].trim();
                String tiet = splits[9].trim();
                String phong = splits[10].trim();
                String thoiGian = splits[11].trim();
                String hocKy = splits[12].trim();
                String nam = splits[13].trim();
                String tamDung = splits[14].trim();
                String tuan = splits[15].trim();

                boolean tamdungB = false;
                if (!tamDung.equals("0")) {
                    tamdungB = true;
                }
                long thoiGianI = Integer.parseInt(thoiGian);
                Log.d(TAG, "readSchedule: maHP = " + maHP + " thoigian = " + thoiGianI);
                int soTietI = Integer.parseInt(soTiet);
                int soTinChiI = Integer.parseInt(stc);
                int tuanI = Integer.parseInt(tuan);

                //String maHP, String tenHP, String loaiHP, int soTinChi, String lopHoc, int soTiet, String tenGiangVien, String thoiGianDayTrongTuan, int thoiGian, String buoi, String tiet, boolean tamdung
                Schedule schedule = new Schedule(maHP, tenHP, loaiHP, soTinChiI, lopHoc, soTietI, giangVien, ngayHoc, thoiGianI, buoi, tiet, tamdungB, hocKy, nam, phong,tuanI);
                mFirebaseManager.addSchedule(schedule);
            }
        } catch (IOException e) {
            //log the exception
        }
    }

    public void readTestSchedule(Context context) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(context.getAssets().open("lichthi.dat"), "UTF-8"))) {

            //Mã lớp HP -> Tên học phần-> Loại học phần ->STC-> lớp học -> số tiết -> giảng viên -> ngày học -> buổi -> tiết -> phòng -> thời gian -> học kỳ -> Năm -> tạm dừng
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                if (mLine.trim().startsWith("//")  || mLine.isEmpty()) {
                    continue;
                }
                String[] splits = mLine.split("->");

                Log.d(TAG, "readSchedule: " + splits[0] + " - " + splits[1]);

                String maHP = splits[0].trim();
                String tenHP = splits[1].trim();
                String loaiHP = splits[2].trim();
                String stc = splits[3].trim();
                String lopHoc = splits[4].trim();
                String soTiet = splits[5].trim();
                String giangVien = splits[6].trim();
                String ngayHoc = splits[7].trim();
                String buoi = splits[8].trim();
                String tiet = splits[9].trim();
                String phong = splits[10].trim();
                String thoiGian = splits[11].trim();
                String hocKy = splits[12].trim();
                String nam = splits[13].trim();
                String tamDung = splits[14].trim();

                boolean tamdungB = false;
                if (!tamDung.equals("0")) {
                    tamdungB = false;
                }
                long thoiGianI = Integer.parseInt(thoiGian);
//                int soTietI = Integer.parseInt(soTiet);
//                int soTinChiI = Integer.parseInt(stc);
//                int tuanI = Integer.parseInt(tuan);

                //String maHP, String tenHP, String loaiHP, int soTinChi, String lopHoc, int soTiet, String tenGiangVien, String thoiGianDayTrongTuan, int thoiGian, String buoi, String tiet, boolean tamdung
                Schedule schedule = new Schedule(maHP, tenHP, loaiHP, 0, lopHoc, 0, giangVien, ngayHoc, thoiGianI, buoi, tiet, tamdungB, hocKy, nam, phong,0);
                mFirebaseManager.addSchedule(schedule);
            }
        } catch (IOException e) {
            //log the exception
        }
    }
}