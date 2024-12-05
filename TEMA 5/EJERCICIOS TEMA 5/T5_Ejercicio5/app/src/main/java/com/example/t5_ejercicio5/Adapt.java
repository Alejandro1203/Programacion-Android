package com.example.t5_ejercicio5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapt extends ArrayAdapter<Data> {
    private Data[] data;

    public Adapt(@NonNull Context context, Data[] data) {
        super(context, R.layout.elementos, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View element = mostrado.inflate(R.layout.elementos, parent,false);
        final TextView text1 = element.findViewById(R.id.nombre);
        text1.setText(data[position].getNombre());
        final TextView text2 = element.findViewById(R.id.numero);
        text2.setText(data[position].getNumero());

        return element;
    }
}
