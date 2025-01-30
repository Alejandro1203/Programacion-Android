package com.example.ejemplospinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
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

        // Instancio el Spinner del xml
        Spinner spinner = findViewById(R.id.miSpinner);

        // Declaro la fuente de datos (array, ArrayList...)
        final String datos[] = {"Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};

        // Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, datos);

        // Asignar el adaptador
        spinner.setAdapter(adaptador);

        // Creo el listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
                // Opción 1
                //Toast.makeText(MainActivity.this, "Has hecho click en: " + adapterView.getItemAtPosition(posicion), Toast.LENGTH_SHORT).show();

                // Opción 2
                Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(posicion).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}