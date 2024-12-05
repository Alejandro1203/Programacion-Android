package com.example.ejemplocontrolesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.layout2);

        /*
        // Buscar el id de las etiquetas
        final TextView etiq1 = (TextView) findViewById(R.id.lbl1);
        final TextView etiq7 = (TextView) findViewById(R.id.lbl7);

        String texto = etiq1.getText().toString();
        etiq7.setText(texto + ", copiado de lbl1");

        ///////////////////////////////////////////////////

        // Botones
        // Busco el id de la etiqueta de botones
        final TextView etiqBtn = (TextView) findViewById(R.id.lblBtn);

        // Recupero el id del boton y creo el manejador de eventos
        final Button miBoton = (Button) findViewById(R.id.Btn1);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etiqBtn.setText("Pulsado botón simple");
            }
        });

        // Recupero el id de toggle button y creo el manejador de eventos
        final ToggleButton miToggleButton = (ToggleButton) findViewById(R.id.toggleBtn);

        miToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    etiqBtn.setText("ToggleButton pulsado");
                } else {
                    etiqBtn.setText("ToggleButton no pulsado");
                }
            }
        });

        // Recupero el id de ambos imageButton y creo un manejador de eventos
        final ImageButton miImageButton2 = (ImageButton) findViewById(R.id.imgBtn2);
        miImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ImageButton miImageButton = (ImageButton) findViewById(R.id.imgBtn);
                miImageButton.setImageResource(R.drawable.feliz);
            }
        });*/



        // SEGUNDA PARTE DEL EJEMPLO. TRABAJAMOS CON LAYOUT 2

        final ImageView imgV = (ImageView) findViewById(R.id.img2);
        imgV.setImageResource(R.drawable.feliz);

        // Trabajamos con AutoCompleteTextView
        //Creamos los datos y definimos el elemento
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4"};
        AutoCompleteTextView textoLeido = findViewById(R.id.acText);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        textoLeido.setAdapter(adaptador);

        //Creamos el MultiAutocompleteTextView
        MultiAutoCompleteTextView textoleido2 = findViewById(R.id.macText);
        ArrayAdapter<String> adapatador2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        textoleido2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        textoleido2.setAdapter(adapatador2);




    }
}