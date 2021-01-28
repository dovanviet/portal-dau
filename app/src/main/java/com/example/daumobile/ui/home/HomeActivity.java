package com.example.daumobile.ui.home;

import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.daumobile.database.Constants;
import com.example.daumobile.model.authen.PEOPLE_TYPE;
import com.example.daumobile.model.authen.People;
import com.example.daumobile.model.home.HomeItem;
import com.example.daumobile.R;
import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.ui.base.BaseActivity;
import com.example.daumobile.ui.home.adapter.HomeAdapter;
import com.example.daumobile.ui.login.LoginActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements IListenerItemClicked {

    private com.example.daumobile.databinding.ActivityHomeBinding binding;

    private HomeAdapter mHomeAdapter;
    private List<HomeItem> mHomeItems;
    private People currentPeople;

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

    private void receiveData() {
        Intent intent = getIntent();

        Serializable people = intent.getSerializableExtra(Constants.IT_PEOPLE);
        if (people != null) {
            currentPeople = (People) people;
        }
    }

    private void generateData() {
        mHomeItems = new ArrayList<>();
        if (currentPeople.getType() == PEOPLE_TYPE.STUDENT.getValue()) {
            HomeItem item1 = new HomeItem();
            HomeItem item2 = new HomeItem();
            HomeItem item3 = new HomeItem();
            HomeItem item4 = new HomeItem();
            HomeItem item5 = new HomeItem();
            HomeItem item6 = new HomeItem();

            item1.setName("Xem điểm");
            item2.setName("Thời khóa biểu");
            item3.setName("Lịch thi");
            item4.setName("Chương trình đào tạo");
            item5.setName("Thông tin cá nhân");
            item6.setName("Đăng xuất");

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
            HomeItem item1 = new HomeItem();
            HomeItem item2 = new HomeItem();
            HomeItem item3 = new HomeItem();

            item1.setName("Lịch dạy");
            item2.setName("Thông tin cá nhân");
            item3.setName("Đăng xuất");
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

    private void setListeners() {

    }

    @Override
    public void onItemClicked(HomeItem item) {
        if (item.getName().toLowerCase().equals("đăng xuất")) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        }
    }
}