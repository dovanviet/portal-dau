package com.example.daumobile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.API.APIClient;
import com.example.daumobile.API.RequestAPI;
import com.example.daumobile.Adapter.ScheduleAdapter;
import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Controller.DialogHandler;
import com.example.daumobile.Controller.ScheduleModify;
import com.example.daumobile.Model.Schedule;
import com.example.daumobile.Utils.Utility;

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
 */
public class ScheduleFragment extends Fragment {
    private RecyclerView mRecyclerviewSchedule;
    private Realm mRealm;
    private RealmResults<Schedule> mRealmResult;
    private ScheduleAdapter mScheduleAdapter;
    private ScheduleModify instanceSchedule;
    private Utility instanceUtility;
    private Button btn_schedule_semester;
    private Button btn_schedule_week;
    private TextView tv_schedule_semester_value;
    private TextView tv_schedule_week_value;
    private Retrofit mRetrofit;
    private RequestAPI mCallApi;
    private int currentWeek = 1;
    private DialogHandler instanceDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        initialization();
//        config();
//        setClick();
    }
//    private void initialization() {
//        mapp();
//        instanceDialog = DialogHandler.getInstance();
//        instanceUtility = Utility.getInstance(getActivity());
////        fileService = new FileService();
//    }
//
//    private void mapp() {
//        mRecyclerviewSchedule = getActivity().findViewById(R.id.recyclerview_schedule);
//        btn_schedule_semester = getActivity().findViewById(R.id.btn_schedule_semester);
//        btn_schedule_week = getActivity().findViewById(R.id.btn_schedule_week);
//        tv_schedule_semester_value = getActivity().findViewById(R.id.tv_schedule_semester_value);
//        tv_schedule_week_value = getActivity().findViewById(R.id.tv_schedule_week_value);
//    }

//    private void config() {
//        configRetrofit();
//        configRealm();
//        configRecyclerview();
//    }

//    private void configRetrofit() {
//        mRetrofit = APIClient.getClient();
//        mCallApi = mRetrofit.create(RequestAPI.class);
//    }
//
//    private void configRecyclerview() {
//        mScheduleAdapter = new ScheduleAdapter(Objects.requireNonNull(getContext()), mRealmResult, true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);
//        mRecyclerviewSchedule.setAdapter(mScheduleAdapter);
//        mRecyclerviewSchedule.setLayoutManager(linearLayoutManager);
//        mRecyclerviewSchedule.setHasFixedSize(true);
//        mRecyclerviewSchedule.addItemDecoration(dividerItemDecoration);
//    }
//
//    private void configRealm() {
//        Realm.init(Objects.requireNonNull(getActivity()));
//        RealmConfiguration configPoint = new RealmConfiguration.Builder().name(Constants.KEY_TABLE_NAME_SCHEDULE)
//                .schemaVersion(1)
//                .build();
//
//        mRealm = Realm.getInstance(configPoint);
//        instanceSchedule = ScheduleModify.getInstance(mRealm);
//        mRealmResult = instanceSchedule.queryAllData(currentWeek);
//        if (mRealmResult.size() == 0) {
//            addData();
//        }
//    }
//
//    private void setClick() {
//        btn_schedule_week.setOnClickListener(v -> {
//            final ArrayList<Integer> arrayWeek = instanceSchedule.queryAllWeek();
//            int positionCurrentWeek = instanceUtility.getPositionInWeekArray(arrayWeek, currentWeek);
//            instanceDialog.singleChoiceDialog(getActivity(), arrayWeek, positionCurrentWeek, "Choice week", "", "OK", "CANCEL", selectedIndex -> {
//                currentWeek = arrayWeek.get(selectedIndex);
//                tv_schedule_week_value.setText("Tuần " + currentWeek);
//
//                // update Adapter
//                mRealmResult = instanceSchedule.queryAllData(arrayWeek.get(selectedIndex));
//                mScheduleAdapter = new ScheduleAdapter(getContext(), mRealmResult, true);
//                mRecyclerviewSchedule.setAdapter(mScheduleAdapter);
//            });
//        });
//    }
//
//    private void addData() {
//        Call<ArrayList<Schedule>> callSchedule = mCallApi.getSchedule();
//
//        callSchedule.enqueue(new Callback<ArrayList<Schedule>>() {
//            // Connect thành công thì ở đây, đôi khi lỗi 400 có thể xuất hiện ở đây
//            @Override
//            public void onResponse(Call<ArrayList<Schedule>> call, Response<ArrayList<Schedule>> response) {
//                Log.d("LOG_SUCCESS", "onResponse: " + response.body().toString());
//                ArrayList<Schedule> schedules = response.body();
//                for (Schedule schedule : schedules) {
//                    instanceSchedule.insertSchedule(schedule);
//                }
//            }
//
//            // lỗi từ 200 - 300 ở đây
//            @Override
//            public void onFailure(Call<ArrayList<Schedule>> call, Throwable t) {
//                Log.d("LOG_FAIL", "onFailure: " + t.getMessage());
//            }
//        });
//
//    }
}
