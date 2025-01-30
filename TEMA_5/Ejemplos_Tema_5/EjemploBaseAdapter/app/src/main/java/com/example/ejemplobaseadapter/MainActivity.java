package com.example.ejemplobaseadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Datos> datos = new ArrayList<>();

        datos.add(new Datos("Línea Superior 1", "Línea Inferior 1"));
        datos.add(new Datos("Línea Superior 2", "Línea Inferior 2"));
        datos.add(new Datos("Línea Superior 3", "Línea Inferior 3"));
        datos.add(new Datos("Línea Superior 4", "Línea Inferior 4"));
        datos.add(new Datos("Línea Superior 5", "Línea Inferior 5"));

        // Instancio el listado del XML
        final ListView listado = findViewById(R.id.listado);

        // Incorporamos la cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listado.addHeaderView(cabecera);

        // Creo mi adaptador personalizado
        Adaptador miAdapatador = new Adaptador(datos, this);
        listado.setAdapter(miAdapatador);

        // Creo un listener para el listado
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                String texto1 = ((Datos) adapterView.getItemAtPosition(posicion)).getTexto1();
                String texto2 = ((Datos) adapterView.getItemAtPosition(posicion)).getTexto1();

                Toast.makeText(MainActivity.this, "Título: " + texto1, Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Subtítulo: " + texto2, Toast.LENGTH_SHORT).show();

            }
        });




    }
}