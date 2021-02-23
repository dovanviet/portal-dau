package com.example.daumobile.ui.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.database.Constants;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.databinding.ActivityScheduleBinding;
import com.example.daumobile.model.Schedule;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.model.authen.Student;
import com.example.daumobile.model.authen.Teacher;
import com.example.daumobile.utils.DialogHandler;
import com.example.daumobile.utils.SharePrefUtils;
import com.example.daumobile.utils.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ScheduleActivity extends AppCompatActivity implements IListenerItemClicked {
    private ActivityScheduleBinding binding;
    private FirebaseManager mFirebaseManager;
    private DialogHandler mDialogHandler;
    private SharePrefUtils mSharePrefs;
    private Utility mUtils;
    private ScheduleAdapter mAdapter;
    private List<Schedule> mSchedulers;
    private List<Schedule> mCurrentSchedulers;
    private People mUser;
    private String mTypeOfSchedule = Constants.THOI_KHOA_BIEU;

    private static final String TAG = "__ScheduleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mFirebaseManager = FirebaseManager.getInstance(this);
        mDialogHandler = DialogHandler.getInstance();
        mSharePrefs = SharePrefUtils.getInstance(this);
        mUtils = Utility.getInstance();
        receiverData();
        setViews();
        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Only if you need to restore open/close state when
        // the orientation is changed
        if (mAdapter != null) {
            mAdapter.saveStates(outState);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Only if you need to restore open/close state when
        // the orientation is changed
        if (mAdapter != null) {
            mAdapter.restoreStates(savedInstanceState);
        }
    }

    private void receiverData() {
        Intent intent = getIntent();

        People people = (People) intent.getSerializableExtra(Constants.IT_PEOPLE);
        String type = intent.getStringExtra(Constants.IT_SCHEDULE);
        if (people != null) {
            mUser = people;
        }
        if (type != null) {
            mTypeOfSchedule = type;
        }
    }

    private void setViews() {
        mSchedulers = new ArrayList<>();
        mCurrentSchedulers = new ArrayList<>();
        if (mUser instanceof Student) {
            mAdapter = new ScheduleAdapter(mCurrentSchedulers, this, false);
        } else {
            mAdapter = new ScheduleAdapter(mCurrentSchedulers, this, true);
        }

        binding.recyclerviewSchedule.setAdapter(mAdapter);
        binding.recyclerviewSchedule.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerviewSchedule.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.recyclerviewSchedule.addItemDecoration(dividerItemDecoration);

        binding.tvTitle.setText(mTypeOfSchedule);
        binding.tvTime.setText(mSharePrefs.getYear() + " / HK" + mSharePrefs.getSemester());
        binding.tvWeekValue.setText("Tuần " + mSharePrefs.getWeek());

    }

    private void setListeners() {
        mFirebaseManager.getScheduleData().observe(this, schedulers -> {
            mSchedulers.clear();

            for (Schedule schedule : schedulers) {
                if (mTypeOfSchedule.equals(Constants.THOI_KHOA_BIEU) && mUser instanceof Student && schedule.getLopHoc().toLowerCase().contains(((Student) mUser).getLopHoc().toLowerCase())) {
                    mSchedulers.add(schedule);
                } else if (mTypeOfSchedule.equals(Constants.LICH_THI)) {
                    // NOTHING
                } else if (mTypeOfSchedule.equals(Constants.LICH_DAY) && mUser instanceof Teacher && schedule.getTenGiangVien().toLowerCase().equals(mUser.getName().toLowerCase())) {
                    mSchedulers.add(schedule);
                }
            }
            updateData();
            Log.d(TAG, "setListeners: 2 ???? " + mSchedulers.size());
//            mAdapter.updateList(mSchedulers);
        });

        binding.btnWeek.setOnClickListener(v -> {
            List<Integer> weeks = mUtils.getWeekListForSemester(mSharePrefs.getSemester());
            int position = mUtils.getPositionInArray((ArrayList<Integer>) weeks, mSharePrefs.getWeek());

            mDialogHandler.singleChoiceDialog(this, (ArrayList<Integer>) weeks, position, "Chọn tuần", "Đồng ý", "Huỷ bỏ", selectedIndex -> {
                binding.tvWeekValue.setText("Tuần " + weeks.get(selectedIndex));
                mSharePrefs.saveWeek(weeks.get(selectedIndex));

                updateData();
            });
        });
        binding.btnTime.setOnClickListener(v -> {
            List<String> years = mUtils.getYearList(2016, 2021);
            List<Integer> semesters = mUtils.getSemester();

            int positionYear = mUtils.getPositionInArray((ArrayList<String>) years, mSharePrefs.getYear());
            int positionSemester = mUtils.getPositionInArray((ArrayList<Integer>) semesters, mSharePrefs.getSemester());

            mDialogHandler.singleChoiceDialog(this, (ArrayList<String>) years, positionYear, "Chọn năm", "Đồng ý", "Huỷ bỏ", selectedIndex -> {
                mDialogHandler.singleChoiceDialog(this, (ArrayList<Integer>) semesters, positionSemester, "Chọn học kỳ", "Đồng ý", "Huỷ bỏ", selectedSemesterIndex -> {
                    String year = years.get(selectedIndex);
                    int semester = semesters.get(selectedSemesterIndex);

                    mSharePrefs.saveSemester(semester);
                    mSharePrefs.saveYear(year);

                    binding.tvTime.setText(year + " / HK" + semester);
                    updateData();
                });
            });
        });
    }

    private void updateData() {
        String year = mSharePrefs.getYear();
        int semester = mSharePrefs.getSemester();
        int week = mSharePrefs.getWeek();

        mCurrentSchedulers.clear();

        for(Schedule schedule : mSchedulers) {
            if (schedule.getNam().equals(year) && schedule.getTuan() == week && Integer.parseInt(schedule.getHocky()) == semester) {
                mCurrentSchedulers.add(schedule);
            }
        }

        mAdapter.updateList(mCurrentSchedulers);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, mSchedulers.get(position).getTenHP(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemPauseClicked(int position) {
        Toast.makeText(this, "Pause at " + mSchedulers.get(position).getTenHP(), Toast.LENGTH_SHORT).show();
        // Pause and sends notify to users
        mAdapter.deleteItemAt(position);
        mFirebaseManager.onPauseSchedule(mSchedulers.get(position));
    }
}