package com.example.saladstar.paginas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.saladstar.R;
import com.example.saladstar.adaptador.Adapt;
import com.example.saladstar.adaptador.Data;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private void showHome() {
        final GridView lista = findViewById(R.id.listaGrid);
        final TextView textoH1 = findViewById(R.id.textoH1);
        final ImageView imagenCentral = findViewById(R.id.imagenCentral);

        lista.setVisibility(View.GONE);
        imagenCentral.setVisibility(View.VISIBLE);
        imagenCentral.setImageResource(R.drawable.proximamente);

        textoH1.setText("Principal");
        Toast.makeText(Home.this, "Principal proximamente...", Toast.LENGTH_SHORT).show();
    }

    private void showTicket() {
        final GridView lista = findViewById(R.id.listaGrid);
        final TextView textoH1 = findViewById(R.id.textoH1);
        final ImageView imagenCentral = findViewById(R.id.imagenCentral);

        imagenCentral.setVisibility(View.GONE);
        lista.setVisibility(View.VISIBLE);
        textoH1.setVisibility(View.VISIBLE);
        textoH1.setText("Entradas");

        ArrayList<Data> datos = new ArrayList<>();
        datos.add(new Data(R.drawable.boleto, "General", 20.99f));
        datos.add(new Data(R.drawable.boleto, "General + 2 copas", 32.99f));
        datos.add(new Data(R.drawable.boleto, "Reservado (1 botella + 12 bebidas", 200f));
        datos.add(new Data(R.drawable.boleto, "Reservado VIP (3 botellas + 36 bebidas", 500f));

        Adapt myAdapter = new Adapt(datos, Home.this);
        lista.setAdapter(myAdapter);
    }

    private void showShop() {
        final GridView lista = findViewById(R.id.listaGrid);
        final TextView textoH1 = findViewById(R.id.textoH1);
        final ImageView imagenCentral = findViewById(R.id.imagenCentral);

        lista.setVisibility(View.GONE);
        imagenCentral.setVisibility(View.VISIBLE);
        imagenCentral.setImageResource(R.drawable.proximamente);

        textoH1.setText("Tienda");
        Toast.makeText(Home.this, "Merhandising proximamente...", Toast.LENGTH_SHORT).show();
    }

    private void showUser() {
        final GridView lista = findViewById(R.id.listaGrid);
        final TextView textoH1 = findViewById(R.id.textoH1);
        final ImageView imagenCentral = findViewById(R.id.imagenCentral);

        lista.setVisibility(View.GONE);
        imagenCentral.setVisibility(View.VISIBLE);
        imagenCentral.setImageResource(R.drawable.proximamente);

        textoH1.setText("Perfil");
        Toast.makeText(Home.this, "Perfil proximamente...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Adición del menú a la ToolBar
        registerForContextMenu(toolbar);

        final ImageView home = findViewById(R.id.home);
        final ImageView ticket = findViewById(R.id.ticket);
        final ImageView shop = findViewById(R.id.shop);
        final ImageView user = findViewById(R.id.user);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHome();
            }
        });

        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTicket();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShop();
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUser();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcion = item.getItemId();

        if(opcion == R.id.MnOp1) {
            showHome();
        }

        if(opcion == R.id.MnOp2) {
            showTicket();
        }

        if(opcion == R.id.MnOp3_1) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:666738173"));
            startActivity(intent);
        }

        if(opcion == R.id.MnOp3_2) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"afergom1203@g.educaand.es"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Atención al Cliente");
            startActivity(intent);
        }

        return true;
    }
}