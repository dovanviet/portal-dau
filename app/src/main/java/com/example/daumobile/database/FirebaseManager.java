package com.example.daumobile.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.daumobile.model.Point;
import com.example.daumobile.model.Program;
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
import java.util.Objects;

public class FirebaseManager {
    private static final String TAG = "__FirebaseManager";
    private static FirebaseManager mInstance = null;

    private final DatabaseReference mUserFref;
    private final DatabaseReference mScheduleFref;
    private final DatabaseReference mProgramFref;
    private final DatabaseReference mPointFref;

    private final MutableLiveData<List<People>> mUserData = new MutableLiveData<>();
    private final MutableLiveData<List<Schedule>> mScheduleData = new MutableLiveData<>();
    private final MutableLiveData<List<Program>> mProgramData = new MutableLiveData<>();
    private final MutableLiveData<List<Point>> mPointData = new MutableLiveData<>();

    public MutableLiveData<List<People>> getUserData() {
        return mUserData;
    }

    public MutableLiveData<List<Schedule>> getScheduleData() {
        return mScheduleData;
    }

    public MutableLiveData<List<Program>> getProgramData() {
        return mProgramData;
    }

    public MutableLiveData<List<Point>> getPointData() {
        return mPointData;
    }

    private FirebaseManager() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mUserFref       = database.getReference("users");
        mScheduleFref   = database.getReference("schedule");
        mPointFref      = database.getReference("point");
        mProgramFref    = database.getReference("program");

//        initData();
        onListenUserValue();
    }

    public static FirebaseManager getInstance() {
        if (mInstance == null){
            mInstance = new FirebaseManager();
        }
        return mInstance;
    }

    public void initData() {
        Student student1 = new Student("1651120028", "123", "do van viet", "quang nam", "0945112445","16CT");
        Student student2 = new Student("345", "123", "bui vinh khai", "da nang", "0933527563","16CT");
        Student student3 = new Student("456", "123", "nguyen thanh long", "quang tri", "09334347563","16CT");

        Teacher teacher1 = new Teacher("111", "111", "Giao vien 1", "quang nam", "0945112445","Nhap Mon Lap Trinh");
        Teacher teacher2 = new Teacher("112", "111", "Giao vien 2", "ha noi", "0935369253","Lap trinh web");
        Teacher teacher3 = new Teacher("113", "111", "Giao vien 3", "ha noi", "0935449253","Lap trinh java");

        addUser(student1);
        addUser(student2);
        addUser(student3);
        addUser(teacher1);
        addUser(teacher2);
        addUser(teacher3);
    }

    public void addUser(People people) {
        mUserFref.child(people.getId()).setValue(people);
    }

    public void addSchedule(Schedule schedule) {
        mScheduleFref.child(schedule.getId()).setValue(schedule);
    }

    public void addProgram(Program program) {
        mProgramFref.child(program.getId()).setValue(program);
    }

    public void addPoint(Point point){
        mPointFref.child(point.getId()).setValue(point);
    }

    private void onListenUserValue() {
        mUserFref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<People> results = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    boolean isStudent = false;
                    for (DataSnapshot key : postSnapshot.getChildren()) {
                        if (key.getKey() != null && Objects.requireNonNull(key.getKey()).toLowerCase().equals("lophoc")) {
                            isStudent = true;
                        }
                    }

                    if (isStudent) {
                        results.add(postSnapshot.getValue(Student.class));
                    } else {
                        results.add(postSnapshot.getValue(Teacher.class));
                    }
                }
                mUserData.postValue(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "loadPost:onCancelled", error.toException());
            }
        });

        mPointFref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Point> results = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    results.add(postSnapshot.getValue(Point.class));

                }
                mPointData.postValue(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "loadPost:onCancelled", error.toException());
            }
        });

        mProgramFref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Program> results = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    results.add(postSnapshot.getValue(Program.class));

                }
                mProgramData.postValue(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "loadPost:onCancelled", error.toException());
            }
        });

        mScheduleFref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Schedule> results = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    results.add(postSnapshot.getValue(Schedule.class));

                }
                mScheduleData.postValue(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "loadPost:onCancelled", error.toException());
            }
        });


    }


}
