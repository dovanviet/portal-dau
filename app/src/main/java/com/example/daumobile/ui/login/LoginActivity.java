package com.example.daumobile.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daumobile.database.Constants;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.databinding.ActivityLoginBinding;
import com.example.daumobile.model.Point;
import com.example.daumobile.model.authen.PEOPLE_TYPE;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.ui.home.HomeActivity;
import com.example.daumobile.utils.FileService;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "__Login2Activity";

    private ActivityLoginBinding binding;
    private FirebaseManager mFirebaseManager;
    private List<People> mPeople = new ArrayList<>();
    private Boolean isStudent = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //add data
//        FileService.readPoint(this);
//        FileService.readProgram(this);
//        FileService.readSchedule(this);

        mFirebaseManager = FirebaseManager.getInstance(this);
        setListeners();
    }

    public People findUser(String id, String password, int level) {
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
                Intent intent = new Intent(this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Constants.IT_PEOPLE, peopleFound);

                startActivity(intent);
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

        mFirebaseManager.getUserData().observe(this, people -> {
            Log.d(TAG, "setListeners: " + people);
            mPeople = people;
        });
    }
}