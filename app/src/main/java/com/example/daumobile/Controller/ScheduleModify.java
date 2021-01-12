package com.example.daumobile.Controller;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.Schedule;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ScheduleModify {
    private static ScheduleModify INSTANCE;
    private Realm mRealm;

    private ScheduleModify(Realm realm) {
        mRealm = realm;
    }

    public static ScheduleModify getInstance(Realm realm) {
        if (INSTANCE == null) {
            INSTANCE = new ScheduleModify(realm);
        }

        return INSTANCE;
    }

    public void insertSchedule(final Schedule schedule) {
        mRealm.executeTransaction(realm -> mRealm.insert(schedule));
    }

    public void updateSchedule(final int id_schedule, final Schedule schedule) {
        mRealm.executeTransaction(realm -> {
            Schedule scheduleUpdate = mRealm.where(Schedule.class).equalTo(Constants.KEY_ID_SCHEDULE, id_schedule).findFirst();
            scheduleUpdate.setLopHoc(schedule.getLopHoc());
            scheduleUpdate.setBuoi(schedule.getBuoi());
            scheduleUpdate.setGiangVien(schedule.getGiangVien());
            scheduleUpdate.setMaLopHp(schedule.getMaLopHp());
            scheduleUpdate.setLoaiHp(schedule.getLoaiHp());
            scheduleUpdate.setNgayHoc(schedule.getNgayHoc());
            scheduleUpdate.setPhong(schedule.getPhong());
            scheduleUpdate.setSoTiet(schedule.getSoTiet());
            scheduleUpdate.setThoiGian(schedule.getThoiGian());
            scheduleUpdate.setTiet(schedule.getTiet());
        });
    }

    public void deleteSchedule(final int id_schedule) {
        mRealm.executeTransaction(realm -> {
            Schedule scheduleDelete = mRealm.where(Schedule.class).equalTo(Constants.KEY_ID_SCHEDULE, id_schedule).findFirst();
            scheduleDelete.deleteFromRealm();
        });
    }

    public RealmResults<Schedule> queryAllData() {
        return mRealm.where(Schedule.class).findAll();
    }

    public RealmResults<Schedule> queryAllData(int tuan) {
        return mRealm.where(Schedule.class).equalTo(Constants.KEY_TUAN, tuan).findAll();
    }

    public ArrayList<Integer> queryAllWeek() {
        RealmResults<Schedule> realmResults = mRealm.where(Schedule.class).distinct(Constants.KEY_TUAN).findAll();
        ArrayList<Integer> result = new ArrayList<>();

        for(Schedule schedule : realmResults){
           result.add(schedule.getTuan());
        }

        return result;
    }
}
