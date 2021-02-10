package com.example.daumobile.ui.program;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.databinding.ItemProgramBinding;
import com.example.daumobile.model.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {
    private List<Program> currentList;

    public ProgramAdapter(@NonNull List<Program> list) {
        currentList = list;
    }

    private Program getItem(int position) {
        return currentList.get(position);
    }

    public void updateList(@NonNull List<Program> list) {
        currentList = new ArrayList<>(list);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemProgramBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemProgramBinding binding;
        public ViewHolder(@NonNull ItemProgramBinding itemProgramBinding) {
            super(itemProgramBinding.getRoot());

            binding = itemProgramBinding;
        }

        @SuppressLint("SetTextI18n")
        public void bindData(Program program) {
            binding.tvLoaiHp.setText(program.getLoaiHP());
            binding.tvMaHp.setText(program.getMaHP());
            binding.tvTenHp.setText(program.getTenHP());
            binding.tvSoTinChi.setText(program.getStc() + " tín chỉ");
        }
    }
}
