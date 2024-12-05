package com.example.ejemploeventlistener;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        // Recupero los elementos del layout
        final TextView etiqueta1 = findViewById(R.id.lbl1);
        final TextView etiqueta2 = findViewById(R.id.lbl2);
        final TextView etiqueta3 = findViewById(R.id.lbl3);
        final TextView etiqueta4 = findViewById(R.id.lbl4);

        final EditText texto = findViewById(R.id.et);

        // Defino el event listener TextChangedListener
        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                etiqueta1.setText("Texto antes de cambiar: " + charSequence.toString());
                etiqueta3.setText("Texto antes de cambiar: " + charSequence.toString() + " start: " + start + " count: " + count + " after: " + after);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                etiqueta2.setText("Texto cambiado: " + charSequence.toString());
                etiqueta4.setText("Texto cambiado: " + charSequence.toString() + " start: " + start + " count: " + count + " after: " + after);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void onClick(View view) {
        final TextView etiqueta = findViewById(R.id.lbl5);
        int id = view.getId();

        if(id == R.id.btnAceptar) {
            etiqueta.setText("Aceptar");
        } else if(id == R.id.btnCancelar) {
            etiqueta.setText("Cancelar");
        }

    }
}