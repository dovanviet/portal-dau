package com.example.daumobile.ui.point;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.databinding.ItemPointBinding;
import com.example.daumobile.model.Point;
import com.example.daumobile.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {
    private final Utility mUtility;
    private List<Point> currentList;
    private final IListenerItemClicked mListener;
    public PointAdapter(@NonNull Context context, @NonNull List<Point> list, IListenerItemClicked listener) {
        currentList= list;
        mListener = listener;

        mUtility = Utility.getInstance();
    }

    private Point getItem(int position) {
        return currentList.get(position);
    }
    public void updateList(@NonNull List<Point> list) {
        currentList = new ArrayList<>(list);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemPointBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
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
        private final ItemPointBinding binding;

        public ViewHolder(@NonNull ItemPointBinding pointBinding) {
            super(pointBinding.getRoot());

            binding = pointBinding;
            itemView.setOnClickListener(v -> mListener.onItemClicked(getAdapterPosition()));
        }

        @SuppressLint("SetTextI18n")
        public void bindData(Point point) {
            binding.tvSoTinChi.setText(point.getTinChi() + " tín chỉ");
            binding.tvTenMonHoc.setText(point.getTenHp());

            binding.imgDiem.setImageResource(mUtility.getIdImagePoint(point.getDiemLan1(), point.getDiemLan2()));

        }
    }
}
