package com.example.practicaevaluacion_2trimestre_alejandro;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.practicaevaluacion_2trimestre_alejandro.ContentProvider.ContactosProveedor.CONTENT_URI;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.practicaevaluacion_2trimestre_alejandro.BBDD.AdaptadorAvatar;
import com.example.practicaevaluacion_2trimestre_alejandro.ContentProvider.AvatarDatos;
import com.example.practicaevaluacion_2trimestre_alejandro.ContentProvider.ContactosProveedor;
import com.example.practicaevaluacion_2trimestre_alejandro.Spinner.AdaptadorSpinner;
import com.example.practicaevaluacion_2trimestre_alejandro.Spinner.DatosSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int id_avatar;
    ListView lista_contactos;
    AdaptadorAvatar adaptadorAvatar;
    Spinner miSpinner;
    AvatarDatos avatarSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        final ImageView addContact = findViewById(R.id.add_contactos);
        final RelativeLayout seccionContactos = findViewById(R.id.seccion_CU_contactos);
        final Button btn_add = findViewById(R.id.btn_add);
        final Button btn_mod = findViewById(R.id.btn_modificar);
        final Button btn_can = findViewById(R.id.btn_cancelar);
        final EditText edtNombre = findViewById(R.id.edt_nombre);
        final EditText edtTelefono = findViewById(R.id.edt_telefono);

        setSupportActionBar(toolbar);
        lista_contactos = findViewById(R.id.lista_contactos);

        cargarSpinner();
        cargarListadoContentProvider();

        registerForContextMenu(lista_contactos);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DatosSpinner drawable = (DatosSpinner) parent.getItemAtPosition(position);
                id_avatar = drawable.getAvatar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seccionContactos.setVisibility(View.VISIBLE);
                btn_mod.setVisibility(View.GONE);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!edtNombre.getText().toString().isEmpty() && !edtTelefono.getText().toString().isEmpty()) {
                    String nombre = edtNombre.getText().toString();
                    String telefono = edtTelefono.getText().toString();

                    ContentValues values = new ContentValues();
                    values.put(ContactosProveedor.Contactos.COL_NOMBRE, nombre);
                    values.put(ContactosProveedor.Contactos.COL_TELEFONO, telefono);
                    values.put(ContactosProveedor.Contactos.COL_AVATAR, id_avatar);

                    ContentResolver cr = getContentResolver();
                    cr.insert(CONTENT_URI, values);
                    cargarListadoContentProvider();

                    edtNombre.setText("");
                    edtTelefono.setText("");
                }
            }
        });

        btn_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seccionContactos.setVisibility(View.GONE);
            }
        });

        lista_contactos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                avatarSeleccionado = (AvatarDatos) parent.getItemAtPosition(position);

                return  false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.MnOp1) {
            ContentResolver cr = getContentResolver();
            cr.delete(CONTENT_URI, ContactosProveedor.Contactos.COL_ID + "=" + avatarSeleccionado.getId(), null);
            cargarListadoContentProvider();
        }

        return super.onContextItemSelected(item);
    }

    private void cargarSpinner() {
        miSpinner = findViewById(R.id.spinner_avatar);

        ArrayList<DatosSpinner> datosSpinner = new ArrayList<>();
        datosSpinner.add(new DatosSpinner(R.drawable.batman));
        datosSpinner.add(new DatosSpinner(R.drawable.capi));
        datosSpinner.add(new DatosSpinner(R.drawable.deadpool));
        datosSpinner.add(new DatosSpinner(R.drawable.hulk));
        datosSpinner.add(new DatosSpinner(R.drawable.furia));
        datosSpinner.add(new DatosSpinner(R.drawable.ironman));
        datosSpinner.add(new DatosSpinner(R.drawable.lobezno));
        datosSpinner.add(new DatosSpinner(R.drawable.spiderman));
        datosSpinner.add(new DatosSpinner(R.drawable.thor));
        datosSpinner.add(new DatosSpinner(R.drawable.wonderwoman));

        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this, datosSpinner);
        miSpinner.setAdapter(adaptadorSpinner);
    }

    private void cargarListadoContentProvider() {
        ArrayList<AvatarDatos> avatares = new ArrayList<>();

        String[] columnas = {
                ContactosProveedor.Contactos.COL_ID,
                ContactosProveedor.Contactos.COL_AVATAR,
                ContactosProveedor.Contactos.COL_NOMBRE,
                ContactosProveedor.Contactos.COL_TELEFONO
        };

        Uri uri = CONTENT_URI;

        ContentResolver cr = getContentResolver();

        // Hacemos la consulta
        Cursor cur = cr.query(
                uri,
                columnas, // Columnas a devolver
                null,     // Condición de la consulta
                null,     // Argumentos de la consulta
                null      // Orden de la consulta
        );

        if(cur != null) {
            if(cur.moveToFirst()) {
                int clave;
                int avatar;
                String nombre;
                String telefono;


                int colClave = cur.getColumnIndex(ContactosProveedor.Contactos.COL_ID);
                int colAvatar = cur.getColumnIndex(ContactosProveedor.Contactos.COL_AVATAR);
                int colNombre = cur.getColumnIndex(ContactosProveedor.Contactos.COL_NOMBRE);
                int colTelefono = cur.getColumnIndex(ContactosProveedor.Contactos.COL_TELEFONO);

                do {
                    clave = cur.getInt(colClave);
                    avatar = cur.getInt(colAvatar);
                    nombre = cur.getString(colNombre);
                    telefono = cur.getString(colTelefono);

                    avatares.add(new AvatarDatos(clave, avatar, nombre, telefono));
                } while(cur.moveToNext());
            }
        }

         adaptadorAvatar = new AdaptadorAvatar(MainActivity.this, avatares);
        lista_contactos.setAdapter(adaptadorAvatar);
    }
}