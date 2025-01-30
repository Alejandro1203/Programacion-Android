package com.example.ejerciciot4_02_examen;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}