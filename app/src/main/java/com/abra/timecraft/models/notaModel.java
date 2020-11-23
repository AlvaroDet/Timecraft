package com.abra.timecraft.models;

public class notaModel {
    String tituloNota;
    String descrip;

    public notaModel(String tituloNota, String descrip) {
        this.tituloNota = tituloNota;
        this.descrip = descrip;
    }

    public String getTituloNota() {
        return tituloNota;
    }

    public void setTituloNota(String tituloNota) {
        this.tituloNota = tituloNota;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
