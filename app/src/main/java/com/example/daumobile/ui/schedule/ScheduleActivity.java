package com.example.daumobile.ui.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity implements IListenerItemClicked {
    private ActivityScheduleBinding binding;
    private FirebaseManager mFirebaseManager;
    private ScheduleAdapter mAdapter;
    private List<Schedule> mSchedulers;
    private People mUser;

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

    private void receiverData() {
        Intent intent = getIntent();

        People people = (People) intent.getSerializableExtra(Constants.IT_PEOPLE);
        if (people != null) {
            mUser = people;
        }
    }

    private void setViews() {
        mSchedulers = new ArrayList<>();
        mAdapter = new ScheduleAdapter(mSchedulers, this);

        binding.recyclerviewSchedule.setAdapter(mAdapter);
        binding.recyclerviewSchedule.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerviewSchedule.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.recyclerviewSchedule.addItemDecoration(dividerItemDecoration);
    }

    private void setListeners() {
        mFirebaseManager.getScheduleData().observe(this, schedulers -> {
            mSchedulers.clear();

            for(Schedule schedule : schedulers) {
                Log.d(TAG, "setListeners: " + schedule.getLopHoc() + " - " + ((Student)mUser).getLopHoc());

                if (mUser instanceof Student && schedule.getLopHoc().toLowerCase().contains(((Student)mUser).getLopHoc().toLowerCase()) ) {
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
}