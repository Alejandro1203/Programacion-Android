package com.example.t52_ejercicio1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dias_semana, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcion = item.getItemId();

        final TextView texto = findViewById(R.id.texto);

        if(opcion == R.id.MnOp1) {
            texto.setText("PULSADO LUNES");
            return true;

        } else if(opcion == R.id.MnOp2) {
            texto.setText("PULSADO MARTES");
            return true;

        } else if(opcion == R.id.MnOp3) {
            texto.setText("PULSADO MIÉRCOLES");
            return true;

        } else if(opcion == R.id.MnOp4) {
            texto.setText("PULSADO JUEVES");
            return true;

        } else if(opcion == R.id.MnOp5) {
            texto.setText("PULSADO VIERNES");
            return true;

        } else if(opcion == R.id.MnOp6) {
            texto.setText("PULSADO SÁBADO");
            return true;

        } else if(opcion == R.id.MnOp7) {
            texto.setText("PULSADO DOMINGO");
            return true;

        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}