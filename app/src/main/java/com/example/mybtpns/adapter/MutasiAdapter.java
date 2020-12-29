package com.example.mybtpns.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybtpns.R;
import com.example.mybtpns.model.Mutasi;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class MutasiAdapter extends RecyclerView.Adapter<MutasiAdapter.MutasiViewHolder> {

    Context context;
    ArrayList<Mutasi> mutasis;

    public MutasiAdapter(Context context, ArrayList<Mutasi> mutasis) {
        this.context = context;
        this.mutasis = mutasis;
    }

    @NonNull
    @Override
    public MutasiAdapter.MutasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mutasi, parent, false);
        return new  MutasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MutasiAdapter.MutasiViewHolder holder, int position) {
        holder.tanggal.setText(mutasis.get(position).getWaktuMutasi().toString());
        holder.deskripsi.setText(mutasis.get(position).getDescription());
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        holder.nominal.setText(kursIndonesia.format(mutasis.get(position).getJumlahMutasi()));
    }

    @Override
    public int getItemCount() {
        return mutasis.size();
    }

    public class MutasiViewHolder extends RecyclerView.ViewHolder{

        TextView tanggal;
        TextView deskripsi;
        TextView nominal;

        public MutasiViewHolder(@NonNull View itemView) {
            super(itemView);

            tanggal = itemView.findViewById(R.id.tanggal);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            nominal = itemView.findViewById(R.id.nominal);

        }
    }
}
