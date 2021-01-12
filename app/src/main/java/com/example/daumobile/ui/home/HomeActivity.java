package com.example.daumobile.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.daumobile.Model.home.HomeItem;
import com.example.daumobile.R;
import com.example.daumobile.database.FirebaseManager;
import com.example.daumobile.ui.base.BaseActivity;
import com.example.daumobile.ui.home.adapter.HomeAdapter;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private com.example.daumobile.databinding.ActivityHomeBinding binding;

    private HomeAdapter mHomeAdapter;
    private List<HomeItem> mHomeItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.daumobile.databinding.ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        generateData();
        setViews();
    }

    private void generateData() {
        mHomeItems = new ArrayList<>();

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
    }

    private void setViews(){
        mHomeAdapter = new HomeAdapter(this, mHomeItems);

        binding.recyclerHome.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerHome.setAdapter(mHomeAdapter);
        binding.recyclerHome.setHasFixedSize(true);
    }
}