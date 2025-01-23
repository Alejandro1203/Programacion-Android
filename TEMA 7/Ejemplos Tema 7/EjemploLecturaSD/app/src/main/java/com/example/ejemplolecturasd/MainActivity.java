package com.example.ejemplolecturasd;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ESTE PROGRAMA FUNCIONA SOLO HASTA LA API 29 (SIN INCLUIR) PARA QUE FUNCIONE
        // EN TODAS LAS APIS, EJECUTAR CON LAS LÍNEAS COMENTADAS

        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;

        // Comprobar el estado de la memeoria SD
        String estado = Environment.getExternalStorageState();

        if(estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        } else if(estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
        }

        if(sdDisponible && sdAccesoEscritura) {

            // Escribo en la tarjeta SD

            try {
                // Obtener la ruta del directorio raíz
                //File ruta_sd = Environment.getExternalStorageDirectory();

                // Esta es la línea para todas las APIs
                File ruta_sd = getExternalFilesDir(null);

                File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
                fout.write("Texto de prueba");
                fout.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Leo los datos que acabo de escribir

            try {
                //File ruta_sd = Environment.getExternalStorageDirectory();

                // Esta es la línea para todas las APIs
                File ruta_sd = getExternalFilesDir(null);

                File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String linea = in.readLine();
                Toast.makeText(this, linea, Toast.LENGTH_SHORT).show();
                in.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}