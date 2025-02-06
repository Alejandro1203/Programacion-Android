package com.example.t7_ejercicio1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText edt_1 = findViewById(R.id.edt_1);
        final EditText edt_2 = findViewById(R.id.edt_2);
        final TextView txt_1 = findViewById(R.id.txt_1);
        final TextView txt_2 = findViewById(R.id.txt_2);
        final Button btn_guardar = findViewById(R.id.btn_guardar);
        final Button btn_recuperar = findViewById(R.id.btn_recuperar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("texto_1", edt_1.getText().toString());
                editor.putString("texto_2", edt_2.getText().toString());

                editor.commit();
            }
        });

        btn_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                txt_1.setText(prefs.getString("texto_1", ""));
                txt_2.setText(prefs.getString("texto_2", ""));
            }
        });
    }
}