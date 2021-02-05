package com.example.daumobile.ui.point;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.daumobile.databinding.ActivityPointBinding;
import com.example.daumobile.ui.base.BaseActivity;

public class PointActivity extends BaseActivity {
    @Override
    protected ViewBinding getBinding() {
        return ActivityPointBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

    }


}
