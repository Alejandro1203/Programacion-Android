package com.example.ejemplosqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

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

        UsuariosSQLite usuarios = new UsuariosSQLite(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usuarios.getWritableDatabase();

        // Comprobamos que se ha abierto correctamente la base de datos
        if(db != null) {
            // Insertamos 5 usuarios
            String usuario;

            for (int index = 0; index < 5; index++) {
                usuario = "Usuario " + index;
                db.execSQL("INSERT INTO Usuarios(codigo, nombre) VALUES (" + index +", '" + usuario + "')");
            }

            db.close();
        }
    }
}