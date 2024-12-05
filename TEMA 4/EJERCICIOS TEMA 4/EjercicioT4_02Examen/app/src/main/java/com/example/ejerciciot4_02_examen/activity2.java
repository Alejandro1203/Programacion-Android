package com.example.ejerciciot4_02_examen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        // Introducimos la toolbar
        Toolbar tool = findViewById(R.id.toolBar);
        setSupportActionBar(tool);

        // Recuperamos los componentes que necesitemos
        final TextView txt = findViewById(R.id.txtWelcome);
        final Button btnNext = findViewById(R.id.btnNext);
        final Button btn1 = findViewById(R.id.btnWeight);
        final Button btn2 = findViewById(R.id.btnStrenght);
        final Button btn3 = findViewById(R.id.btnHealthy);

        Bundle extras = getIntent().getExtras();
        String nombre =extras.getString("usuario").toUpperCase();
        txt.append(" "  + nombre);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setTextColor(Color.rgb(247, 193, 234));
                btn2.setTextColor(Color.rgb(243, 230, 248));
                btn3.setTextColor(Color.rgb(243, 230, 248));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setTextColor(Color.rgb(243, 230, 248));
                btn2.setTextColor(Color.rgb(247, 193, 234));
                btn3.setTextColor(Color.rgb(243, 230, 248));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setTextColor(Color.rgb(243, 230, 248));
                btn2.setTextColor(Color.rgb(243, 230, 248));
                btn3.setTextColor(Color.rgb(247, 193, 234));
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity2.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity2.this, activity3.class);
                startActivity(intent);
            }
        });
    }
}