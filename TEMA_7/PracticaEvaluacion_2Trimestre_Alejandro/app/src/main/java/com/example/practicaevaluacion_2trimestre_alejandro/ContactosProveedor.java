package com.example.practicaevaluacion_2trimestre_alejandro;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practicaevaluacion_2trimestre_alejandro.BBDD.ContactoBBDD;

public class ContactosProveedor extends ContentProvider {

    // Definición de la URI
    private static final String AUTHORITY = "com.example.practicaevaluacion_2trimestre_alejandro";
    private static final String URI = "content://" + AUTHORITY + "/contactos";
    public static Uri CONTENT_URI = Uri.parse(URI);

    // Objeto UriMatcher
    private static final int CONTACTO = 1; // Acceso genérico a la tabla
    private static final int CONTACTO_ID = 2; // Acceso a una fila
    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY, "contactos", CONTACTO);
        URI_MATCHER.addURI(AUTHORITY, "contactos/#", CONTACTO_ID);
    }

    public static final class Contactos implements BaseColumns {

        private Contactos() {

        }

        public static final String COL_ID = "clave";
        public static final String COL_NOMBRE = "nombre";
        public static final String COL_TELEFONO = "telefono";
        public static final String COL_AVATAR = "avatar";
    }

    private ContactoBBDD contactoBBDD;
    private static final String BD_NOMBRE = "DBContacto";
    private static final int BD_VERSION = 1;
    private static final String TABLA_CONTACTOS = "Contactos";

    @Override
    public boolean onCreate() {
        contactoBBDD = new ContactoBBDD(getContext(), BD_NOMBRE, null, BD_VERSION);

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String where = selection;

        if (URI_MATCHER.match(uri) == CONTACTO_ID){
            where = "_id=" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = contactoBBDD.getWritableDatabase();
        Cursor cursor = db.query(TABLA_CONTACTOS, projection, where, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = URI_MATCHER.match(uri);

        switch (match) {
            case CONTACTO:
                return "vnd.android.cursor.dir/vnd.iesbelen.contacto";
            case CONTACTO_ID:
                return "vnd.android.cursor.item/vnd.iesbelen.contacto";
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long regId = 1;

        SQLiteDatabase db = contactoBBDD.getWritableDatabase();

        regId = db.insert(TABLA_CONTACTOS, null, values);

        Uri newUri = ContentUris.withAppendedId(CONTENT_URI, regId);

        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        String where = selection;

        if (URI_MATCHER.match(uri) == CONTACTO_ID) {
            where = "_id" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = contactoBBDD.getWritableDatabase();
        cont = db.delete(TABLA_CONTACTOS, where,selectionArgs);

        return cont;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        String where = selection;

        if (URI_MATCHER.match(uri) == CONTACTO_ID){
            where = "_id=" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = contactoBBDD.getWritableDatabase();
        cont = db.update(TABLA_CONTACTOS, values, where, selectionArgs);

        return cont;
    }
}
