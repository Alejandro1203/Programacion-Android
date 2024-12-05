package com.example.ejerciciot3_7;

import android.graphics.Color;
import android.os.Bundle;
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

        final TextView tv = (TextView)findViewById(R.id.tv1);

        //tv.setTextColor(Color.RED);
        tv.setTextColor(Color.rgb(0, 200, 0));

        tv.setText(tv.getText() + "\nHola que tal \n Yo bien y tu");
    }
}