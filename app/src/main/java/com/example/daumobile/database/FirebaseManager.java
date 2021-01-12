package com.example.daumobile.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.User;
import com.example.daumobile.Model.authen.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseManager {
    private static final String TAG = "__FirebaseManager";
    private static FirebaseManager mInstance = null;
    private Context mContext;
    private FirebaseDatabase mDatabase;

    private DatabaseReference mUserFref;

    private MutableLiveData<List<Login>> mUserData;

    public MutableLiveData<List<Login>> getUserData() {
        return mUserData;
    }

    private FirebaseManager(Context context) {
        mContext = context;
        mUserData = new MutableLiveData<>();

        mDatabase = FirebaseDatabase.getInstance();
        mUserFref = mDatabase.getReference("users");

        onListenUserValue();
    }

    public static FirebaseManager getInstance(Context context) {
        if (mInstance == null){
            mInstance = new FirebaseManager(context);
        }
        return mInstance;
    }

    private void onListenUserValue() {
        mUserFref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Login> results = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    results.add(postSnapshot.getValue(Login.class));
                }
                mUserData.postValue(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        });
    }


}
