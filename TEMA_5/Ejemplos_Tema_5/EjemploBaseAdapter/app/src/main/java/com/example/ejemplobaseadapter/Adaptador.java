package com.example.ejemplobaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Datos> datos;
    private Context context;

    public Adaptador(ArrayList<Datos> datos, Context context) {
        super();
        this.datos = datos;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(context);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        final TextView texto1 = elemento.findViewById(R.id.txt1);
        texto1.setText(datos.get(position).getTexto1());

        final TextView texto2 = elemento.findViewById(R.id.txt2);
        texto2.setText(datos.get(position).getTexto2());

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
