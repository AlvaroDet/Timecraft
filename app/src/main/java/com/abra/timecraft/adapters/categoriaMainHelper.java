package com.abra.timecraft.adapters;

import androidx.annotation.DrawableRes;

import com.abra.timecraft.R;
import com.abra.timecraft.data.ICategoriaSource;

public class categoriaMainHelper {

    @DrawableRes
    public static int getResIdByCategory(String category) {
        switch(category) {
            case ICategoriaSource.Categories.Trabajo:
                return R.drawable.suitcase;
            default:
                return R.drawable.suitcase;
        }
    }
}
