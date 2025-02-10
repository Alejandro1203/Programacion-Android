package com.example.ejemplocontentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn_insertar;
    private Button btn_consultar;
    private Button btn_eliminar;
    private TextView txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los controles
        btn_insertar = findViewById(R.id.btn_insertar);
        btn_consultar = findViewById(R.id.btn_consultar);
        btn_eliminar = findViewById(R.id.btn_eliminar);
        txt_resultado = findViewById(R.id.txt_resultados);

        // Creo la consulta con el contentResolver
        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Columnas a recuperar
                String[] columnas = {
                    ClientesProvider.Clientes._ID,
                    ClientesProvider.Clientes.COL_NOMBRE,
                    ClientesProvider.Clientes.COL_TELEFONO,
                    ClientesProvider.Clientes.COL_EMAIL
                };

                Uri uri = ClientesProvider.CONTENT_URI;

                ContentResolver cr = getContentResolver();

                // Hacemos la consulta
                Cursor cur = cr.query(
                        uri,
                        columnas, // Columnas a devolver
                        null,     // Condición de la consulta
                        null,     // Argumentos de la consulta
                        null      // Orden de la consulta
                );

                if(cur != null) {
                    if(cur.moveToFirst()) {
                        String nombre;
                        String telefono;
                        String email;

                        int colNombre = cur.getColumnIndex(ClientesProvider.Clientes.COL_NOMBRE);
                        int colTelefono = cur.getColumnIndex(ClientesProvider.Clientes.COL_TELEFONO);
                        int colEmail = cur.getColumnIndex(ClientesProvider.Clientes.COL_EMAIL);

                        txt_resultado.setText("");

                        do {
                            nombre = cur.getString(colNombre);
                            telefono = cur.getString(colTelefono);
                            email = cur.getString(colEmail);
                            txt_resultado.append(nombre + " - " + telefono + " - " + email + "\n");
                        } while(cur.moveToNext());
                    }
                }
            }
        });

        // INSERTO DATOS CON EL CONTENT RESOLVER EN EL CONTENT PROVIDER
        btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues registro = new ContentValues();
                registro.put(ClientesProvider.Clientes.COL_NOMBRE, "Cliente nuevo");
                registro.put(ClientesProvider.Clientes.COL_TELEFONO, "0.123520.4");
                registro.put(ClientesProvider.Clientes.COL_EMAIL, "semeolvida@gmail.com");

                ContentResolver cr = getContentResolver();
                cr.insert(ClientesProvider.CONTENT_URI, registro);
            }
        });

        // BORRAR DATOS CON EL CONTENT RESOLVER
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver cr = getContentResolver();
                cr.delete(ClientesProvider.CONTENT_URI, ClientesProvider.Clientes.COL_NOMBRE + "='Cliente nuevo'", null);
            }
        });

    }
}