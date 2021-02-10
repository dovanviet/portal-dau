package com.example.daumobile.ui.schedule;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.databinding.ItemScheduleBinding;
import com.example.daumobile.model.Schedule;
import com.example.daumobile.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private List<Schedule> currentList;
    private final IListenerItemClicked mListener;
    private final DateUtils dateUtils;

    public ScheduleAdapter(@NonNull List<Schedule> list, IListenerItemClicked listener) {
        currentList = list;
        mListener = listener;

        dateUtils = DateUtils.getInstance();
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
    }

    public Schedule getItem(int position) {
        return currentList.get(position);
    }

    public void updateList(@NonNull List<Schedule> list) {
        currentList = new ArrayList<>(list);

        notifyDataSetChanged();
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

            itemView.setOnClickListener(v -> mListener.onItemClicked(getAdapterPosition()));
        }

        public void bindData(Schedule schedule) {
            String time = schedule.getThoiGianDayTrongTuan() + ", " + dateUtils.formatFullDate(schedule.getThoiGian());
            String address = "Phòng " + schedule.getPhong() +"Tiết " + schedule.getTiet();
            binding.tvThoiGian.setText(time);
            binding.tvDiaDiem.setText(address);
            binding.tvTenMonHoc.setText(schedule.getTenHP());
            binding.tvTenGiangVien.setText(schedule.getTenGiangVien());
        }
    }
}
