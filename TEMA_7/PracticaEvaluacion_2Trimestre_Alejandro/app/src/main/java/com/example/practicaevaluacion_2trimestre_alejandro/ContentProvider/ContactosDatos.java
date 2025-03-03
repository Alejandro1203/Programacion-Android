package com.example.practicaevaluacion_2trimestre_alejandro.ContentProvider;

public class ContactosDatos {
    private int id;
    private int avatar;
    private String nombre;
    private String telefono;

    public int getId() {
        return id;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public ContactosDatos(int id, int avatar, String nombre, String telefono) {
        this.id = id;
        this.avatar = avatar;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
