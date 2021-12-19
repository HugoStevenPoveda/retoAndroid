package com.carnescarbon.retouno.entidades;

import java.io.Serializable;

public class Servicio implements Serializable{

    //ATRIBUTOS
    private String nombre;
    private String descripcion;
    private int image;

    //CoSTRUCTOR


    public Servicio() {
    }

    public Servicio(String nombre, String descripciom, int imageId) {
        this.nombre = nombre;
        descripcion = descripciom;
        this.image = imageId;
    }

    //METODS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
