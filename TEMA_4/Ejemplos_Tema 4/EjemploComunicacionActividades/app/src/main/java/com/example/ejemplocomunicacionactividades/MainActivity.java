package com.example.ejemplocomunicacionactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblResultado = findViewById(R.id.lblResultado);

        // Recogemos los datos de la actividad B (Condicionesuso)
        ActivityResultLauncher resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == MainActivity.RESULT_OK) {
                    Intent intent = result.getData();

                    if(intent!= null) {
                        Bundle extras = intent.getExtras();
                        String resultado = extras.getString("boton_pulsado");
                        lblResultado.setText("Resultado: " + resultado);
                    }
                } else if(result.getResultCode() == MainActivity.RESULT_CANCELED) {
                    Toast.makeText(MainActivity.this, "Actividad cancelada", Toast.LENGTH_SHORT).show();

                }
            }
        });


        // Invocamos la actividad B (CondicionesUso)
        final EditText etNombre = findViewById(R.id.etNombre);
        final Button btnVerificar = findViewById(R.id.btnVerificar);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etNombre.getText().toString();

                // Creo el intent y le paso los datos
                Intent intent_condiciones = new Intent(MainActivity.this, CondicionesUso.class);
                intent_condiciones.putExtra("usuario", usuario);
                //startActivity(intent_condiciones);
                resultLauncher.launch(intent_condiciones);
            }
        });
    }
}