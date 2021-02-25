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
import com.example.daumobile.utils.NotifyUtils;
import com.example.daumobile.utils.SharePrefUtils;
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

    private NotifyUtils mNotifyInstance;
    private SharePrefUtils mSharePrefInstance;

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

    private FirebaseManager(@NonNull Context context) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mUserFref       = database.getReference("users");
        mScheduleFref   = database.getReference("schedule");
        mPointFref      = database.getReference("point");
        mProgramFref    = database.getReference("program");

        mNotifyInstance = NotifyUtils.getInstance(context);
        mSharePrefInstance = SharePrefUtils.getInstance(context);
//        initData();
        onListenUserValue();
    }

    public static FirebaseManager getInstance(@NonNull Context context) {
        if (mInstance == null){
            mInstance = new FirebaseManager(context);
        }
        return mInstance;
    }

    public void initData() {
        Student student1 = new Student("1651120023", "123", "Đỗ Văn Việt", "quang nam", "0945112445","16CT");
        Student student2 = new Student("1651120024", "123", "Đoàn Xuân Lộc", "da nang", "0933527563","16CT");
        Student student3 = new Student("1651120028", "123", "Nguyễn Thanh Long", "quang tri", "09334347563","16CT");
        Student student4 = new Student("1651120030", "123", "Trần Phước Lý", "quang tri", "09334347563","16CT");
        Teacher teacher1 = new Teacher("111", "111", "Huỳnh Hữu Hưng", "quang nam", "0945112445","Lập trình hệ thống");
        Teacher teacher2 = new Teacher("112", "111", "Hoàng Thị Mỹ Lệ", "ha noi", "0935369253","Công nghệ phần mềm ");
        Teacher teacher3 = new Teacher("113", "111", "Đặng Hùng Vĩ", "ha noi", "0935449253","Mạng máy tính");
        Teacher teacher4 = new Teacher("114", "111", "Trương Ngọc Châu", "ha noi", "0935449253","Chương trình dịch");

        addUser(student1);
        addUser(student2);
        addUser(student3);
        addUser(student4);
        addUser(teacher1);
        addUser(teacher2);
        addUser(teacher3);
        addUser(teacher4);
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
        Log.d(TAG, "onListenUserValue: ???");
        mUserFref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(TAG, "onDataChange: 1");
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
                Log.d(TAG, "onDataChange: CALLED");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Schedule schedule = postSnapshot.getValue(Schedule.class);

                    if (schedule != null && schedule.isTamdung()) {
                        if (schedule.getLopHoc().equals(mSharePrefInstance.getClassStudent())) {
                            mNotifyInstance.showNotifyNow("Thông báo", "Môn học " + schedule.getTenHP() + " đã tạm dừng");
                        }

                        postSnapshot.getRef().removeValue();
                    } else {
                        results.add(schedule);
                    }
                }
                mScheduleData.postValue(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "loadPost:onCancelled", error.toException());
            }
        });
    }

    public void onPauseSchedule(Schedule scheduleDelete) {
        scheduleDelete.setTamdung(true);
        mScheduleFref.child(scheduleDelete.getId()).setValue(scheduleDelete);
    }

}
