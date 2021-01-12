package com.example.daumobile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.API.APIClient;
import com.example.daumobile.API.RequestAPI;
import com.example.daumobile.Adapter.PointAdapter;
import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Controller.PointModify;
import com.example.daumobile.Model.Point;

import java.util.ArrayList;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PointFragment extends Fragment {
    private RecyclerView mRecyclerviewPoint;
    private Realm mRealm;
    private RealmResults<Point> mRealmResult;
    private PointAdapter mPointAdapter;
    private TextView tv_point_dtb;
    private TextView tv_point_stc_fail;
    private TextView tv_point_hocluc;
    private TextView tv_point_name_semester;
    private ImageView img_point_sub_semester;
    private ImageView img_point_plus_semester;
    private PointModify instancePoint;
    private Retrofit mRetrofit;
    private RequestAPI mCallApi;

    private int currentSemester = 1;

    public PointFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_point, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
//        initialization();
//        config();
//        setDataTotal();
//        setClick();
    }

//    private void setClick() {
//        img_point_sub_semester.setOnClickListener(v -> {
//            if (currentSemester > 1) {
//                changeSemester(false);
//            }
//        });
//
//        img_point_plus_semester.setOnClickListener(v -> {
//            long _maxSemester = instancePoint.queryHocKyMax();
//            if (currentSemester < _maxSemester) {
//                changeSemester(true);
//            }
//        });
//    }
//
//    private void changeSemester(boolean isPlus) {
//        if (isPlus) {
//            currentSemester++;
//        } else {
//            currentSemester--;
//        }
//
//        tv_point_name_semester.setText("Học kỳ " + currentSemester);
//        mRealmResult = (instancePoint.queryAllData(currentSemester));
//        mPointAdapter = new PointAdapter(Objects.requireNonNull(getContext()), mRealmResult, true);
//        mRecyclerviewPoint.setAdapter(mPointAdapter);
//    }
//
//    private void config() {
//        configRetrofit();
//        configRealm();
//        configRecyclerview();
//    }
//
//    private void configRetrofit() {
//        mRetrofit = APIClient.getClient();
//        mCallApi = mRetrofit.create(RequestAPI.class);
//    }
//
//    private void configRecyclerview() {
//        mPointAdapter = new PointAdapter(Objects.requireNonNull(getContext()), mRealmResult, true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);
//
//        mRecyclerviewPoint.setAdapter(mPointAdapter);
//        mRecyclerviewPoint.setLayoutManager(linearLayoutManager);
//        mRecyclerviewPoint.setHasFixedSize(true);
//        mRecyclerviewPoint.addItemDecoration(dividerItemDecoration);
//    }
//
//    private void configRealm() {
//        Realm.init(getActivity());
//        RealmConfiguration configPoint = new RealmConfiguration.Builder().name(Constants.KEY_TABLE_NAME_POINT)
//                .schemaVersion(1)
//                .build();
//
//        mRealm = Realm.getInstance(configPoint);
//        instancePoint = PointModify.getInstance(mRealm);
//        mRealmResult = instancePoint.queryAllData(currentSemester);
//
//        if (mRealmResult.size() == 0) {
//            addData();
//        }
//    }
//
//    private void addData() {
//        Call<ArrayList<Point>> call = mCallApi.getPoint();
//        call.enqueue(new Callback<ArrayList<Point>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Point>> call, Response<ArrayList<Point>> response) {
//                ArrayList<Point> points = response.body();
//                for (Point point : points) {
//                    instancePoint.insertPoint(point);
//                }
//                Log.i("LOG_SUCCESS", "onResponse: ");
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Point>> call, Throwable t) {
//                Log.i("LOG_FAIL", "onResponse: ");
//            }
//        });
//        mRealmResult = instancePoint.queryAllData(currentSemester);
//    }
//
//    private void initialization() {
//        mapp();
//
//    }
//
//    private void mapp() {
//        mRecyclerviewPoint = Objects.requireNonNull(getActivity()).findViewById(R.id.recyclerview_point);
//        tv_point_name_semester = getActivity().findViewById(R.id.tv_point_name_semester);
//        tv_point_stc_fail = getActivity().findViewById(R.id.tv_point_stc_fail);
//        tv_point_hocluc = getActivity().findViewById(R.id.tv_point_hocluc);
//        tv_point_name_semester = getActivity().findViewById(R.id.tv_point_name_semester);
//        tv_point_dtb = getActivity().findViewById(R.id.tv_point_dtb);
//        img_point_sub_semester = getActivity().findViewById(R.id.img_point_sub_semester);
//        img_point_plus_semester = getActivity().findViewById(R.id.img_point_plus_semester);
//    }
//
//    private void setDataTotal() {
//        long hoc_ky_max = instancePoint.queryHocKyMax();
//        long tong_tin_chi_rot = 0;
//        double diem_trung_binh = 0.0;
//        for (int i = 1; i <= hoc_ky_max; i++) {
//            long tong_tin_chi_hoc_ky = 0, tong_diem_hoc_ky = 0;
//            int tin_chi_rot_hoc_ky = 0;
//            double diem_trung_binh_hoc_ky;
//
//            ArrayList<Point> listPoint = instancePoint.queryAllData_ArrayList(i);
//
//            for (Point point : listPoint) {
//                int diem_lan_1 = point.getDiemLan1();
//                int diem_lan_2 = point.getDiemLan2();
//                int tin_chi = point.getStc();
//
//                tong_tin_chi_hoc_ky += tin_chi;
//                int diem_max = Math.max(diem_lan_1, diem_lan_2);
//                tong_diem_hoc_ky += (diem_max * tin_chi);
//                if (diem_max < 1) {
//                    tin_chi_rot_hoc_ky += tin_chi;
//                }
//            }
//
//            diem_trung_binh_hoc_ky = tong_diem_hoc_ky / (tong_tin_chi_hoc_ky * 1.0);
//            diem_trung_binh += diem_trung_binh_hoc_ky;
//            tong_tin_chi_rot += tin_chi_rot_hoc_ky;
//        }
//        diem_trung_binh = (diem_trung_binh / hoc_ky_max * 1.0);
//        tv_point_dtb.setText("Điểm trung bình: " + Math.round(diem_trung_binh * 100.0) / 100.0);
//        tv_point_stc_fail.setText("Tín chỉ rớt: " + tong_tin_chi_rot);
//    }
}
