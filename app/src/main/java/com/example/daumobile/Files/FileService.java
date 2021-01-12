package com.example.daumobile.Files;

import android.os.Environment;
import android.util.Log;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.Point;
import com.example.daumobile.Model.Program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {
    private static final String TAG = "LOG_FILE";
/*
    public static ArrayList<Point> readPoint(String path) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), path);
        Log.d(TAG, "readProgram: 1 - " + file.getPath());
        if (!file.exists()) {
            Log.d(TAG, "readPoint: FILE POINT.DAT IS NOT EXISTS");
        }
        ArrayList<Point> result = new ArrayList<>();

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            String readLine;
            while ((readLine = bfr.readLine()) != null) {
                if (readLine.trim().startsWith("//") || readLine.trim().isEmpty())
                    continue;
                Log.d(TAG, "readSchedule: " + readLine);
// STT ->	Mã học phần ->	Tên học phần->	Tín chỉ->	Loại môn học->	Điểm->	Điểm chữ->	Điểm lần 2 ->	Điểm chữ lần 2
                String[] splits = readLine.split("->");
                int id = Integer.parseInt(splits[0].trim());
                String ma_hoc_phan = splits[1].trim();
                String ten_hoc_phan = splits[2].trim();
                int so_tin_chi = Integer.parseInt(splits[3].trim());
                int diem_lan_1 = 0;
                String diem_chu_lan_1 = "";

                if (!splits[5].trim().isEmpty()) {
                    diem_lan_1 = Integer.parseInt(splits[5].trim());
                    diem_chu_lan_1 = splits[6].trim();
                }
                int diem_lan_2 = 0;
                String diem_chu_lan_2 = "";
                if (!splits[7].trim().isEmpty()) {
                    diem_lan_2 = Integer.parseInt(splits[7].trim());
                    diem_chu_lan_2 = splits[8].trim();
                }

                int hoc_ky = Integer.parseInt(splits[9].trim());

                String Str_loai_mon_hoc = splits[3].trim();
                boolean loai_mon_hoc = false;
                if (Str_loai_mon_hoc.equals(Constants.PROGRAM_TY_BATBUOC)) {
                    loai_mon_hoc = true;
                }
                Log.d("LOG_POINT", "(" + ma_hoc_phan + "," + ten_hoc_phan + ", " + so_tin_chi + "," + loai_mon_hoc
                        + ", " + diem_lan_1 + "," + diem_lan_2 + ")");
                result.add(new Point(id, ma_hoc_phan, ten_hoc_phan, so_tin_chi, loai_mon_hoc, diem_lan_1, diem_lan_2, hoc_ky));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }*/
/*
    public static ArrayList<Program> readProgram(String path) {
//        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), path);
        Log.d(TAG, "readProgram: 1 - " + file.getPath());
        if (!file.exists()) {
            Log.d(TAG, "readPoint: FILE PROGRAM.DAT IS NOT EXISTS");
        }
        ArrayList<Program> result = new ArrayList<>();

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            String readLine;
            while ((readLine = bfr.readLine()) != null) {
                if (readLine.trim().startsWith("//") || readLine.trim().isEmpty())
                    continue;
                Log.d(TAG, "readSchedule: " + readLine);
//STT->	Tên chương trình đào tạo->	Mã học phần	->Tên học phần->	Loại học phần->	ĐVHT/STC
                String[] splits = readLine.split("->");
                Log.d(TAG, "readProgram: " + splits);
                int id = Integer.parseInt(splits[0].trim());
                String ten_chuong_trinh_dao_tao = splits[1].trim();
                String ma_hoc_phan = splits[2].trim();
                String ten_hoc_phan = splits[3].trim();
                String str_loai_hoc_phan = splits[4].trim();
                int so_tin_chi = Integer.parseInt(splits[5].trim());

                boolean loai_hoc_phan = false;
                if (str_loai_hoc_phan.equals(Constants.PROGRAM_TY_BATBUOC)) {
                    loai_hoc_phan = true;
                }

                int hoc_ky = Integer.parseInt(splits[6].trim());
                Log.d("LOG_HOC_KY", "(" + ten_chuong_trinh_dao_tao + "," + ma_hoc_phan + ", " + ten_hoc_phan + "," + loai_hoc_phan
                        + ", " + so_tin_chi + "," + hoc_ky + " )");
                result.add(new Program(id, ten_chuong_trinh_dao_tao, ma_hoc_phan, ten_hoc_phan, loai_hoc_phan, so_tin_chi, hoc_ky));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }*/
/*
    public static ArrayList<Schedule> readSchedule(String path) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), path);
        Log.d(TAG, "readProgram: 1 - " + file.getPath());
        if (!file.exists()) {
            Log.d(TAG, "readPoint: FILE SCHEDULE.DAT IS NOT EXISTS");

        }
        ArrayList<Schedule> result = new ArrayList<>();

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            String readLine;
            int id = 1;
            while ((readLine = bfr.readLine()) != null) {
                if (readLine.trim().startsWith("//") || readLine.trim().isEmpty())
                    continue;
                Log.d(TAG, "readSchedule: " + readLine);
//STT->	Tên chương trình đào tạo->	Mã học phần	->Tên học phần->	Loại học phần->	ĐVHT/STC
                String[] splits = readLine.split("->");
                String ma_lop_hp = splits[0].trim();
                String ten_hoc_phan = splits[1].trim();
                String str_loai_hoc_phan = splits[2].trim();
                int so_tin_chi = Integer.parseInt(splits[3].trim());
                String lop = splits[4].trim();
                int so_tiet = Integer.parseInt(splits[5].trim());
                String giang_vien = splits[6].trim();
                String ngay_hoc = splits[7].trim();
                String buoi = splits[8].trim();
                String tiet = splits[9].trim();
                String phong = splits[10].trim();
                String thoi_gian = splits[11].trim();
                int tuan = Integer.parseInt(splits[12].trim());

                boolean loai_hoc_phan = false;
                if (str_loai_hoc_phan.equals(Constants.PROGRAM_TY_BATBUOC)) {
                    loai_hoc_phan = true;
                }
                Log.d("LOG_Schedule", "(" + ma_lop_hp + "," + ten_hoc_phan + ", " + loai_hoc_phan + "," + so_tin_chi
                        + ", " + lop + "," + so_tiet + ", " + giang_vien + ", " + ngay_hoc + ", " + buoi + ", " + tiet + ", " + phong
                        + "," + thoi_gian + "," + tuan + ")");
                result.add(new Schedule(id, ma_lop_hp, ten_hoc_phan, loai_hoc_phan, so_tin_chi, lop, so_tiet, giang_vien, ngay_hoc, buoi, tiet, phong, thoi_gian, tuan));

                id++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }*/
}
