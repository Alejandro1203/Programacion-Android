package com.example.ejemploarrayadapter;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creo los datos que voy a mostrar en pantalla
        Datos[] datos = new Datos[] {
                new Datos("Línea Superior 1", "Línea Inferior 1"),
                new Datos("Línea Superior 2", "Línea Inferior 2"),
                new Datos("Línea Superior 3", "Línea Inferior 3"),
                new Datos("Línea Superior 4", "Línea Inferior 4"),
                new Datos("Línea Superior 5", "Línea Inferior 5"),
        };

        // Instancio el listado del XML
        final ListView listado = findViewById(R.id.listado);

        // Incorporamos la cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listado.addHeaderView(cabecera);

        // Creo mi adaptador personalizado
        Adaptador miAdapatador = new Adaptador(this, datos);
        listado.setAdapter(miAdapatador);

        // Creo un listener para el listado
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                String seleccionado = ((Datos) adapterView.getItemAtPosition(posicion)).getTexto1();
                Toast.makeText(MainActivity.this, "Título: " + seleccionado, Toast.LENGTH_SHORT).show();

                seleccionado = ((Datos) adapterView.getItemAtPosition(posicion)).getTexto2();
                Toast.makeText(MainActivity.this, "Subtítulo: " + seleccionado, Toast.LENGTH_SHORT).show();

            }
        });
    }
}