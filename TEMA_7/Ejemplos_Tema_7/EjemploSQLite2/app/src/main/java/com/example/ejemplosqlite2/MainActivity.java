package com.example.ejemplosqlite2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
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

        final TextView lblConsulta = findViewById(R.id.lblConsulta);
        final EditText etCodigo = findViewById(R.id.etCodigo);
        final EditText etNombre = findViewById(R.id.etNombre);
        final Button btnInsertar = findViewById(R.id.btnInsertar);
        final Button btnBorrar = findViewById(R.id.btnBorrar);
        final Button btnActualizar = findViewById(R.id.btnActualizar);
        final Button btnConsultar = findViewById(R.id.btnConsultar);

        // Abrimos la base de datos en modo escritura
        UsuarioBBDD usuarios = new UsuarioBBDD(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usuarios.getWritableDatabase();

        // Comprobamos que se ha abierto correctamente la base de datos
        if(db != null) {

            btnInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cod = etCodigo.getText().toString();
                    String usuario = etNombre.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("codigo", cod);
                    registro.put("nombre", usuario);
                    db.insert("Usuarios", null, registro);

                    // Borro el formulario
                    etCodigo.setText("");
                    etNombre.setText("");
                }
            });

            // Borro todos los datos
            btnBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.execSQL("DELETE FROM Usuarios");
                }
            });

            // Actualizo los datos
            btnActualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cod = etCodigo.getText().toString();
                    String usuario = etNombre.getText().toString();

                    String args[] = {usuario, cod};
                    db.execSQL("UPDATE Usuarios SET nombre=? WHERE codigo=?", args);
                }
            });

            // Consulto todos los datos
            btnConsultar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lblConsulta.setText("");

                    Cursor miCursor = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null);

                    if(miCursor.moveToFirst()) {
                        do {
                            String cod = miCursor.getString(0);
                            String usuario = miCursor.getString(1);

                            lblConsulta.append(cod + " " + usuario + "\n");
                        } while(miCursor.moveToNext());

                        miCursor.close();
                    }
                }
            });
        }
    }
}