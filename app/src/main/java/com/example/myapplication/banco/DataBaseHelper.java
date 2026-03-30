package com.example.myapplication.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String tbMainQ = "tbMainQ";
    public static final String column_id = "id";
    public static final String column_texto = "texto";
    public static String column_exemplo = "exemplo";

    // AQUI A GENTE PASSA OS DADOS DO BANCO //
    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TCC", null, 1);
    }

    // QUANDO CHAMAMOS PELA PRIMEIRA VEZ, IGUAL O ON CREATE DO ANDROID //
    @Override
    public void onCreate(SQLiteDatabase db) {
        // CRIANDO A TABELA //
        String createTableStatement = "CREATE TABLE " + tbMainQ + " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
