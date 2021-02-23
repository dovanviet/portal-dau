package com.example.daumobile.utils;

import android.content.Context;

import com.example.daumobile.R;

import java.util.ArrayList;

public class Utility {
    private static Utility INSTANCE;
    private Context mContext;

    private Utility(Context context) {
        mContext = context;
    }

    public static Utility getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Utility(context);
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

    public int getPositionInWeekArray(ArrayList<Integer> arrayWeek, int currentWeek){
        int position = -1;

        for(int i = 0 ; i < arrayWeek.size() ; i++){
            if (arrayWeek.get(i) == currentWeek) {
                position = i;
                break;
            }
        }

        return position;
    }

}
