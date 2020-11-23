package com.abra.timecraft.models;

import android.os.Parcel;
import android.os.Parcelable;

public class categoriaMain implements Parcelable {
    private String id;
    private  String titulo;
    private String category;

    public categoriaMain(String id, String titulo, String category) {
        this.id = id;
        this.titulo = titulo;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    protected categoriaMain(Parcel in) {
        id = in.readString();
        titulo = in.readString();
        category = in.readString();

    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(titulo);
        dest.writeString(category);

    }

    public static final Parcelable.Creator<categoriaMain> CREATOR = new Parcelable.Creator<categoriaMain>() {
        @Override
        public categoriaMain createFromParcel(Parcel in) {
            return new categoriaMain(in);
        }

        @Override
        public categoriaMain[] newArray(int size) {
            return new categoriaMain[size];
        }
    };
}
