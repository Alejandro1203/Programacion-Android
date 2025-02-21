package com.example.elhuevazo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView image = findViewById(R.id.huevo);
        final EditText edit = findViewById(R.id.edt);
        final Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tecto = edit.getText().toString();
                String textoLimpio = tecto.replaceAll("\\s+", "").toLowerCase();

                if(textoLimpio.contains("kinderbueno")) {
                    image.setImageResource(R.drawable.bellako);
                }
            }
        });


    }
}