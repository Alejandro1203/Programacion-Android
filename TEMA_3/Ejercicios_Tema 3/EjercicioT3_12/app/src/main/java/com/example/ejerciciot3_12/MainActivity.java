package com.example.ejerciciot3_12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.RadioGroup;
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

        Button btnAceptar = findViewById(R.id.btn2);
        TextView txt = findViewById(R.id.txtAficiones);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("Tus aficiones son: ");
                GridLayout layoutCheckBox = findViewById(R.id.grid1);

                for (int indice = 0; indice < layoutCheckBox.getChildCount(); indice++) {
                    CheckBox miCheckBox = (CheckBox) layoutCheckBox.getChildAt(indice);

                    if(miCheckBox.isChecked()){
                        txt.setText(txt.getText() + "\n" + miCheckBox.getText());
                    }
                }
            }
        });

        Button btnReset = findViewById(R.id.btn1);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(null);

                GridLayout layoutCheckBox = findViewById(R.id.grid1);

                for (int indice = 0; indice < layoutCheckBox.getChildCount(); indice++) {
                    CheckBox miCheckBox = (CheckBox) layoutCheckBox.getChildAt(indice);

                    if(miCheckBox.isChecked()){
                        miCheckBox.setChecked(false);
                    }
                }

                RadioGroup radioG = findViewById(R.id.rg1);
                radioG.clearCheck();

                RadioGroup radioG2 = findViewById(R.id.rg2);
                radioG2.clearCheck();
            }
        });
    }
}