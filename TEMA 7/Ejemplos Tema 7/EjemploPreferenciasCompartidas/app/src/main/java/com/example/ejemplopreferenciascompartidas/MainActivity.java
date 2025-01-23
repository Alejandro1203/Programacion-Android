package com.example.ejemplopreferenciascompartidas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        final Button btnGuardar = findViewById(R.id.btnGuardar);
        final Button btnCargar = findViewById(R.id.btnCargar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtengo las referencias de la colección de preferencias (archivo xml) donde tengo o voy a guardar
                //las preferencias
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                // Guardar los valores
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nombre", "iesbelen");
                editor.putString("email", "iesbelen@gmail.com");

                // Guardo los cambios
                editor.commit();
            }
        });

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                String nombre = prefs.getString("nombre", "");
                String correo = prefs.getString("email", "");

                Log.i("Preferencias", "Nombre: " + nombre);
                Log.i("Preferencias", "Correo: " + correo);
            }
        });
    }
}