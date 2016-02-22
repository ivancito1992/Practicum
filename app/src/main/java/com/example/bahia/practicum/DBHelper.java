package com.example.bahia.practicum;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "BASEDATOSZUMOSOL.sqlite";
    private static final int DB_SCHEME_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBManager.CREATE_TABLE_ZUMOS);
        db.execSQL(DBManager.CREATE_TABLE_AZAFATA);
        //db.execSQL(DBManager.CREATE_TABLE_ESTADISTICAS);
        db.execSQL(DBManager.CREATE_TABLE_PREGUNTAS);
        db.execSQL(DBManager.CREATE_TABLE_SINO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
