package com.example.exament4_5m2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Imagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagen);

        final ImageView imagen = findViewById(R.id.imagen);
        final Button boton = findViewById(R.id.boton);

        Bundle extras = getIntent().getExtras();
        String info = extras != null ? extras.getString("info") : null;

        if(Objects.equals(info, "Shonen")) {
            imagen.setImageResource(R.drawable.kimetsu);
        } else if (Objects.equals(info, "Shojo")){
            imagen.setImageResource(R.drawable.furuba);
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Imagen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
