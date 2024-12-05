package com.example.exament4_5m2;

import static android.widget.ArrayAdapter.createFromResource;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;
import java.util.zip.ZipEntry;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Bundle extras = getIntent().getExtras();
//        String toast = extras != null ? extras.getString("Toast") : null;
//
//        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final TextView texto = findViewById(R.id.texto);
        final ListView listadoList = findViewById(R.id.listadoList);
        final GridView listadoGrid = findViewById(R.id.listadoGrid);
        final Spinner spinner = findViewById(R.id.spinner);

        String[] items;
        int opcion = item.getItemId();

        if(opcion == R.id.MnOp1 || opcion == R.id.MnOp2 || opcion == R.id.MnOp3) {

            texto.setText(item.getTitle());
            listadoList.setVisibility(View.INVISIBLE);
            listadoGrid.setVisibility(View.INVISIBLE);
        }

        if(opcion == R.id.MnOp2) {
            spinner.setVisibility(View.VISIBLE);
            listadoGrid.setVisibility(View.VISIBLE);

            items = getResources().getStringArray(R.array.datosSpinner);
            ArrayAdapter<CharSequence> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
            spinner.setAdapter(adaptador);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if( i == 0) {
                        String[] items = getResources().getStringArray(R.array.datosGridListShonen);
                        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(adapterView.getContext(), android.R.layout.simple_list_item_1, items);
                        listadoGrid.setAdapter(adapter);
                    } else {
                        String[] items = getResources().getStringArray(R.array.datosGridListShojo);
                        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(adapterView.getContext(), android.R.layout.simple_list_item_1, items);
                        listadoGrid.setAdapter(adapter);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        if(opcion == R.id.MnOp1_1) {
            listadoList.setVisibility(View.VISIBLE);
            listadoGrid.setVisibility(View.VISIBLE);

            items = getResources().getStringArray(R.array.datosStudioGhibli);
            ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

            listadoList.setAdapter(adapter);
        }

        if(opcion == R.id.MnOp1_2) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://mubi.com/es/cast/clamp"));
            startActivity(intent);
        }

        if(opcion == R.id.MnOp3_1) {
            Intent intent = new Intent(MainActivity.this, Imagen.class);
            intent.putExtra("info", "Shonen");
            startActivity(intent);
        }

        if(opcion == R.id.MnOp3_2) {
            Intent intent = new Intent(MainActivity.this, Imagen.class);
            intent.putExtra("info", "Shojo");
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo){

        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }
}