package com.example.daumobile.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.daumobile.database.Constants;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.databinding.ActivityLoginBinding;
import com.example.daumobile.model.Point;
import com.example.daumobile.model.authen.PEOPLE_TYPE;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.ui.base.BaseActivity;
import com.example.daumobile.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    private static final String TAG = "__LoginActivity";

    @Override
    protected ActivityLoginBinding getBinding() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        mFirebaseManager = FirebaseManager.getInstance(this);

//        mssv, String tenHp, int tinChi, double diemTrungBinh, double diemLan1, double diemLan2
        mFirebaseManager.addPoint(new Point("123", "12", 3, 10.0 ,10.0, -1.0));
        setListeners();
    }

    private FirebaseManager mFirebaseManager;

    private List<People> mPeople = new ArrayList<>();
    private Boolean isStudent = true;

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

        mFirebaseManager.getUserData().observe(this, logins -> {
            mPeople = logins;

            Log.d(TAG, "setListeners: " + logins);
        });
    }
}