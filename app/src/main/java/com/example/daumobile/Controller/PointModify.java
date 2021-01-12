package com.example.daumobile.Controller;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.Point;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class PointModify {
    private static PointModify INSTANCE;
    private Realm mRealm;

    private PointModify(Realm realm) {
        mRealm = realm;
    }

    public static PointModify getInstance(Realm realm) {
        if (INSTANCE == null) {
            INSTANCE = new PointModify(realm);
        }

        return INSTANCE;
    }

    public void insertPoint(final Point point) {
        mRealm.executeTransaction(realm -> mRealm.insert(point));
    }

    public void updatePoint(final int id_point, final Point point) {
        mRealm.executeTransaction(realm -> {
            Point pointUpdate = mRealm.where(Point.class).equalTo(Constants.KEY_ID_POINT, id_point).findFirst();
            pointUpdate.setTenHp(point.getTenHp());
            pointUpdate.setLoaiMonHoc(point.isLoaiMonHoc());
            pointUpdate.setDiemLan1(point.getDiemLan1());
            pointUpdate.setDiem_chu_lan_1(point.getDiem_chu_lan_1());
            pointUpdate.setDiem_chu_lan_2(point.getDiem_chu_lan_2());
            pointUpdate.setDiemLan2(point.getDiemLan2());
            pointUpdate.setMaHp(point.getMaHp());
        });
    }

    public void deletePoint(final int id_point) {
        mRealm.executeTransaction(realm -> {
            Point pointDelete = mRealm.where(Point.class).equalTo(Constants.KEY_ID_POINT, id_point).findFirst();
            pointDelete.deleteFromRealm();
        });
    }

    public RealmResults<Point> queryAllData() {
        return mRealm.where(Point.class).findAll();
    }

    public RealmResults<Point> queryAllData(int hoc_ky) {
        return mRealm.where(Point.class).equalTo(Constants.KEY_HOC_KY, hoc_ky).findAll();
    }

    public ArrayList<Point> queryAllData_ArrayList(int hoc_ky) {
        ArrayList<Point> points = new ArrayList<>();
        RealmResults<Point> realmResult = queryAllData(hoc_ky);

        for (Point point : realmResult) {
            points.add(point);
        }

        return points;
    }

    public long queryHocKyMax() {
        return (long) mRealm.where(Point.class).max(Constants.KEY_HOC_KY);
    }

}
