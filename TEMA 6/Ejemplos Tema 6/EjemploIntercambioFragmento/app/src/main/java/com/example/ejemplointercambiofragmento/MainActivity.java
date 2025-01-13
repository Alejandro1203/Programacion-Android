package com.example.ejemplointercambiofragmento;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction FT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton = findViewById(R.id.btnCambiar);
        FragmentManager FM = getSupportFragmentManager();
        FT = FM.beginTransaction();

        Fragmento fragmento = new Fragmento();
        FT.add(R.id.contenedor, fragmento);
        FT.commit();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FT = FM.beginTransaction();
                Fragmento2 fragmento2 = new Fragmento2();
                FT.replace(R.id.contenedor, fragmento2);
                FT.commit();
            }
        });
    }
}