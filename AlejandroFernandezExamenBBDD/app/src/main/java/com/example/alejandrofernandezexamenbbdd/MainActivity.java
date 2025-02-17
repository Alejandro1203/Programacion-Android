package com.example.alejandrofernandezexamenbbdd;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PeliculasBBDD peliculasBBDD = new PeliculasBBDD(this, "DBPeliculas", null, 1);
        SQLiteDatabase db = peliculasBBDD.getWritableDatabase();
        db.execSQL("DELETE FROM Peliculas");

        insertDataBBDD(db);
        insertDataTendencias(db);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.MnOp1) {
            startActivity(new Intent(MainActivity.this, OpcionesActivity.class));

            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void insertDataBBDD(SQLiteDatabase db) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre", "Alquimia");
        nuevoRegistro.put("foto", R.drawable.alquimia);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Breaking");
        nuevoRegistro.put("foto", R.drawable.breaking);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Broadchurch");
        nuevoRegistro.put("foto", R.drawable.broadchurch);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Erased");
        nuevoRegistro.put("foto", R.drawable.erased);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Hill");
        nuevoRegistro.put("foto", R.drawable.hill);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Howl");
        nuevoRegistro.put("foto", R.drawable.howl);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Lucifer");
        nuevoRegistro.put("foto", R.drawable.lucifer);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Stranger");
        nuevoRegistro.put("foto", R.drawable.stranger);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Supernatural");
        nuevoRegistro.put("foto", R.drawable.supernatural);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);

        nuevoRegistro.put("nombre", "Titanes");
        nuevoRegistro.put("foto", R.drawable.titanes);
        nuevoRegistro.put("lista", 0);
        db.insert("Peliculas", null, nuevoRegistro);
    }

    private void insertDataTendencias(SQLiteDatabase db) {
        final ListView listadoPeliculas = findViewById(R.id.list_tendencias);

        Cursor c = db.rawQuery("SELECT * FROM Peliculas WHERE lista = 0",null);
        ArrayList<PeliculasDatos> peliculas = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                int clave = c.getInt(0);
                String titulo = c.getString(1);
                int imagen = c.getInt(2);
                int lista = c.getInt(3);
                PeliculasDatos pelicula = new PeliculasDatos(clave, titulo, imagen, lista);
                peliculas.add(pelicula);

            }while (c.moveToNext());
        }

        AdaptadorPeliculas miadapatador = new AdaptadorPeliculas(this, peliculas);
        listadoPeliculas.setAdapter(miadapatador);
    }

}