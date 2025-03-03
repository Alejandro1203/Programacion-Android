package com.example.practicaevaluacion_2trimestre_alejandro.ContentProvider;

public class AvatarDatos {
    private int id;
    private int icono;
    private String nombre;
    private String telefono;

    public int getId() {
        return id;
    }

    public int getIcono() {
        return icono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public AvatarDatos(int id, int icono, String nombre, String telefono) {
        this.id = id;
        this.icono = icono;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
