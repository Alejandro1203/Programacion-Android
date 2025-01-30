package com.example.ejemplomemoriainterna;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Escribo en la memoria interna del dispositivo

        try {
            OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt", Context.MODE_PRIVATE));
            miFichero.write("TEXTO DE PRUEBA");
        } catch (Exception e) {
            System.out.println(e);
            Log.e("Fichero", "Error al escribir en la memmoria interna");
        }

        // Recupero la información de memoria interna

        try {
            BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));

            String texto = miFichero.readLine();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}