package com.abra.timecraft.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.abra.timecraft.R;
import com.abra.timecraft.helpers.ItemTapListener;

public class categoriaMainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvTitulo;
    public ImageView imgCategoriaMain;
    @Nullable
    private final ItemTapListener mTapListener;

    public categoriaMainViewHolder(@NonNull View itemView, @Nullable ItemTapListener tapListener) {
        super(itemView);
        mTapListener = tapListener;
        itemView.setOnClickListener(this);

        tvTitulo = itemView.findViewById(R.id.tv_categoriaMain);
        imgCategoriaMain = itemView.findViewById(R.id.img_categoriaMain);
    }

    @Override
    public void onClick(View view) {
        if (mTapListener == null) return;
        mTapListener.onItemTap(view, getAdapterPosition());
    }
}