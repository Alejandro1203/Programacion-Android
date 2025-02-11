package com.example.t7_ejercicio2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button btn_definir = findViewById(R.id.btn_definir);
        final Button btn_recuperar = findViewById(R.id.btn_recuperar);

        btn_definir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OpcionesActivity.class);
                startActivity(intent);
            }
        });

        btn_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Log.i("Preferences", "SO Único: " + sharedPreferences.getBoolean("opcion1", false));
                Log.i("Preferences", "SO: " + sharedPreferences.getString("opcion2", ""));
                Log.i("Preferences", "Versión: " + sharedPreferences.getString("opcion3", ""));
            }
        });


    }
}