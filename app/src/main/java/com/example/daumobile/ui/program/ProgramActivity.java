package com.example.daumobile.ui.program;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.daumobile.database.Constants;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.databinding.ActivityProgramBinding;
import com.example.daumobile.model.Program;
import com.example.daumobile.model.authen.People;

import java.util.ArrayList;
import java.util.List;

public class ProgramActivity extends AppCompatActivity {

    private FirebaseManager mFirebaseManager;
    private List<Program> mPrograms;
    private ProgramAdapter mAdapter;
    private ActivityProgramBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProgramBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setViews();
        setListeners();
    }

    private void setViews() {
        mFirebaseManager = FirebaseManager.getInstance(this);
        mPrograms = new ArrayList<>();
        mAdapter = new ProgramAdapter(mPrograms);

        binding.recyclerviewProgram.setAdapter(mAdapter);
        binding.recyclerviewProgram.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerviewProgram.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.recyclerviewProgram.addItemDecoration(dividerItemDecoration);
    }

    private void setListeners() {
        mFirebaseManager.getProgramData().observe(this, programs -> {
            mPrograms = programs;

            mAdapter.updateList(mPrograms);
        });
    }
}