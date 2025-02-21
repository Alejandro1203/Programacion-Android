package com.example.practicaevaluacion_2trimestre_alejandro.Spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practicaevaluacion_2trimestre_alejandro.R;

import java.util.ArrayList;

public class AdaptadorSpinner extends ArrayAdapter<DatosSpinner> {

    private ArrayList<DatosSpinner> datosSpinner;

    public AdaptadorSpinner(Context context, ArrayList<DatosSpinner> datosSpinner) {
        super(context, R.layout.elemento_spinner, datosSpinner);
        this.datosSpinner = datosSpinner;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
    }
}
