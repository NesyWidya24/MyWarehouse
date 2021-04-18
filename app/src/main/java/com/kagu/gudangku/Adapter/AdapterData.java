package com.kagu.gudangku.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kagu.gudangku.Model.DataModel;
import com.kagu.gudangku.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listData;

    public AdapterData(Context ctx, List<DataModel> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public AdapterData.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(ctx).inflate(R.layout.card_item, parent,false);
        return new HolderData(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.HolderData holder, int position) {
        DataModel dm = listData.get(position);

        holder.id.setText(String.valueOf(dm.getId()));
        holder.codeWarehouse.setText(dm.getKodeGudang());
        holder.codeItem.setText(dm.getKodeBarang());
        holder.nameItem.setText(dm.getNamaBarang());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView id, codeWarehouse, codeItem, nameItem;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.tv_id);
            codeWarehouse = itemView.findViewById(R.id.tv_codeWarehouse);
            codeItem = itemView.findViewById(R.id.tv_codeItem);
            nameItem = itemView.findViewById(R.id.tv_nameItem);
        }
    }
}
