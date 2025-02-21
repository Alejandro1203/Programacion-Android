package com.example.practicaevaluacion_2trimestre_alejandro;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practicaevaluacion_2trimestre_alejandro.BBDD.AvatarBBDD;

public class Proveedor extends ContentProvider {

    // Definición de la URI
    private static final String AUTHORITY = "com.example.practicaevaluacion_2trimestre_alejandro";
    private static final String URI = "content://" + AUTHORITY + "/avatares";
    public static Uri CONTENT_URI = Uri.parse(URI);

    // Objeto UriMatcher
    private static final int AVATAR = 1; // Acceso genérico a la tabla
    private static final int AVATAR_ID = 2; // Acceso a una fila
    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY, "avatares", AVATAR);
        URI_MATCHER.addURI(AUTHORITY, "avatares/#", AVATAR_ID);
    }

    public static final class Avatares implements BaseColumns {

        private Avatares() {

        }

        public static final String COL_NOMBRE = "nombre";
        public static final String COL_TELEFONO = "telefono";
        public static final String COL_AVATAR = "avatar";
    }

    private AvatarBBDD avatarBBDD;
    private static final String BD_NOMBRE = "DBAvatar";
    private static final int BD_VERSION = 1;
    private static final String TABLA_AVATARES = "Avatares";

    @Override
    public boolean onCreate() {
        avatarBBDD = new AvatarBBDD(getContext(), BD_NOMBRE, null, BD_VERSION);

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        // Si es una consulta a un ID concreto construimos el WHERE
        String where = selection;
        if (URI_MATCHER.match(uri) == AVATAR_ID){
            where = "_id=" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = avatarBBDD.getWritableDatabase();
        Cursor cursor = db.query(TABLA_AVATARES, projection, where, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = URI_MATCHER.match(uri);

        switch (match) {
            case AVATAR:
                return "vnd.android.cursor.dir/vnd.iesbelen.avatar";
            case AVATAR_ID:
                return "vnd.android.cursor.item/vnd.iesbelen.avatar";
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long regId = 1;

        SQLiteDatabase db =avatarBBDD.getWritableDatabase();

        regId = db.insert(TABLA_AVATARES, null, values);

        Uri newUri = ContentUris.withAppendedId(CONTENT_URI, regId);

        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        String where = selection;

        if (URI_MATCHER.match(uri) == AVATAR_ID) {
            where = "_id" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = avatarBBDD.getWritableDatabase();
        cont = db.delete(TABLA_AVATARES, where,selectionArgs);

        return cont;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        String where = selection;

        if (URI_MATCHER.match(uri) == AVATAR_ID){
            where = "_id=" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = avatarBBDD.getWritableDatabase();
        cont = db.update(TABLA_AVATARES, values, where, selectionArgs);

        return cont;
    }
}
