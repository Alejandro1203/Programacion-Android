package com.example.ejemploarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador extends ArrayAdapter<Datos> {

    private Datos[] datos;

    public Adaptador(@NonNull Context context, Datos[] datos) {
        super(context, R.layout.elemento, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        final TextView texto1 = elemento.findViewById(R.id.txt1);
        texto1.setText(datos[position].getTexto1());

        final TextView texto2 = elemento.findViewById(R.id.txt2);
        texto2.setText(datos[position].getTexto2());

        return elemento;
    }
}
