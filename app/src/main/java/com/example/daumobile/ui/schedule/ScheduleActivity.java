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

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity implements IListenerItemClicked {
    private ActivityScheduleBinding binding;
    private FirebaseManager mFirebaseManager;
    private ScheduleAdapter mAdapter;
    private List<Schedule> mSchedulers;
    private People mUser;
    private String mTypeOfSchedule = Constants.THOI_KHOA_BIEU;

    private static final String TAG = "__ScheduleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mFirebaseManager = FirebaseManager.getInstance();
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
        if (mUser instanceof Student) {
            mAdapter = new ScheduleAdapter(mSchedulers, this, false);
        } else {
            mAdapter = new ScheduleAdapter(mSchedulers, this, true);
        }

        binding.recyclerviewSchedule.setAdapter(mAdapter);
        binding.recyclerviewSchedule.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerviewSchedule.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.recyclerviewSchedule.addItemDecoration(dividerItemDecoration);

        binding.tvTitle.setText(mTypeOfSchedule);
    }

    private void setListeners() {
        mFirebaseManager.getScheduleData().observe(this, schedulers -> {
            mSchedulers.clear();

            for(Schedule schedule : schedulers) {
                if (mTypeOfSchedule.equals(Constants.THOI_KHOA_BIEU) &&  mUser instanceof Student && schedule.getLopHoc().toLowerCase().contains(((Student)mUser).getLopHoc().toLowerCase()) ) {
                    mSchedulers.add(schedule);
                } else if (mTypeOfSchedule.equals(Constants.LICH_THI)) {
                    // NOTHING
                } else if (mTypeOfSchedule.equals(Constants.LICH_DAY) && mUser instanceof Teacher && schedule.getTenGiangVien().toLowerCase().equals(mUser.getName().toLowerCase())) {
                    mSchedulers.add(schedule);
                }
            }

            mAdapter.updateList(mSchedulers);
        });
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, mSchedulers.get(position).getTenHP(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemPauseClicked(int position) {
        Toast.makeText(this, "Pause at " + mSchedulers.get(position).getTenHP(), Toast.LENGTH_SHORT).show();
        mAdapter.deleteItemAt(position);
        mSchedulers.remove(position);
    }
}