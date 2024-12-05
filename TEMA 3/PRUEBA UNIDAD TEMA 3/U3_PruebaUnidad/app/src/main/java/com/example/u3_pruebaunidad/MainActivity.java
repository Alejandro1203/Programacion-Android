package com.example.u3_pruebaunidad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Primer Layout Presentación
//        setContentView(R.layout.presentacion);


        // Segundo Layout Datos
//        setContentView(R.layout.datos);
//        Toolbar tool = findViewById(R.id.toolBar);
//        setSupportActionBar(tool);
//
//        // Recupero el botón de aceptar
//        Button btnAceptar = findViewById(R.id.btnAceptar);
//
//        // Acción si se pulsa dicho botón
//        btnAceptar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                EditText edtNombre = findViewById(R.id.edtNombre);
//                EditText edtFecha = findViewById(R.id.edtFecha);
//                CheckBox checkRecordatorio = findViewById(R.id.chckBoxRecordatorio);
//                TextView txtRespuesta = findViewById(R.id.txtRespuesta);
//                txtRespuesta.setText("");
//
//                if (edtNombre.getText().length() > 0 && edtFecha.getText().length() > 0){
//                   txtRespuesta.append("¡Hola " + edtNombre.getText() + "! Has nacido el " + edtFecha.getText() + ". ");
//
//                   if (checkRecordatorio.isChecked()) {
//                       txtRespuesta.append("Se ha creado un recordatorio.");
//                   }
//                }
//
//                if (edtNombre.getText().length() == 0) {
//                    txtRespuesta.append("ERROR. No has escrito el nombre.\n");
//                }
//
//                if (edtFecha.getText().length() == 0) {
//                    txtRespuesta.append("ERROR. No has escrito la fecja de nacimiento.");
//                }
//            }
//        });

        // Tercer Layout Encuesta
        setContentView(R.layout.encuesta);

        Button btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView logo = findViewById(R.id.logo);
                logo.setVisibility(View.VISIBLE);
                TextView text = findViewById(R.id.txtAgradecimiento);
                text.setVisibility(View.VISIBLE);

            }
        });
    }
}