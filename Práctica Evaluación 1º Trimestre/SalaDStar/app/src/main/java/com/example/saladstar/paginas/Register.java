package com.example.saladstar.paginas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.saladstar.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText edtCorreo = findViewById(R.id.edtCorreo);
        final EditText edtUsuario = findViewById(R.id.edtUsuario);
        final EditText edtContrasenya = findViewById(R.id.edtContrasenya);
        final EditText edtRepetirContrasenya = findViewById(R.id.edtRepetirContrasenya);
        final TextView txtInicioSesion = findViewById(R.id.txtInicioSesion);
        final Button btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        txtInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, LogIn.class);
                startActivity(intent);
            }
        });

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtCorreo.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Introduce un correo", Toast.LENGTH_SHORT).show();
                } else if(edtUsuario.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Introduce un usuario", Toast.LENGTH_SHORT).show();
                } else if(edtContrasenya.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Introduce una contraseña", Toast.LENGTH_SHORT).show();
                } else if(edtRepetirContrasenya.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Confirme la contraseña", Toast.LENGTH_SHORT).show();
                } else if(!edtContrasenya.getText().toString().equals(edtRepetirContrasenya.getText().toString())) {
                    Toast.makeText(Register.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Register.this, Home.class);
                    intent.putExtra("usuario", edtUsuario.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}