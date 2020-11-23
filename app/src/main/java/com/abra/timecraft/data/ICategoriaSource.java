package com.abra.timecraft.data;

import com.abra.timecraft.models.categoriaMain;

import java.util.List;

public interface ICategoriaSource {
    public interface Categories {
        public static final String Trabajo  = "trabajo";
    }

    List<categoriaMain> getAll(int count);
}
