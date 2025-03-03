package com.example.practicaevaluacion_2trimestre_alejandro;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.practicaevaluacion_2trimestre_alejandro.Spinner.AdaptadorSpinner;
import com.example.practicaevaluacion_2trimestre_alejandro.Spinner.DatosSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Spinner miSpinner = findViewById(R.id.spinner_avatar);

        ArrayList<DatosSpinner> datosSpinner = new ArrayList<>();
        datosSpinner.add(new DatosSpinner(R.drawable.batman));
        datosSpinner.add(new DatosSpinner(R.drawable.capi));
        datosSpinner.add(new DatosSpinner(R.drawable.deadpool));
        datosSpinner.add(new DatosSpinner(R.drawable.hulk));
        datosSpinner.add(new DatosSpinner(R.drawable.furia));
        datosSpinner.add(new DatosSpinner(R.drawable.ironman));
        datosSpinner.add(new DatosSpinner(R.drawable.lobezno));
        datosSpinner.add(new DatosSpinner(R.drawable.spiderman));
        datosSpinner.add(new DatosSpinner(R.drawable.thor));
        datosSpinner.add(new DatosSpinner(R.drawable.wonderwoman));

        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this, datosSpinner);
        miSpinner.setAdapter(adaptadorSpinner);
    }

    private void insertarDataBBDD(SQLiteDatabase db) {
    }
}