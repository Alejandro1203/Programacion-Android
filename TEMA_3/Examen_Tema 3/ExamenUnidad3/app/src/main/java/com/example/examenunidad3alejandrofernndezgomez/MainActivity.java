package com.example.examenunidad3alejandrofernndezgomez;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private void actividad1() {
        setContentView(R.layout.activity_main);
        Toolbar tool = findViewById(R.id.toolBar);
        setSupportActionBar(tool);

        LinearLayout linear = findViewById(R.id.layoutHijo);
        Button btnLogIn = findViewById(R.id.btnLogin);
        EditText edtUser = findViewById(R.id.edtUser);
        EditText edtPassword = findViewById(R.id.edtPassword);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                linear.setVisibility(View.VISIBLE);
            }
        }, 3000);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUser.length() > 0 && edtPassword.length() > 0) {
                    Toast.makeText(MainActivity.this, "Hola " + edtUser.getText() + ". Accediendo a la app",
                                   Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Introduce usuario y contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void actividad2() {
        setContentView(R.layout.activity2);
        Toolbar tool = findViewById(R.id.toolBar);
        setSupportActionBar(tool);

        RelativeLayout relative = findViewById(R.id.relativePadre);
        Button btnNext = findViewById(R.id.btnNext);

        for (int index = 0; index < relative.getChildCount(); index++) {


            if (relative.getChildAt(index) instanceof Button) {
                Button btn = (Button) relative.getChildAt(index);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        btn.setTextColor(Color.rgb(247, 193, 234));
                    }
                });
            }
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void actividad3() {
        setContentView(R.layout.activity3);
        Toolbar tool = findViewById(R.id.toolBar);
        setSupportActionBar(tool);

        Spinner spinnerDays = findViewById(R.id.spinnerDays);
        String[] valores = {"1 día", "2 días", "3 días", "4 días", "5 días", "6 días", "7 días"};
        spinnerDays.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));


        spinnerDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            TextView txtSpinner = findViewById(R.id.txtSpinner);

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = (String) adapterView.getItemAtPosition(i);
                txtSpinner.setText(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //actividad1();
        //actividad2();
        actividad3();
    }
}