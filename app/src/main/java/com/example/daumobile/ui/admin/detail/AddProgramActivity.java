package com.example.daumobile.ui.admin.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daumobile.Controller.DialogHandler;
import com.example.daumobile.R;
import com.example.daumobile.databinding.ActivityAddProgramBinding;
import com.example.daumobile.ui.base.BaseActivity;

import java.util.ArrayList;

public class AddProgramActivity extends BaseActivity {

    private ActivityAddProgramBinding binding;
    private DialogHandler mDialogHandler = DialogHandler.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProgramBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
    }

    private void setListeners() {
        binding.btnAccept.setOnClickListener(v -> {
            // add data
            finish();
        });
        binding.btnCancel.setOnClickListener(v -> {
            finish();
        });

        binding.edtLoaiHP.setClickable(true);
        binding.edtLoaiHP.setFocusable(false);
        binding.edtLoaiHP.setOnClickListener(v -> {
            ArrayList<String> list = new ArrayList<>();
            list.add("Tự chọn");
            list.add("Bắt buộc");

            int defaultSelect = 0;
            if (binding.edtLoaiHP.getText().toString().equals(list.get(1))){
                defaultSelect = 1;
            }
            mDialogHandler.singleChoiceDialog(this, list, defaultSelect, "Chọn loại học phần", "", "OK", "CANCEL", new DialogHandler.OnDialogSelectorListener() {
                @Override
                public void onSelectedOption(int selectedIndex) {
                    binding.edtLoaiHP.setText(list.get(selectedIndex));
                }
            });
        });
    }
}