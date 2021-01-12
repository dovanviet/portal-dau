package com.example.daumobile.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.authen.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseManager {
    private static FirebaseManager mInstance = null;
    private Context mContext;
    private FirebaseDatabase mDatabase;

    private DatabaseReference mUserFref;

    private static final String TAG = "__FirebaseManager";

    private FirebaseManager(Context context) {
        Log.d(TAG, "FirebaseManager: ");
        mContext = context;

        mDatabase = FirebaseDatabase.getInstance();
        mUserFref = mDatabase.getReference("users");

        mUserFref.setValue("Hello all");

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("hello world");
//        initData();
    }

    public static FirebaseManager getInstance(Context context) {
        Log.d(TAG, "getInstance: ");
        if (mInstance == null){
            mInstance = new FirebaseManager(context);
        }
        return mInstance;
    }

    public void initData() {
        Log.d(TAG, "initData: ");
        Login loginSinhVien = new Login("1651220023","dovanviet", Constants.SINH_VIEN);
        Login loginGiangVien = new Login("admin","admin", Constants.GIANG_VIEN);

        mUserFref.child(loginSinhVien.getId()).push().setValue(loginSinhVien);
//        .addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Log.d(TAG, "onSuccess: add student success");
//            }
//        })
//        .addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d(TAG, "onSuccess: add student fail with error = " + e.getLocalizedMessage());
//            }
//        });
        mUserFref.push().child(loginGiangVien.getId()).push().setValue(loginGiangVien);
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Log.d(TAG, "onSuccess: add giang vien success");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, "onSuccess: add giang vien fail with error = " + e.getLocalizedMessage());
//                    }
//                });
    }

}
