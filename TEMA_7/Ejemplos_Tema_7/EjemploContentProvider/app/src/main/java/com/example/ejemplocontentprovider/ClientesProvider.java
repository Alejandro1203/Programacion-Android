package com.example.ejemplocontentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ClientesProvider extends ContentProvider {

    //Definición de la URI
    private static final String AUTHORITY = "com.example.ejemplocontentprovider";
    private static final String URI = "content://" + AUTHORITY + "/clientes";
    public static final Uri CONTENT_URI = Uri.parse(URI);

    // Definimos el objeto UriMatcher
    private static final int CLIENTE = 1; // Acceso genérico a tabla
    private static final int CLIENTE_ID = 2; // Acceso auna fila
    private static final UriMatcher URI_MATCHER;

    // Inicializamos el UriMatcher
    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY, "clientes", CLIENTE);
        URI_MATCHER.addURI(AUTHORITY, "clientes/#", CLIENTE_ID);
    }

    // Clase Interna para declarar las constantes de la columna
    public static final class Clientes implements BaseColumns {

        private Clientes() {

        }

        public static final String COL_NOMBRE = "nombre";
        public static final String COL_TELEFONO = "telefono";
        public static final String COL_EMAIL = "email";
    }

    // Base de datos
    private ClientesBBDD clientesBBDD;
    private static final String BD_NOMBRE = "DBCliente";
    private static final int BD_VERSION = 1;
    private static final String TABLA_CLIENTES = "Clientes";

    @Override
    public boolean onCreate() {
        clientesBBDD = new ClientesBBDD(getContext(), BD_NOMBRE, null, BD_VERSION);

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        // Si es una consulta a un ID concreto construimos el WHERE
        String where = selection;
        if (URI_MATCHER.match(uri) == CLIENTE_ID){
            where = "_id=" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = clientesBBDD.getWritableDatabase();
        Cursor cursor = db.query(TABLA_CLIENTES, projection, where, selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = URI_MATCHER.match(uri);

        switch (match){
            case CLIENTE:
                return "vnd.android.cursor.dir/vnd.iesbelen.cliente";
            case CLIENTE_ID:
                return "vnd.android.cursor.item/vnd.iesbelen.cliente";
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long regId = 1;

        SQLiteDatabase db = clientesBBDD.getWritableDatabase();

        regId = db.insert(TABLA_CLIENTES, null, values);

        Uri newUri = ContentUris.withAppendedId(CONTENT_URI,regId);

        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        // Si es una consulta a un ID concreto construimos el WHERE
        String where = selection;

        if (URI_MATCHER.match(uri) == CLIENTE_ID){
            where = "_id=" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = clientesBBDD.getWritableDatabase();
        cont = db.delete(TABLA_CLIENTES, where, selectionArgs);

        return cont;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        // Si es una consulta a un ID concreto construimos el WHERE
        String where = selection;

        if (URI_MATCHER.match(uri) == CLIENTE_ID){
            where = "_id=" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = clientesBBDD.getWritableDatabase();
        cont = db.update(TABLA_CLIENTES, values, where, selectionArgs);

        return cont;
    }
}

