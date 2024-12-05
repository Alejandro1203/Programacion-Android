package com.example.t4_ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Truco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.truco);

        final TextView txtPreparate =  findViewById(R.id.txtPreparate);

        txtPreparate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Truco.this, MainActivity.class);
                intent.putExtra("truco", "truco");
                startActivity(intent);
            }
        });
    }

}
