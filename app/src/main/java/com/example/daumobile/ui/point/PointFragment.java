package com.example.daumobile.ui.point;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.daumobile.databinding.FragmentPointBinding;

public class PointFragment extends Fragment {
    private FragmentPointBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPointBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
