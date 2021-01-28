package com.example.daumobile.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.daumobile.model.Schedule;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.model.authen.Student;
import com.example.daumobile.model.authen.Teacher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseManager {
    private static final String TAG = "__FirebaseManager";
    private static FirebaseManager mInstance = null;
    private Context mContext;
    private FirebaseDatabase mDatabase;

    private DatabaseReference mUserFref;
    private DatabaseReference mScheduleFref;

    private MutableLiveData<List<People>> mUserData;

    public MutableLiveData<List<People>> getUserData() {
        return mUserData;
    }

    private FirebaseManager(Context context) {
        mContext = context;
        mUserData = new MutableLiveData<>();

        mDatabase = FirebaseDatabase.getInstance();
        mUserFref = mDatabase.getReference("users");
        mScheduleFref = mDatabase.getReference("schedule");

        onListenUserValue();
    }

    public static FirebaseManager getInstance(Context context) {
        if (mInstance == null){
            mInstance = new FirebaseManager(context);
        }
        return mInstance;
    }

    public void initData() {
        People admin = new People("admin", "admin");
        People student1 = new Student("123", "123", "do van viet", "quang nam", "0945112445","16CT");
        People student2 = new Student("345", "123", "bui vinh khai", "da nang", "0933527563","16CT");
        People student3 = new Student("456", "123", "nguyen thanh long", "quang tri", "09334347563","16CT");

        People teacher1 = new Teacher("111", "111", "Giao vien 1", "quang nam", "0945112445","Nhap Mon Lap Trinh");
        People teacher2 = new Teacher("112", "111", "Giao vien 2", "ha noi", "0935369253","Lap trinh web");
        People teacher3 = new Teacher("113", "111", "Giao vien 3", "ha noi", "0935449253","Lap trinh java");

        mUserFref.child(admin.getId()).setValue(admin);
        mUserFref.child(student1.getId()).setValue(student1);
        mUserFref.child(student2.getId()).setValue(student2);
        mUserFref.child(student3.getId()).setValue(student3);
        mUserFref.child(teacher1.getId()).setValue(teacher1);
        mUserFref.child(teacher2.getId()).setValue(teacher2);
        mUserFref.child(teacher3.getId()).setValue(teacher3);
    }

    public void createSchedule(Schedule schedule) {
        mScheduleFref.child(schedule.getMaHP()).setValue(schedule);
    }

    private void onListenUserValue() {
        mUserFref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<People> results = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    results.add(postSnapshot.getValue(People.class));
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
