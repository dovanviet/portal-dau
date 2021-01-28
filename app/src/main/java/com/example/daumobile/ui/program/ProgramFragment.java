package com.example.daumobile.ui.program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.daumobile.databinding.FragmentProgramBinding;

public class ProgramFragment extends Fragment {
    private FragmentProgramBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProgramBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
