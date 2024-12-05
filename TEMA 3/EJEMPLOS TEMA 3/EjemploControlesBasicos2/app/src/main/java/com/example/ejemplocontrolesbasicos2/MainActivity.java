package com.example.ejemplocontrolesbasicos2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
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

        // Ejmeplo de spinner creando los datos desde java
        Spinner spinner = findViewById(R.id.miSpinner);
        String[] valores = {"Dato 1", "Dato 2", "Dato 3", "Dato 4"};
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, valores));

        TextView texto = findViewById(R.id.txt1);
        String valor = spinner.getSelectedItem().toString();
        texto.setText(valor);

        // El valor no cambia, solo sale el que tomó cuando se
        // ejecutó la app. Para tomar un nuevo valor hay que definir
        //un manejador de eventos

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int posicion, long id) {
                //String cadena = (String) adaptador.getItemAtPosition(posicion);

                /*Segunda forma de obtener el elemento*/
                String cadena = adaptador.getSelectedItem().toString();

                texto.setText(cadena);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adaptador) {

            }
        });

        // Ejemplo 2 de Spinner creando los datos desde XML
        Spinner spinner2 = findViewById(R.id.miSpinner2);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.valores, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adaptador);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int posicion, long id) {
                String cadena = adaptador.getSelectedItem().toString();
                texto.setText(cadena);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Recupero el checkbox y creo el listener
        TextView texto2 = findViewById(R.id.lbl1);
        CheckBox miCheck = findViewById(R.id.miCheck);

        miCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pulsado) {
                if(pulsado){
                    texto2.setText("Seleccionado");
                } else {
                    texto2.setText("Deseleccionado");
                }
            }
        });

        RadioGroup grupo = findViewById(R.id.grupo);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                final RadioButton rb = findViewById(checkedId);
                texto2.setText(rb.getText().toString());
            }
        });

        Switch miSwitch = findViewById(R.id.miSwitch);
        miSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pulsado) {
                if(pulsado) {
                    texto2.setText("Switch marcado");
                } else {
                    texto2.setText("Switch no marcado");
                }
            }
        });

        RatingBar misEstrellas = findViewById(R.id.rating);
        misEstrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float valor, boolean b) {
                texto2.setText("Nuevo valor: " + valor);
            }
        });

        SeekBar miSeek = findViewById(R.id.seek);
        miSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView txtSeek = findViewById(R.id.txt3);
                txtSeek.setAlpha(i/60f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                texto2.setText("Inicio de cambio de texto en seek bar");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                texto2.setText("Fin de cambio de texto en seek bar");
            }
        });
    }
}