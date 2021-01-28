package com.example.daumobile.ui.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daumobile.R;
import com.example.daumobile.databinding.FragmentUserBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private FragmentUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
