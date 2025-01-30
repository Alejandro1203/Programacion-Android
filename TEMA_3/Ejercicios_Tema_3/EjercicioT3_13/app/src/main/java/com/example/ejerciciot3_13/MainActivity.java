package com.example.ejerciciot3_13;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
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
        setContentView(R.layout.activity_main);
        Toolbar tool = findViewById(R.id.toolBar);
        setSupportActionBar(tool);

        RatingBar rating = findViewById(R.id.rating);
        TextView textoRating = findViewById(R.id.txtView4);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textoRating.setText("Gracias por la valoración!!");
            }
        });

        Button btnAceptar = findViewById(R.id.btnAceptar);
        TextView texto = findViewById(R.id.txtView5);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar carga = findViewById(R.id.progressCircularBar);
                Handler handler = new Handler(getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        carga.setVisibility(View.VISIBLE);
                    }
                });

                Handler handler2 = new Handler(getMainLooper());
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        carga.setVisibility(View.INVISIBLE);
                        texto.setText("Datos personales: ");
                        RelativeLayout layoutEditText = findViewById(R.id.relativeL);

                        for (int indice = 0; indice < layoutEditText.getChildCount(); indice++) {

                            if(layoutEditText.getChildAt(indice) instanceof EditText) {
                                EditText editText = (EditText) layoutEditText.getChildAt(indice);
                                texto.append("\n" + editText.getText());
                            }
                        }
                    }
                }, 5000);
            }
        });

        Button btnReset = findViewById(R.id.btnResetear);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNombre = findViewById(R.id.edt1);
                edtNombre.setText("");
                EditText edtApellido =  findViewById(R.id.edt2);
                edtApellido.setText("");
                EditText edtCorreo = findViewById(R.id.edt3);
                edtCorreo.setText("");

                Spinner spinnerEstadoCivil = findViewById(R.id.spinner1);
                spinnerEstadoCivil.setSelection(0);

                rating.setRating(1);

                TextView textoRating = findViewById(R.id.txtView4);
                textoRating.setText("");

                TextView texto = findViewById(R.id.txtView5);
                texto.setText("");
            }
        });
    }
}