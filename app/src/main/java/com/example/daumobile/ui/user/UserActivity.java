package com.example.daumobile.ui.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daumobile.database.Constants;
import com.example.daumobile.databinding.ActivityUserBinding;
import com.example.daumobile.model.authen.PEOPLE_TYPE;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.model.authen.Student;
import com.example.daumobile.model.authen.Teacher;

public class UserActivity extends AppCompatActivity {
    private ActivityUserBinding binding;
    private People mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        binding.tvValueName.setText(mUser.getName());
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