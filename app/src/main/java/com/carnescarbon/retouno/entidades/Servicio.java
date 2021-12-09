package com.carnescarbon.retouno.entidades;

import java.io.Serializable;

public class Servicio implements Serializable{

    //ATRIBUTOS
    private String nombre;
    private String Descripciom;
    private int imageId;

    //CoSTRUCTOR


    public Servicio() {
    }

    public Servicio(String nombre, String descripciom, int imageId) {
        this.nombre = nombre;
        Descripciom = descripciom;
        this.imageId = imageId;
    }

    //METODS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripciom() {
        return Descripciom;
    }

    public void setDescripciom(String descripciom) {
        Descripciom = descripciom;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
