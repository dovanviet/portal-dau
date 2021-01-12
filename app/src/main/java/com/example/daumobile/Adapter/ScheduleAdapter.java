package com.example.daumobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.Model.Schedule;
import com.example.daumobile.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class ScheduleAdapter extends RealmRecyclerViewAdapter<Schedule, ScheduleAdapter.ScheduleViewHolder> {

    public ScheduleAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Schedule> data, boolean autoUpdate) {
        super(context, data, autoUpdate);
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        Schedule schedule = getItem(position);

        holder.tv_it_program_name_teacher.setText(schedule.getGiangVien());
        holder.tv_it_schedule_time.setText(schedule.getThoiGian());
        holder.tv_it_program_room.setText(String.valueOf(schedule.getPhong() + ", tiết " + schedule.getTiet()));
        holder.tv_it_schedule_name.setText(schedule.getTenHp());
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        TextView tv_it_schedule_time;
        TextView tv_it_schedule_name;
        TextView tv_it_program_room;
        TextView tv_it_program_name_teacher;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_it_program_name_teacher = itemView.findViewById(R.id.tv_it_program_so_tin_chi);
            tv_it_schedule_name = itemView.findViewById(R.id.tv_it_schedule_name);
            tv_it_program_room = itemView.findViewById(R.id.tv_it_program_room);
            tv_it_schedule_time = itemView.findViewById(R.id.tv_it_schedule_time);
        }
    }

}
