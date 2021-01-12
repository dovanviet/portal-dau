package com.example.daumobile.Controller;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.Program;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProgramModify {
    private static ProgramModify INSTANCE;
    private Realm mRealm;

    private ProgramModify(Realm realm) {
        mRealm = realm;
    }

    public static ProgramModify getInstance(Realm realm) {
        if (INSTANCE == null) {
            INSTANCE = new ProgramModify(realm);
        }

        return INSTANCE;
    }

    public void insertProgram(final Program program) {
        mRealm.executeTransaction(realm -> mRealm.insert(program));
    }

    public void updateProgram(final int id_schedule, final Program program) {
        mRealm.executeTransaction(realm -> {
            Program programUpdate = mRealm.where(Program.class).equalTo(Constants.KEY_ID_PROGRAM, id_schedule).findFirst();
            programUpdate.setLoaiHp(program.isLoaiHp());
            programUpdate.setMaHp(program.getMaHp());
            programUpdate.setStc(program.getStc());
            programUpdate.setTenChuongTrinhDaoTao(program.getTenChuongTrinhDaoTao());
            programUpdate.setTenHp(program.getTenHp());
        });
    }

    public void deleteProgram(final int id_schedule) {
        mRealm.executeTransaction(realm -> {
            Program scheduleDelete = mRealm.where(Program.class).equalTo(Constants.KEY_ID_SCHEDULE, id_schedule).findFirst();
            scheduleDelete.deleteFromRealm();
        });
    }

    public RealmResults<Program> queryAllData() {
        return mRealm.where(Program.class).findAll();
    }

    public RealmResults<Program> queryAllData(int hoc_ky) {
        return mRealm.where(Program.class).equalTo(Constants.KEY_HOC_KY, hoc_ky).findAll();
    }

    public long queryHocKyMax() {
        return (long) mRealm.where(Program.class).max(Constants.KEY_HOC_KY);
    }
}
