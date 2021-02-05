package com.example.daumobile.ui.user;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.daumobile.databinding.ActivityUserBinding;
import com.example.daumobile.ui.base.BaseActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserActivity extends BaseActivity<ActivityUserBinding> {

    @Override
    protected ActivityUserBinding getBinding() {
        return ActivityUserBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

    }
}
