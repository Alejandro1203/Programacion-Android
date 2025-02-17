package com.example.alejandrofernandezexamenbbdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPeliculas extends ArrayAdapter<PeliculasDatos> {
    private ArrayList<PeliculasDatos> peliculas;

    public AdaptadorPeliculas(Context context, ArrayList<PeliculasDatos> peliculas) {
        super(context, R.layout.elemento, peliculas);
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        final ImageView imagen = elemento.findViewById(R.id.imagen);
        imagen.setImageResource(peliculas.get(position).getImagen());

        final TextView titulo = elemento.findViewById(R.id.txt_titulo);
        titulo.setText(peliculas.get(position).getTitulo());

        return elemento;
    }
}