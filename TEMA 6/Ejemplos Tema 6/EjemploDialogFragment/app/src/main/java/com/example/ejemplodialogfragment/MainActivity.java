package com.example.ejemplodialogfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnAlerta = findViewById(R.id.btn_alerta);
        final Button btnConfirmacion = findViewById(R.id.btn_confirmacion);
        final Button btnSeleccion = findViewById(R.id.btn_seleccion);
        final Button btnRadio = findViewById(R.id.btn_radio);
        final Button btnMultiRadio = findViewById(R.id.btn_multi_radio);
        final Button btnPersonalizado = findViewById(R.id.btn_Personalizado);
        FragmentManager FM = getSupportFragmentManager();

        btnAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoAlerta dialogo = new DialogoAlerta();
                dialogo.show(FM, "tagAlerta");
            }
        });

        btnConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoConfirmacion dialogo = new DialogoConfirmacion();
                dialogo.show(FM, "tagConfirmación");
            }
        });

        btnSeleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoSeleccion dialogo = new DialogoSeleccion();
                dialogo.show(FM, "tagSelección");
            }
        });

        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoRadio dialogo = new DialogoRadio();
                dialogo.show(FM, "tagRadio");
            }
        });

        btnMultiRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoRadioMulti dialogo = new DialogoRadioMulti();
                dialogo.show(FM, "tagRadio");
            }
        });

        btnPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoPersonalizado dialogo = new DialogoPersonalizado();
                dialogo.show(FM, "tagPersonalizado");
            }
        });
    }
}