package com.example.t4_ejercicio4;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rellenarSpinner();

        final ImageButton imagen = findViewById(R.id.imageAraña);
        final Spinner spinnerTrucoTrato = findViewById(R.id.spinnerTrucoTrato);

        spinnerTrucoTrato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                imagen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(spinnerTrucoTrato.getSelectedItemPosition() == 0) {
                            Intent intent = new Intent(MainActivity.this, Truco.class);
                            startActivity(intent);
                        }

                        if(spinnerTrucoTrato.getSelectedItemPosition() == 1) {
                            Intent intent = new Intent(MainActivity.this, Trato.class);
                            startActivity(intent);
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Bundle extras = getIntent().getExtras();
        String informacion = extras != null ? extras.getString("informacion") : null;

        if(Objects.equals(informacion, "fantasmas")) {
            imagen.setImageResource(R.drawable.fantasma);
        } else if (Objects.equals(informacion, "calabazas")){
            imagen.setImageResource(R.drawable.calabaza);
        }

        final LinearLayout linearPadre = findViewById(R.id.padre);

        informacion = extras != null ? extras.getString("truco") : null;

        if(Objects.equals(informacion, "truco")) {
            Drawable fondo = ContextCompat.getDrawable(this, R.drawable.fondo6);
            linearPadre.setBackground(fondo);
        }
    }

    private void rellenarSpinner() {
        final Spinner spinnerTrucoTrato = findViewById(R.id.spinnerTrucoTrato);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.datos, android.R.layout.simple_spinner_item);
        spinnerTrucoTrato.setAdapter(adapter);
    }
}