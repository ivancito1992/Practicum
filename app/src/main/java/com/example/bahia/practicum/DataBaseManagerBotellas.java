package com.example.bahia.practicum;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

public class DataBaseManagerBotellas {
    public static final String TABLE_NAME = "botellas";

    public static final String CN_ID = "_id";
    public static final String CN_BOTELLAS = "Tipo de botella";
    public static final String CN_NUMERO = "Numero de botellas";

    public static final String CREATE_TABLE =  "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_BOTELLAS + " text not null,"
            + CN_NUMERO + " integer) ;";

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public DataBaseManagerBotellas(Context context) {

    }

    public ContentValues generarContentValues(String botella, String numero){
        ContentValues valores = new ContentValues();
        valores.put(CN_BOTELLAS, botella);
        valores.put(CN_NUMERO, numero);

        return valores;
    }

    public void insertar (String botella, String numero){
        db.insert(TABLE_NAME, null, generarContentValues(botella, numero));
    }

    public void insertar2(String botella, String numero) {
        db.execSQL("insert into "+TABLE_NAME+" values (null,'"+botella+"',"+numero+")");
    }
}
