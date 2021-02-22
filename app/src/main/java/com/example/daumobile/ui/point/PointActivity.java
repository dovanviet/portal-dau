package com.example.daumobile.ui.point;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.database.Constants;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.databinding.ActivityPointBinding;
import com.example.daumobile.model.Point;
import com.example.daumobile.model.User;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.model.authen.Student;

import java.util.ArrayList;
import java.util.List;

public class PointActivity extends AppCompatActivity implements IListenerItemClicked {
    private ActivityPointBinding binding;
    private FirebaseManager mFirebaseManager;
    private PointAdapter mAdapter;
    private List<Point> mPoints;
    private People mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPointBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

    private void setViews(){
        mFirebaseManager = FirebaseManager.getInstance(this);
        mPoints = new ArrayList<>();
        mAdapter = new PointAdapter(this, mPoints, this);

        binding.recyclerviewPoint.setAdapter(mAdapter);
        binding.recyclerviewPoint.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerviewPoint.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.recyclerviewPoint.addItemDecoration(dividerItemDecoration);
    }

    private void setListeners() {
        mFirebaseManager.getPointData().observe(this, points -> {
            mPoints.clear();

            for (Point point: points) {
                if (mUser instanceof Student && point.getMssv().toLowerCase().contains(((Student)mUser).getId().toLowerCase()) ) {
                    mPoints.add(point);
                }
            }

            mAdapter.updateList(mPoints);
        });
    }
}