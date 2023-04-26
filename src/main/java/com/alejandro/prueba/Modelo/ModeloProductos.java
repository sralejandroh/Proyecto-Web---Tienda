package com.alejandro.prueba.Modelo;

import java.util.*;

//MODELO DE LOS PRODUCTOS
public class ModeloProductos {
    private int id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Date fecha;

    public ModeloProductos(){

    }

    public ModeloProductos(int id, String titulo, String descripcion, String imagen, Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
