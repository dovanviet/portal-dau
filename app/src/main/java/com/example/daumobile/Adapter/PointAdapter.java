package com.example.daumobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.Model.Point;
import com.example.daumobile.R;
import com.example.daumobile.Utils.Utility;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class PointAdapter extends RealmRecyclerViewAdapter<Point, PointAdapter.PointViewHolder> {
    private Utility instanceUtility;

    public PointAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Point> data, boolean autoUpdate) {
        super(context, data, autoUpdate);
        instanceUtility = Utility.getInstance(context);
    }

    @NonNull
    @Override
    public PointViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_point, parent, false);
        return new PointViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PointViewHolder holder, int position) {
        Point point = getItem(position);

        holder.tv_it_point_stc.setText(point.getStc() + " tín chỉ");
        holder.tv_it_point_name.setText(point.getTenHp());

        int id = instanceUtility.getIdImagePoint(point.getDiemLan1(), point.getDiemLan2());
        holder.img_it_point.setImageResource(id);
    }

    static class PointViewHolder extends RecyclerView.ViewHolder {
        TextView tv_it_point_name;
        TextView tv_it_point_stc;
        ImageView img_it_point;

        public PointViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_it_point_name = itemView.findViewById(R.id.tv_it_point_name);
            tv_it_point_stc = itemView.findViewById(R.id.tv_it_point_stc);
            img_it_point = itemView.findViewById(R.id.img_it_point);
        }
    }

}
