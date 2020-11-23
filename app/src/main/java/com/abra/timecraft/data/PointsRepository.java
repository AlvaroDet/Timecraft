package com.abra.timecraft.data;

import android.content.Context;

import com.abra.timecraft.models.categoriaMain;

import java.util.List;

public class PointsRepository {
    private final ICategoriaSource mSource;

   /* //public PointsRepository(Context context) {
        mSource = new CategoriasAssetSource(context);
    }*/

    public PointsRepository(ICategoriaSource source) {
        mSource = source;
    }

    public List<categoriaMain> getAll() {
        return mSource.getAll(50);
    }
}
