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

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        final TextView txtRegistrar = findViewById(R.id.txtRegistrar);
        final EditText edtUsuario = findViewById(R.id.edtUsuario);
        final EditText edtContrasenya = findViewById(R.id.edtContrasenya);
        final Button btnInicioSesion = findViewById(R.id.btnInicioSesion);

        txtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, Register.class);
                startActivity(intent);
            }
        });

        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUsuario.getText().toString().isEmpty()) {
                    Toast.makeText(LogIn.this, "Introduce un Usuario", Toast.LENGTH_SHORT).show();
                } else if(edtContrasenya.getText().toString().isEmpty()) {
                    Toast.makeText(LogIn.this, "Introduce una Contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LogIn.this, Home.class);
                    intent.putExtra("usuario", edtUsuario.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}