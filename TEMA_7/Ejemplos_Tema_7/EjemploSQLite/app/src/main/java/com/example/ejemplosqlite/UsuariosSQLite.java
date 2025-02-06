package com.example.ejemplosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuariosSQLite extends SQLiteOpenHelper {
    String sqlCreate =
            "CREATE TABLE Usuarios(" +
                    "codigo INTEGER PRIMARY KEY, " +
                    "nombre TEXT)";

    public UsuariosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    // Por simplicidad del ejemplo vamos a borrar directamente la tabla creada y la vamos a volver a
    // crear, en lugar de hacer una migración de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(sqlCreate);
    }
}
