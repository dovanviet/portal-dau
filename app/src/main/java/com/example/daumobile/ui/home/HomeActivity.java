package com.example.daumobile.ui.home;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.daumobile.database.Constants;
import com.example.daumobile.databinding.ActivityHomeBinding;
import com.example.daumobile.model.authen.PEOPLE_TYPE;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.model.home.HomeItem;
import com.example.daumobile.R;
import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.ui.base.BaseActivity;
import com.example.daumobile.ui.home.adapter.HomeAdapter;
import com.example.daumobile.ui.login.LoginActivity;
import com.example.daumobile.ui.point.PointActivity;
import com.example.daumobile.ui.program.ProgramActivity;
import com.example.daumobile.ui.schedule.ScheduleActivity;
import com.example.daumobile.ui.user.UserActivity;
import com.example.daumobile.utils.SharePrefUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> implements IListenerItemClicked {

    private static final String CHANNEL_DEFAULT_IMPORTANCE = "NOTIFY";
    private com.example.daumobile.databinding.ActivityHomeBinding binding;

    private HomeAdapter mHomeAdapter;
    private List<HomeItem> mHomeItems;
    private People currentPeople;

    @Override
    protected ActivityHomeBinding getBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.daumobile.databinding.ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        receiveData();
        generateData();
        setViews();
        setListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharePrefUtils.getInstance(this).setIsDestroy(true);
    }

    private void receiveData() {
        Intent intent = getIntent();

        Serializable people = intent.getSerializableExtra(Constants.IT_PEOPLE);
        if (people != null) {
            currentPeople = (People) people;
        }
    }

    private void generateData() {
        mHomeItems = new ArrayList<>();
        HomeItem item1 = new HomeItem();
        HomeItem item2 = new HomeItem();
        HomeItem item3 = new HomeItem();

        HomeItem item4 = new HomeItem();
        HomeItem item5 = new HomeItem();
        HomeItem item6 = new HomeItem();
        if (currentPeople.getType() == PEOPLE_TYPE.STUDENT.getValue()) {
            item1.setName(Constants.MENU_XEMDIEM);
            item2.setName(Constants.MENU_THOIKHOABIEU);
            item3.setName(Constants.MENU_LICHTHI);
            item4.setName(Constants.MENU_CHUONGTRINHDAOTAO);
            item5.setName(Constants.MENU_THONGTINCANHAN);
            item6.setName(Constants.MENU_DANGXUAT);

            item1.setImage(R.drawable.ic_xemdiem);
            item2.setImage(R.drawable.ic_calendar);
            item3.setImage(R.drawable.ic_lichthi);
            item4.setImage(R.drawable.ic_chuongtrinhdaotao);
            item5.setImage(R.drawable.ic_thongtincanhan);
            item6.setImage(R.drawable.ic_logout);

            mHomeItems.add(item1);
            mHomeItems.add(item2);
            mHomeItems.add(item3);
            mHomeItems.add(item4);
            mHomeItems.add(item5);
            mHomeItems.add(item6);
        } else {
            item1.setName(Constants.MENU_LICHDAY);
            item2.setName(Constants.MENU_THONGTINCANHAN);
            item3.setName(Constants.MENU_DANGXUAT);
            item1.setImage(R.drawable.ic_giangvien_lichday);
            item2.setImage(R.drawable.ic_giangvien_thongtincanhan);
            item3.setImage(R.drawable.ic_logout);

            mHomeItems.add(item1);
            mHomeItems.add(item2);
            mHomeItems.add(item3);
        }

    }

    private void setViews(){
        mHomeAdapter = new HomeAdapter(mHomeItems, this);

        binding.recyclerHome.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerHome.setAdapter(mHomeAdapter);
        binding.recyclerHome.setHasFixedSize(true);
    }

    private void setListeners() { }

    @Override
    public void onItemClicked(HomeItem item) {
        Intent intent;
        switch (item.getName()) {
            case Constants.MENU_DANGXUAT:
                intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                break;
            case Constants.MENU_CHUONGTRINHDAOTAO:
                intent = new Intent(this, ProgramActivity.class);
                intent.putExtra(Constants.IT_PEOPLE, currentPeople);
                startActivity(intent);
                break;
            case Constants.MENU_LICHDAY:
                intent = new Intent(this, ScheduleActivity.class);
                intent.putExtra(Constants.IT_PEOPLE, currentPeople);
                intent.putExtra(Constants.IT_SCHEDULE, Constants.LICH_DAY);
                startActivity(intent);
                break;
            case Constants.MENU_LICHTHI:
                intent = new Intent(this, ScheduleActivity.class);
                intent.putExtra(Constants.IT_PEOPLE, currentPeople);
                intent.putExtra(Constants.IT_SCHEDULE, Constants.LICH_THI);
                startActivity(intent);
                break;
            case Constants.MENU_THOIKHOABIEU:
                intent = new Intent(this, ScheduleActivity.class);
                intent.putExtra(Constants.IT_PEOPLE, currentPeople);
                intent.putExtra(Constants.IT_SCHEDULE, Constants.THOI_KHOA_BIEU);
                startActivity(intent);
                break;
            case Constants.MENU_THONGTINCANHAN:
                intent = new Intent(this, UserActivity.class);
                intent.putExtra(Constants.IT_PEOPLE, currentPeople);
                startActivity(intent);
                break;
            case Constants.MENU_XEMDIEM:
                intent = new Intent(this, PointActivity.class);
                intent.putExtra(Constants.IT_PEOPLE, currentPeople);
                startActivity(intent);
            default:
                break;

        }
    }
}