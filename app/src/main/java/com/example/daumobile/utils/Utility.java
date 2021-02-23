package com.example.daumobile.utils;

import com.example.daumobile.R;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    private static Utility INSTANCE;

    private Utility() {

    }

    public static Utility getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Utility();
        }
        return INSTANCE;
    }

    public int getIdImagePoint(double diem_lan_1, double diem_lan_2) {
        int point_max = Math.max(convertPoint10To4(diem_lan_1), convertPoint10To4(diem_lan_2));
        switch (point_max) {
            case 4:
                return R.mipmap.a;
            case 3:
                return R.mipmap.b;
            case 2:
                return R.mipmap.c;
            case 1:
                return R.mipmap.d;
        }
        return R.mipmap.f;
    }

    private int convertPoint10To4(double point) {
        if (point >= 8.5) {
            return 4;
        } else if (point >= 7) {
            return 3;
        } else if (point >= 6) {
            return 2;
        } else if (point >= 5) {
            return 1;
        } else {
            return 0;
        }
    }

    public double tinh_diem_trung_binh(ArrayList<Integer> ds_diem, long tong_tin_chi) {
        long tong_diem = 0;
        for (int diem : ds_diem) {
            tong_diem += diem;
        }

        return tong_diem / (tong_tin_chi * 1.0);
    }

    public int getPositionInArray(ArrayList<Integer> array, int  value){
        int position = -1;
        for(int i = 0 ; i < array.size() ; i++){
            if (array.get(i) == value) {
                position = i;
                break;
            }
        }

        return position;
    }

    public int getPositionInArray(ArrayList<String> array, String value) {
        int position = -1;
        for(int i = 0 ; i < array.size() ; i++){
            if (array.get(i).equals(value)) {
                position = i;
                break;
            }
        }

        return position;
    }

    public List<Integer> getWeekListForSemester(int semester) {
        List<Integer> results = new ArrayList<>();
        int start = 1, end = 20;
        if (semester == 2) {
            start = 21;
            end = 43;
        } else if (semester > 2) {
            start = 44;
            end = 52;
        }

        for(int index = start; index <= end; index++) {
            results.add(index);
        }

        return results;
    }

    public List<String> getYearList(int start, int end) {
        List<String> results = new ArrayList<>();

        for(int index = start; index <= end ; index++){
            String value = index + "-" + (index+1);
            results.add(value);
        }

        return results;
    }

    public List<Integer> getSemester() {
        List<Integer> results = new ArrayList<>();
        results.add(1);
        results.add(2);
        results.add(3);

        return results;
    }

}
