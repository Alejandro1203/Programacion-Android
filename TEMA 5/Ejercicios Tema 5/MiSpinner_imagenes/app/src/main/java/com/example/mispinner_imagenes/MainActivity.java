package com.example.mispinner_imagenes;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner miSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = findViewById(R.id.spinner);

        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos(R.drawable.eevee));
        datos.add(new Datos(R.drawable.jygli));
        datos.add(new Datos(R.drawable.pikachu));
        datos.add(new Datos(R.drawable.squir));

        Adaptador adaptador = new Adaptador(this, datos);
        miSpinner.setAdapter(adaptador);
    }
}