package com.example.ejemplollamadas;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CONTACTS = 0;
    private static final int PERMISSION_REQUEST_CALL_LOG = 1;

    private Button btn_llamada;
    private TextView txt_resultado;
    private LinearLayout vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_llamada = findViewById(R.id.btn_llamada);
        txt_resultado = findViewById(R.id.txt_resultado);
        vista = findViewById(R.id.vista_principal);

        // Accedo al content provider público a partir de la API 22
        btn_llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaLlamadas();
            }
        });
    }

    private void realizaLlamadas() {
        // Comprobar si los permisos han sido concedidos.
        // Elijo el manifest de android
        int permisoLecturaHistorial = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALL_LOG);

        if(permisoLecturaHistorial != PackageManager.PERMISSION_GRANTED) {
            // Pido permisos
            peticionPermisos(Manifest.permission.READ_CALL_LOG,
                    new String[]{Manifest.permission.READ_CALL_LOG},
                    PERMISSION_REQUEST_CALL_LOG,
                    " a los contactos");
        } else {
            // Los permisos han sido concedidos, compruebo las llamadas
            String[] columnas = {CallLog.Calls.TYPE, CallLog.Calls.NUMBER};
            Uri llamadasUri = CallLog.Calls.CONTENT_URI;
            ContentResolver cr = getContentResolver();

            Cursor cur = cr.query(llamadasUri, columnas, null, null, null);

            if (cur != null) {
                if(cur.moveToFirst()) {
                    int tipo;
                    String tipoLlamada = "";
                    String telefono;

                    int colTipo = cur.getColumnIndex(CallLog.Calls.TYPE);
                    int colTelefono = cur.getColumnIndex(CallLog.Calls.NUMBER);

                    txt_resultado.setText("");

                    do {
                        tipo = cur.getInt(colTipo);
                        telefono = cur.getString(colTelefono);

                        if(tipo == CallLog.Calls.INCOMING_TYPE) {
                            tipoLlamada = "ENTRADA";
                        } else if(tipo == CallLog.Calls.OUTGOING_TYPE) {
                            tipoLlamada = "SALIDA";
                        } else if(tipo == CallLog.Calls.MISSED_TYPE) {
                            tipoLlamada = "PERDIDA";
                        }

                        txt_resultado.append(tipoLlamada + " - " + telefono + "\n");
                    } while(cur.moveToNext());
                }

            }
        }
    }

    private void peticionPermisos(String permiso, String[] manifest, int id, String tipo) {

        // El usuario denegó el permiso al menos una vez, pero no seleccionó
        // No volver a preguntar

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permiso)) {
            Snackbar.make(vista,
                    "Es necesario el acceso " + tipo + " para su gestión de la app.",
                    Snackbar.LENGTH_INDEFINITE).setAction("ACEPTAR", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityCompat.requestPermissions(MainActivity.this, manifest, id);
                }
            }).show();
        } else {
            // El permiso aun no ha sido solicitado o el usuario marcó no volver a preguntar
            ActivityCompat.requestPermissions(MainActivity.this, manifest, id);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_REQUEST_CALL_LOG :
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Snackbar.make(vista,
                            "Permiso de lectura establecido",
                            Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(vista,
                            "Permiso de lecturas de contactos denegado",
                            Snackbar.LENGTH_LONG).show();
                }

                break;

        }
    }
}