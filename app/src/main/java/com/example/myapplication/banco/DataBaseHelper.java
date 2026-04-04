package com.example.myapplication.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.MainQuestion;

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
        String createTableStatement = "CREATE TABLE " + tbMainQ + " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_texto + " VARCHAR(100), " + column_exemplo + " VARCHAR(100))";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addPeerguntas(){
        MainQuestion main1 = new MainQuestion(1, "TESTE", "TESTE");

        System.out.println(add(main1));
    }

    public boolean add(MainQuestion mainQ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(column_id, mainQ.getId());
        cv.put(column_texto, mainQ.getTexto());
        cv.put(column_exemplo, mainQ.getExemplo());

        long insert = db.insert(tbMainQ, null, cv);

        if(insert == -1){
            return false;
        }

        else{
            return true;
        }
    }
}
