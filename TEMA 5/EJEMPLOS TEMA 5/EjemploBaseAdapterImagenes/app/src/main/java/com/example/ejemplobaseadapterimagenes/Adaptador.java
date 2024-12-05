package com.example.ejemplobaseadapterimagenes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.ContentHandler;
import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Datos> datos;
    private Context contexto;

    public Adaptador(ArrayList<Datos> datos, Context contexto) {
        this.datos = datos;
        this.contexto = contexto;
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        final TextView texto = elemento.findViewById(R.id.texto);
        texto.setText(datos.get(position).getTetxo());

        final ImageView image = elemento.findViewById(R.id.icono);
        image.setImageResource(datos.get(position).getIcono());

        return elemento;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
