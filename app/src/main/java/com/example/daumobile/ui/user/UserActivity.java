package com.example.daumobile.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.daumobile.database.Constants;
import com.example.daumobile.databinding.ActivityProgramBinding;
import com.example.daumobile.databinding.ActivityUserBinding;
import com.example.daumobile.model.authen.PEOPLE_TYPE;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.model.authen.Student;
import com.example.daumobile.model.authen.Teacher;
import com.example.daumobile.ui.base.BaseActivity;


public class UserActivity extends AppCompatActivity {
    private ActivityUserBinding binding;
    private People mUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        receiverData();
        setViews();
    }

    private void receiverData() {
        Intent intent = getIntent();

        People people = (People) intent.getSerializableExtra(Constants.IT_PEOPLE);
        if (people != null) {
            mUser = people;
        }
    }

    private void setViews() {
        binding.tvValueAddress.setText(mUser.getAddress());
        binding.tvValueCode.setText(mUser.getId());
        binding.tvValueNumberPhone.setText(mUser.getNumberphone());

        if (mUser.getType() == PEOPLE_TYPE.STUDENT.getValue()) {
            binding.tvTitleClass.setText("Lớp");
            binding.tvValueClass.setText(((Student)mUser).getLopHoc());
        } else {
            binding.tvTitleClass.setText("Môn dạy");
            binding.tvValueClass.setText(((Teacher)mUser).getMonDay());
        }
    }
}
