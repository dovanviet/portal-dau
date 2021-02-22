package com.example.daumobile.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daumobile.model.home.HomeItem;
import com.example.daumobile.callbacks.IListenerItemClicked;
import com.example.daumobile.databinding.ItemHomeBinding;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeItem> mCurrentList;
    private IListenerItemClicked mListener;

    private HomeItem getItem(int position) {
        return mCurrentList.get(position);
    }

    public void submitList(@NonNull List<HomeItem> listItem) {
        mCurrentList.clear();
        mCurrentList.addAll(listItem);

        notifyDataSetChanged();
    }

    public HomeAdapter(@NonNull List<HomeItem> listItem, @NonNull IListenerItemClicked listener) {
        mCurrentList = listItem;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mCurrentList.size();
    }

    class ViewHolder  extends RecyclerView.ViewHolder {
        private ItemHomeBinding binding;
        public ViewHolder(@NonNull ItemHomeBinding itemHomeBinding) {
            super(itemHomeBinding.getRoot());
            binding = itemHomeBinding;

            binding.getRoot().setOnClickListener(v -> {
                mListener.onItemClicked(getItem(getAdapterPosition()));
//                Toast.makeText(binding.getRoot().getContext(), "Clicked " + getItem(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            });
        }

        public void bindData(HomeItem item){
            binding.tvInfo.setText(item.getName());

            Glide.with(binding.getRoot().getContext())
                    .load(item.getImage())
                    .into(binding.imgIcon);
        }
    }
}
