package com.example.daumobile.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.authen.Login;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.ui.base.BaseActivity;
import com.example.daumobile.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "__LoginActivity";

    private com.example.daumobile.databinding.ActivityLoginBinding binding;
    private FirebaseManager mFirebaseManager;

    private List<Login> mListLogin = new ArrayList<>();
    private Boolean isStudent = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.daumobile.databinding.ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mFirebaseManager = FirebaseManager.getInstance(this);

        setListeners();
    }

    public void setListeners(){
        binding.btnLogin.setOnClickListener(v -> {

            String id = binding.edtId.getText().toString();
            String password = binding.edtPassword.getText().toString();
            int level = Constants.SINH_VIEN;

            if (!isStudent){
                level = Constants.GIANG_VIEN;
            }

            Login loginNow = new Login(id, password, level);

            if (mListLogin.contains(loginNow)) {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

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
            mListLogin = logins;

            Log.d(TAG, "setListeners: " + logins);
        });


    }
}