package com.example.alejandrofernandezexamenbbdd;

public class PeliculasDatos {
    private int codigo;
    private String titulo;
    private int imagen;
    private int lista;

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public int getLista() {
        return lista;
    }

    public PeliculasDatos(int codigo, String nombre, int imagen, int lista) {
        this.codigo = codigo;
        this.titulo = nombre;
        this.imagen = imagen;
        this.lista = lista;
    }
}
