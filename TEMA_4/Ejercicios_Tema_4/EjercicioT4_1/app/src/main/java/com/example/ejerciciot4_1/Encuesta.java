package com.example.ejerciciot4_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Encuesta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("usuario");

        TextView txtBienvenida = findViewById(R.id.txtInicio);
        txtBienvenida.setText("Por favor, " + nombre + " valore la aplicación");


        Button btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView logo = findViewById(R.id.logo);
                logo.setVisibility(View.VISIBLE);
                TextView text = findViewById(R.id.txtAgradecimiento);
                text.setVisibility(View.VISIBLE);

            }
        });
    }
}