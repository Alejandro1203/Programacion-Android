package com.example.ejemplociclovida;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Definimos el método de callBack onCreate de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Usamos la clase Toast que muestra durante 2 segundos un mensaje pequeño al usuario
        Toast.makeText(this, "Se ejecuta el método onCreate", Toast.LENGTH_SHORT).show();
    }

    // Definimos el método de llamada onPause de la actividad
    @Override
    protected void onPause() {
        super.onPause();

        // Aquí deberíamos guardar la información para la siguiente sesión
        Toast.makeText(this, "Se ejecuta el método onPause", Toast.LENGTH_SHORT).show();
    }

    // Definimos el método de llamada onRestart de la actividad
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Se ejecuta el método onRestart", Toast.LENGTH_SHORT).show();
    }

    // Definimos el método de llamada onResume de la actividad
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Se ejecuta el método onResume", Toast.LENGTH_SHORT).show();
    }

    // Definimos el método de llamada onStart de la actividad
    @Override
    protected void onStart() {
        super.onStart();

        // Aquí deberíamos leer los datos de la última sesión para continuar la actividad
        // donde la dejó el usuario
        Toast.makeText(this, "Se ejecuta el método onStart", Toast.LENGTH_SHORT).show();
    }

    // Definimos el método de llamada onDestroy de la actividad
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Si no hay memoria suficiente Android destruye la actividad sin ejecutar el método
        Toast.makeText(this, "Se ejecuta el método onDestroy", Toast.LENGTH_SHORT).show();
    }

    // Definimos el método de llamada onStop de la actividad
    @Override
    protected void onStop() {
        super.onStop();

        // Si no hay memoria suficiente Android destruye la actividad sin ejecutar el método
        Toast.makeText(this, "Se ejecuta el método onStop", Toast.LENGTH_SHORT).show();
    }
}