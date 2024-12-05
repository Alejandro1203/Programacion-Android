package com.example.exament4_5m2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Info  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        final TextView texto = findViewById(R.id.texto);
        final Button boton = findViewById(R.id.boton);

        Bundle extras = getIntent().getExtras();
        String titulo = extras != null ? extras.getString("titulo") : null;

        if(Objects.equals(titulo, "Mi vecino Totoro")) {
            texto.setText(titulo);
        } else if (Objects.equals(titulo, "El castillo ambulante")){
            texto.setText(titulo);
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, MainActivity.class);
                intent.putExtra("Toast", "En construcción");
                startActivity(intent);
            }
        });
    }
}
