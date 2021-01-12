package com.example.daumobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.API.APIClient;
import com.example.daumobile.API.RequestAPI;
import com.example.daumobile.Adapter.ProgramAdapter;
import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Controller.ProgramModify;
import com.example.daumobile.Model.Program;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramFragment extends Fragment {
    private RecyclerView mRecyclerviewProgram;
    private Realm mRealm;
    private RealmResults<Program> mRealmResult;
    private ProgramAdapter mProgramAdapter;
    private ProgramModify instanceProgram;
    private TextView tv_program_name_semester;
    private ImageView img_program_sub_semester;
    private ImageView img_program_plus_semester;
    private Retrofit mRetrofit;
    private RequestAPI mCallApi;

    private int currentSemester = 1;

    public ProgramFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_program, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        initialization();
//        config();
//        setClick();
    }

//    private void setClick() {
//        img_program_sub_semester.setOnClickListener(v -> {
//            if (currentSemester > 1) {
//                changeSemester(false);
//            }
//        });
//
//        img_program_plus_semester.setOnClickListener(v -> {
//            long _maxSemester = instanceProgram.queryHocKyMax();
//            if (currentSemester < _maxSemester) {
//                changeSemester(true);
//            }
//        });
//    }
//
//    private void changeSemester(boolean isPlus) {
//        if (isPlus) {
//            currentSemester++;
//        } else {
//            currentSemester--;
//        }
//
//        tv_program_name_semester.setText("Học kỳ " + currentSemester);
//        mRealmResult = (instanceProgram.queryAllData(currentSemester));
//
//        // refresh
//        mProgramAdapter = new ProgramAdapter(getContext(), mRealmResult, true);
//        mRecyclerviewProgram.setAdapter(mProgramAdapter);
//    }
//
//    private void config() {
//        configRetrofit();
//        configRealm();
//        configRecyclerview();
//    }
//
//    private void configRetrofit() {
//        mRetrofit = APIClient.getClient();
//        mCallApi = mRetrofit.create(RequestAPI.class);
//    }
//
//    private void configRecyclerview() {
//        mProgramAdapter = new ProgramAdapter(getContext(), mRealmResult, true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
//
//        mRecyclerviewProgram.setAdapter(mProgramAdapter);
//        mRecyclerviewProgram.setLayoutManager(linearLayoutManager);
//        mRecyclerviewProgram.setHasFixedSize(true);
//        mRecyclerviewProgram.addItemDecoration(dividerItemDecoration);
//    }
//
//    private void configRealm() {
//        Realm.init(getActivity());
//        RealmConfiguration configPoint = new RealmConfiguration.Builder().name(Constants.KEY_TABLE_NAME_PROGRAM)
//                .schemaVersion(1)
//                .build();
//
//        mRealm = Realm.getInstance(configPoint);
//        instanceProgram = ProgramModify.getInstance(mRealm);
//        mRealmResult = instanceProgram.queryAllData();
//        if (mRealmResult.size() == 0) {
//            addData();
//        }
//    }
//
//    private void addData() {
//        Call<ArrayList<Program>> call = mCallApi.getProgram();
//        call.enqueue(new Callback<ArrayList<Program>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Program>> call, Response<ArrayList<Program>> response) {
//                ArrayList<Program> programs = response.body();
//                for (Program program : programs) {
//                    instanceProgram.insertProgram(program);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Program>> call, Throwable t) {
//
//            }
//        });
//        mRealmResult = instanceProgram.queryAllData(currentSemester);
//    }
//
//    private void initialization() {
//        mapp();
//    }
//
//    private void mapp() {
//        mRecyclerviewProgram = getActivity().findViewById(R.id.recyclerview_program);
//        tv_program_name_semester = getActivity().findViewById(R.id.tv_program_name_semester);
//        img_program_sub_semester = getActivity().findViewById(R.id.img_program_sub_semester);
//        img_program_plus_semester = getActivity().findViewById(R.id.img_program_plus_semester);
//    }
}
