package com.example.magbas00044.crudmahasiswabaru;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.magbas00044.crudmahasiswabaru.response.DatanyaItem;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder> {
    List<DatanyaItem> data;

    public MahasiswaAdapter(List<DatanyaItem> dataMhs) {
        data = dataMhs;
    }

    @NonNull
    @Override
    public MahasiswaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mahasiswa, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MahasiswaAdapter.MyViewHolder holder, final int position) {
        holder.txtnim.setText(data.get(position).getMahasiswaNim());
        holder.txtnama.setText(data.get(position).getMahasiswaNama());
        holder.txtjurusan.setText(data.get(position).getMahasiswaJurusan());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirimdata = new Intent(holder.itemView.getContext(), UpdateHapusActivity.class);
                kirimdata.putExtra("id", data.get(position).getMahasiswaId());
                kirimdata.putExtra("nim", data.get(position).getMahasiswaNim());
                kirimdata.putExtra("nama", data.get(position).getMahasiswaNama());
                kirimdata.putExtra("jurusan", data.get(position).getMahasiswaJurusan());
                holder.itemView.getContext().startActivity(kirimdata);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtnim, txtnama, txtjurusan;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtnim = itemView.findViewById(R.id.txtnim);
            txtnama = itemView.findViewById(R.id.txtnama);
            txtjurusan = itemView.findViewById(R.id.txtjurusan);
        }
    }
}
