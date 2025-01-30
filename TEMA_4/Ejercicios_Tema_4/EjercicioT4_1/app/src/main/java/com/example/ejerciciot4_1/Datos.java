package com.example.ejerciciot4_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);
        Toolbar tool = findViewById(R.id.toolBar);
        setSupportActionBar(tool);

        // Recupero el botón de aceptar
        Button btnAceptar = findViewById(R.id.btnAceptar);

        // Acción si se pulsa dicho botón
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNombre = findViewById(R.id.edtNombre);
                EditText edtFecha = findViewById(R.id.edtFecha);
                CheckBox checkRecordatorio = findViewById(R.id.chckBoxRecordatorio);
                TextView txtRespuesta = findViewById(R.id.txtRespuesta);
                txtRespuesta.setText("");

                if (edtNombre.getText().length() > 0 && edtFecha.getText().length() > 0){
                   txtRespuesta.append("¡Hola " + edtNombre.getText() + "! Has nacido el " + edtFecha.getText() + ". ");

                   if (checkRecordatorio.isChecked()) {
                       txtRespuesta.append("Se ha creado un recordatorio.");
                   }

                    Intent intent = new Intent(Datos.this, Encuesta.class);
                    intent.putExtra("usuario", edtNombre.getText().toString());
                    Toast.makeText(Datos.this, edtNombre.getText(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

                if (edtNombre.getText().length() == 0) {
                    txtRespuesta.append("ERROR. No has escrito el nombre.\n");
                }

                if (edtFecha.getText().length() == 0) {
                    txtRespuesta.append("ERROR. No has escrito la fecja de nacimiento.");
                }
            }
        });
    }
}