package com.example.ejerciciot4_02_examen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Introducimos la toolbar
        final Toolbar tool = findViewById(R.id.toolBar);
        setSupportActionBar(tool);

        // Recuperamos los componentes que se necesiten
        final LinearLayout linear = findViewById(R.id.layoutHijo);
        final Button btnLogIn = findViewById(R.id.btnLogin);
        final EditText edtUser = findViewById(R.id.edtUser);
        final EditText edtPassword = findViewById(R.id.edtPassword);

        // Creación de Handler para que aparezca el LinearLayout tras 3 segundos
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                linear.setVisibility(View.VISIBLE);
            }
        }, 3000);


        // Evento al pulsar botón
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUser.length() > 0 && edtPassword.length() > 0) {
                    Toast.makeText(activity1.this, "Hola " + edtUser.getText() + ". Accediendo a la app",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(activity1.this, activity2.class);
                    intent.putExtra("usuario", edtUser.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(activity1.this, "Introduce usuario y contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}