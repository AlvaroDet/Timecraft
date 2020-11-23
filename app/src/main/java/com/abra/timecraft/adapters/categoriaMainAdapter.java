package com.abra.timecraft.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.abra.timecraft.R;
import com.abra.timecraft.helpers.ItemTapListener;
import com.abra.timecraft.models.categoriaMain;

import java.util.List;

public class categoriaMainAdapter extends RecyclerView.Adapter<categoriaMainViewHolder> {

    @NonNull
    private List<categoriaMain> mModelList;
    @Nullable
    private final ItemTapListener mTapListener;

    public categoriaMainAdapter(@NonNull List<categoriaMain> modelist, @Nullable ItemTapListener mTapListener) {
        this.mModelList = modelist;
        this.mTapListener = mTapListener;
    }

    public void updateList(List<categoriaMain> newList) {
        mModelList = newList;
     //   notifyDataSetChanged();
    }


    @NonNull
    @Override
    public categoriaMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_categoriamain, parent, false);
        categoriaMainViewHolder viewHolder = new categoriaMainViewHolder(itemView, mTapListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull categoriaMainViewHolder holder, int position) {
        categoriaMain currentModel = mModelList.get(position);
        holder.tvTitulo.setText(currentModel.getTitulo());
        holder.imgCategoriaMain.setImageResource(
                categoriaMainHelper.getResIdByCategory(currentModel.getCategory())
        );
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }
}
