package com.example.t7_ejercicio4;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingd);

        getSupportFragmentManager().beginTransaction().replace(R.id.main, new OpcionesPreferencias()).commit();
    }
}
