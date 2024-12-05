package com.example.t5_ejercicio1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        final ListView listView = findViewById(R.id.listView);

        //final String[] datos = {"Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.datos, android.R.layout.simple_spinner_item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(posicion).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}