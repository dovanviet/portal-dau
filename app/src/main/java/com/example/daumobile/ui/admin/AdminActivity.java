package com.example.daumobile.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.daumobile.R;
import com.example.daumobile.databinding.ActivityAdminBinding;
import com.example.daumobile.ui.admin.detail.AddProgramActivity;
import com.example.daumobile.ui.base.BaseActivity;

public class AdminActivity extends BaseActivity {

    private ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
    }

    private void setListeners() {
        binding.btnAddPoint.setOnClickListener(v -> {

        });
        binding.btnAddProgram.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddProgramActivity.class);

            startActivity(intent);
        });
        binding.btnAddSchedule.setOnClickListener(v -> {

        });
    }
}