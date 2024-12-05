package com.example.ejemplobaseadapterimagenes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Datos> datos = new ArrayList<>();

        datos.add(new Datos(R.drawable.consola, "Consola"));
        datos.add(new Datos(R.drawable.ordenador_fijo, "Ordenador fijo"));
        datos.add(new Datos(R.drawable.ordenador_portatil, "Ordenador portatil"));
        datos.add(new Datos(R.drawable.reloj, "Reloj"));
        datos.add(new Datos(R.drawable.smartphone, "Smartphone"));
        datos.add(new Datos(R.drawable.tablet, "Tablet"));
        datos.add(new Datos(R.drawable.tv, "Tv"));

        // Instancio el listado del XML
        final ListView listado = findViewById(R.id.listado);

        // Incorporamos la cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listado.addHeaderView(cabecera);

        Adaptador miAdapatador = new Adaptador(datos, this);
        listado.setAdapter(miAdapatador);

        // Creo un listener para el listado
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                String texto = ((Datos) adapterView.getItemAtPosition(posicion)).getTetxo();
                int icono = ((Datos) adapterView.getItemAtPosition(posicion)).getIcono();

                Toast.makeText(MainActivity.this, "Título: " + texto, Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Subtítulo: " + icono, Toast.LENGTH_SHORT).show();

            }
        });

    }
}