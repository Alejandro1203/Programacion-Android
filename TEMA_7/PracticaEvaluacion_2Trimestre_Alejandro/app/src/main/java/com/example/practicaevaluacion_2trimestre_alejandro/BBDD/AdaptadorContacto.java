package com.example.practicaevaluacion_2trimestre_alejandro.BBDD;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.practicaevaluacion_2trimestre_alejandro.ContentProvider.ContactosDatos;
import com.example.practicaevaluacion_2trimestre_alejandro.R;
import java.util.ArrayList;

public class AdaptadorContacto extends ArrayAdapter<ContactosDatos> {
    private ArrayList<ContactosDatos> contactos;

    public AdaptadorContacto(Context context, ArrayList<ContactosDatos> contactos) {
        super(context, R.layout.elemento_lista_contactos, contactos);
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento_lista_contactos, parent, false);

        final ImageView imagen = elemento.findViewById(R.id.icono);
        imagen.setImageResource(contactos.get(position).getAvatar());

        final TextView nombre = elemento.findViewById(R.id.txt_nombre_contacto);
        nombre.setText(contactos.get(position).getNombre());

        final TextView telefono = elemento.findViewById(R.id.txt_telefono_contacto);
        telefono.setText(contactos.get(position).getTelefono());

        return elemento;
    }
}