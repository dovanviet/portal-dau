package com.example.daumobile.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.database.Constants;
import com.example.daumobile.databinding.ItemScheduleBinding;
import com.example.daumobile.model.Schedule;
import com.example.daumobile.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private List<Schedule> currentList;
    private final IListenerItemClicked mListener;
    private final DateUtils dateUtils;
    private final ViewBinderHelper mBinderHelper;
    private Boolean isSwipe = false;
    private String type = Constants.THOI_KHOA_BIEU;

    public ScheduleAdapter(@NonNull List<Schedule> list, IListenerItemClicked listener, Boolean isSwipe, String type) {
        currentList = list;
        mListener = listener;
        this.isSwipe = isSwipe;
        this.type = type;

        dateUtils = DateUtils.getInstance();
        mBinderHelper = new ViewBinderHelper();
        mBinderHelper.setOpenOnlyOne(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemScheduleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(getItem(position));
        if (isSwipe) {
            mBinderHelper.bind(holder.binding.swipeLayout, getItem(position).getId());
        }
    }

    /**
     * Only if you need to restore open/close state when the orientation is changed.
     * Call this method in {@link android.app.Activity#onSaveInstanceState(Bundle)}
     */
    public void saveStates(Bundle outState) {
        mBinderHelper.saveStates(outState);
    }

    /**
     * Only if you need to restore open/close state when the orientation is changed.
     * Call this method in {@link android.app.Activity#onRestoreInstanceState(Bundle)}
     */
    public void restoreStates(Bundle inState) {
        mBinderHelper.restoreStates(inState);
    }

    public Schedule getItem(int position) {
        return currentList.get(position);
    }

    public void updateList(@NonNull List<Schedule> list) {
        currentList = new ArrayList<>(list);

        notifyDataSetChanged();
    }

    public void deleteItemAt(int position) {
        if (position >= 0 && position <= currentList.size()) {
            currentList.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemScheduleBinding binding;

        public ViewHolder(@NonNull ItemScheduleBinding scheduleBinding) {
            super(scheduleBinding.getRoot());
            binding = scheduleBinding;

            binding.flPause.setOnClickListener(v -> mListener.onItemPauseClicked(getAdapterPosition()));
            binding.cardView.setOnClickListener(v -> mListener.onItemClicked(getAdapterPosition()));

            binding.swipeLayout.setLockDrag(!isSwipe);
        }

        public void bindData(Schedule schedule) {
            if (type.equals(Constants.THOI_KHOA_BIEU)) {
                String time = schedule.getThoiGianDayTrongTuan() + ", " + dateUtils.formatFullDate(schedule.getThoiGian());
                String address = "Phòng " + schedule.getPhong() +", Tiết " + schedule.getTiet();
                binding.tvThoiGian.setText(time);
                binding.tvDiaDiem.setText(address);
                binding.tvTenMonHoc.setText(schedule.getTenHP());
                binding.tvTenGiangVien.setText(schedule.getTenGiangVien());
            } else {
                String time = dateUtils.formatFullDate(schedule.getThoiGian());
                String address = schedule.getTiet();
                binding.tvThoiGian.setText(time);
                binding.tvDiaDiem.setText(address);
                binding.tvTenMonHoc.setText(schedule.getTenHP());
                binding.tvTenGiangVien.setText("Phòng " +schedule.getPhong());
            }
        }
    }
}
