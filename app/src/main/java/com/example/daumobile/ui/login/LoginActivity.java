package com.example.daumobile.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.Schedule;
import com.example.daumobile.Model.authen.PEOPLE_TYPE;
import com.example.daumobile.Model.authen.People;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.ui.admin.AdminActivity;
import com.example.daumobile.ui.base.BaseActivity;
import com.example.daumobile.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "__LoginActivity";

    private com.example.daumobile.databinding.ActivityLoginBinding binding;
    private FirebaseManager mFirebaseManager;

    private List<People> mPeople = new ArrayList<>();
    private Boolean isStudent = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.daumobile.databinding.ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mFirebaseManager = FirebaseManager.getInstance(this);

//        Schedule schedule = new Schedule("HP1", "ABC T", "LOAI", 1,"16CT",3,"admin", "thu 2", 100111, "chieu", "6 - 9");
//        mFirebaseManager.createSchedule(schedule);

        setListeners();
    }

    public People findUser(String id, String password, int level) {
        if (id.equals("admin") && password.equals("admin")){
            return new People("admin", "admin");
        }
        for(People people : mPeople) {
            if (people.getId().equals(id) && people.getPassword().equals(password) && people.getType() == level){
                return people;
            }
        }
        return null;
    }

    public void setListeners(){
        binding.btnLogin.setOnClickListener(v -> {

            String id = binding.edtId.getText().toString();
            String password = binding.edtPassword.getText().toString();
            int level = PEOPLE_TYPE.STUDENT.getValue();

            if (!isStudent) {
                level = PEOPLE_TYPE.TEACHER.getValue();
            }

            People peopleFound = findUser(id, password, level);
            if (id.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập id", Toast.LENGTH_SHORT).show();
                binding.edtId.requestFocus();
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                binding.edtPassword.requestFocus();
            } else if (peopleFound != null) {

                if (peopleFound.getId().equals("admin")) {
                    Intent intent = new Intent(this, AdminActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                } else {
                    Intent intent = new Intent(this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Constants.IT_PEOPLE, peopleFound);

                    startActivity(intent);
                }
            } else {
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu, vui lòng đăng nhập lại", Toast.LENGTH_SHORT).show();
            }
        });

        binding.switchStudent.setOnToggledListener((toggleableView, isOn) -> {
            if (isOn){
                binding.edtId.setHint("Mã sinh viên");
                isStudent = true;
            } else {
                binding.edtId.setHint("Mã giảng viên");
                isStudent = false;
            }
        });

        mFirebaseManager.getUserData().observe(this, logins -> {
            mPeople = logins;

            Log.d(TAG, "setListeners: " + logins);
        });
    }
}