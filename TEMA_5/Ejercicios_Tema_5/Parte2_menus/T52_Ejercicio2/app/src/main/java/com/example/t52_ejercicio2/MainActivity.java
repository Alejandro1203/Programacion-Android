package com.example.t52_ejercicio2;

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
        getMenuInflater().inflate(R.menu.menu_encabezado, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcion = item.getItemId();

        final TextView texto = findViewById(R.id.texto);

        if(opcion == R.id.MnOp1_1) {
            texto.setText("PULSADO LUNES");
            return true;

        } else if(opcion == R.id.MnOp1_2) {
            texto.setText("PULSADO MARTES");
            return true;

        } else if(opcion == R.id.MnOp1_3) {
            texto.setText("PULSADO MIÉRCOLES");
            return true;

        } else if(opcion == R.id.MnOp1_4) {
            texto.setText("PULSADO JUEVES");
            return true;

        } else if(opcion == R.id.MnOp1_5) {
            texto.setText("PULSADO VIERNES");
            return true;

        } else if(opcion == R.id.MnOp1_6) {
            texto.setText("PULSADO SÁBADO");
            return true;

        } else if(opcion == R.id.MnOp1_7) {
            texto.setText("PULSADO DOMINGO");
            return true;

        } else if(opcion == R.id.MnOp2_1) {
            texto.setText("Pulsado el mes de enero");
            return true;
        } else if(opcion == R.id.MnOp2_2) {
            texto.setText("Pulsado el mes de febrero");
            return true;
        } else if(opcion == R.id.MnOp2_3) {
            texto.setText("Pulsado el mes de marzo");
            return true;
        } else if(opcion == R.id.MnOp2_4) {
            texto.setText("Pulsado el mes de abril");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}