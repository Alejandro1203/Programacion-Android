package com.example.t5_ejercicio5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        Data[] data = {
                new Data("Goku","675684566"),
                new Data("Vegeta","655545257"),
                new Data("Krilin","601332323"),
                new Data("Piccolo","525239231"),
                new Data("Freezer","604235252"),
        };

        final ListView list = findViewById(R.id.list);

        View cabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        list.addHeaderView(cabecera);

        //Crear adaptador personalizado
        Adapt myAdapter = new Adapt(this,data);
        list.setAdapter(myAdapter);

        //Crea listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected1 = ((Data)adapterView.getItemAtPosition(position)).getNombre();
                String selected2 = ((Data)adapterView.getItemAtPosition(position)).getNombre();
                Toast.makeText(MainActivity.this, "Nombre de contacto: "+selected1, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Numero de telefono: "+selected2, Toast.LENGTH_SHORT).show();

            }
        });
    }
}