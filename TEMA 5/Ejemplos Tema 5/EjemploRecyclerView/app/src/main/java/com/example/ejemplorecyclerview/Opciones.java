package com.example.ejemplorecyclerview;

public class Opciones {
    private String titulo;
    private String subtitulo;
    private int icono;

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public int getIcono() {
        return icono;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public Opciones(String titulo, String subtitulo, int icono) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.icono = icono;
    }
}
