package com.example.saladstar.adaptador;

public class Data {
    private int imagen;
    private String titulo;
    private float precio;

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public Data(int imagen, String titulo, float precio) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.precio = precio;
    }
}