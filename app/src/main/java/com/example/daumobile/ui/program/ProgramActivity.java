package com.example.daumobile.ui.program;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.example.daumobile.databinding.ActivityProgramBinding;
import com.example.daumobile.ui.base.BaseActivity;

public class ProgramActivity extends BaseActivity<ActivityProgramBinding> {

    @Override
    protected ActivityProgramBinding getBinding() {
        return ActivityProgramBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

    }
}
