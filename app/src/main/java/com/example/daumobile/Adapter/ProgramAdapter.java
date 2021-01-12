package com.example.daumobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Model.Program;
import com.example.daumobile.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class ProgramAdapter extends RealmRecyclerViewAdapter<Program, ProgramAdapter.ProgramViewHolder> {

    public ProgramAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Program> data, boolean autoUpdate) {
        super(context, data, autoUpdate);
    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_program, parent, false);
        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {
        Program program = getItem(position);

        holder.tv_it_program_codeHp.setText(program.getMaHp());
        holder.tv_it_program_nameHp.setText(program.getTenHp());
        holder.tv_it_program_so_tin_chi.setText(program.getStc() + " tín chỉ");

        boolean loai_hoc_phan = program.isLoaiHp();
        if (loai_hoc_phan == true) {
            holder.tv_it_program_typeHp.setText(Constants.PROGRAM_TY_BATBUOC);
        } else {
            holder.tv_it_program_typeHp.setText(Constants.PROGRAM_TY_TUCHON);
        }
    }

    static class ProgramViewHolder extends RecyclerView.ViewHolder {
        TextView tv_it_program_nameHp;
        TextView tv_it_program_typeHp;
        TextView tv_it_program_so_tin_chi;
        TextView tv_it_program_codeHp;

        public ProgramViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_it_program_codeHp = itemView.findViewById(R.id.tv_it_program_codeHp);
            tv_it_program_typeHp = itemView.findViewById(R.id.tv_it_program_typeHp);
            tv_it_program_so_tin_chi = itemView.findViewById(R.id.tv_it_program_so_tin_chi);
            tv_it_program_nameHp = itemView.findViewById(R.id.tv_it_program_nameHp);
        }
    }
}
