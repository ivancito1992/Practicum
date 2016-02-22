package com.example.bahia.practicum;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    /* TABLA DE LOS ZUMOS */

    public static final String TABLE_NAME_ZUMOS = "botellas";
    public static final String CN_ID_ZUMOS = "_id";
    public static final String CN_BOTELLAS = "Tipo_Botella";
    public static final String CN_NUMERO = "Numero_Botellas";

    public static final String CREATE_TABLE_ZUMOS = "create table " + TABLE_NAME_ZUMOS + " ("
            + CN_ID_ZUMOS + " integer primary key autoincrement,"
            + CN_BOTELLAS + " text,"
            + CN_NUMERO + " integer);";

    /* TABLA DE PREGUNTAS MUCHO POCO NADA*/

    public static final String TABLE_NAME_PREGUNTAS = "preguntas";
    public static final String CN_ID_PREGUNTAS = "_id";
    public static final String CN_PREGUNTAS = "Preguntas";
    public static final String CN_MUCHO = "Mucho";
    public static final String CN_POCO = "Poco";
    public static final String CN_NADA = "Nada";

    public static final String CREATE_TABLE_PREGUNTAS = "create table " + TABLE_NAME_PREGUNTAS + " ("
            + CN_ID_PREGUNTAS + " integer primary key autoincrement,"
            + CN_PREGUNTAS + " text,"
            + CN_MUCHO + " integer,"
            + CN_POCO + " integer,"
            + CN_NADA + " integer);";

    /* TABLA DE LOS DATOS DE LA AZAFATA */

    public static final String TABLE_NAME_AZAFATA = "azafata";
    public static final String CN_ID_AZAFATA = "_id";
    public static final String CN_NOMBRE = "Nombre_Azafata";
    public static final String CN_CENTRO = "Centro_del_evento";
    public static final String CN_RECOGIDA = "Dia_del_Evento";

    public static final String CREATE_TABLE_AZAFATA = "create table " + TABLE_NAME_AZAFATA + " ("
            + CN_ID_AZAFATA + " integer primary key autoincrement,"
            + CN_NOMBRE + " text,"
            + CN_CENTRO + " text,"
            + CN_RECOGIDA + " text);";

    /* TABLA DE PREGUNTAS SI O NO */

    public static final String TABLE_NAME_SINO = "sino";
    public static final String CN_ID_SINO = "_id";
    public static final String CN_PREGUNTAS_SINO = "Preguntas";
    public static final String CN_SI = "SI";
    public static final String CN_NO = "NO";

    public static final String CREATE_TABLE_SINO = "create table " + TABLE_NAME_SINO + " ("
            + CN_ID_SINO + " integer primary key autoincrement,"
            + CN_PREGUNTAS_SINO + " text,"
            + CN_SI + " integer,"
            + CN_NO + " integer);";

    /* TABLA ESTADISTICAS PARA VOLCADO DE DATOS */

    public static final String TABLE_NAME_ESTADISTICAS = "estadisticas";
    public static final String CN_ID_ESTADISTICAS = "_id";
    public static final String CN_PREGUNTAS_STATS = "Preguntas";
    public static final String CN_PORCENTAJE_MUCHO = "Mucho";
    public static final String CN_PORCENTAJE_POCO = "Poco";
    public static final String CN_PORCENTAJE_NADA = "Nada";

    public static final String CREATE_TABLE_ESTADISTICAS = "create table " + TABLE_NAME_ESTADISTICAS + " ("
            + CN_ID_ESTADISTICAS + " integer primary key autoincrement,"
            + CN_PREGUNTAS_STATS + " text,"
            + CN_PORCENTAJE_MUCHO + " float,"
            + CN_PORCENTAJE_POCO + " float,"
            + CN_PORCENTAJE_NADA + " float);";


    private SQLiteDatabase db;

    public DBManager(Context context) {
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();

    }

    private ContentValues VGGenerales(String pregunta, int mucho, int poco, int nada) {
        ContentValues v = new ContentValues();
        v.put(CN_PREGUNTAS, pregunta);
        v.put(CN_MUCHO, mucho);
        v.put(CN_POCO, poco);
        v.put(CN_NADA, nada);
        return v;
    }

    public void insertarPreguntasGenerales(String pregunta, int mucho, int poco, int nada) {
        db.insert(TABLE_NAME_PREGUNTAS, null, VGGenerales(pregunta, mucho, poco, nada));
    }

    private ContentValues valuesGeneratorPregutnasSiNo(String texto, int si, int no) {
        ContentValues values = new ContentValues();
        values.put(CN_PREGUNTAS_SINO, texto);
        values.put(CN_SI, si);
        values.put(CN_NO, no);
        return values;
    }

    public void insertarPreguntasSiNo(String texto, int si, int no) {
        db.insert(TABLE_NAME_SINO, null, valuesGeneratorPregutnasSiNo(texto, si, no));
    }

    private ContentValues VGZumos(String nombreZumo, int cantidad) {
        ContentValues v = new ContentValues();
        v.put(CN_BOTELLAS, nombreZumo);
        v.put(CN_NUMERO, cantidad);
        return v;
    }

    public void insertarZumos(String nombreZumo, int cantidad) {
        db.insert(TABLE_NAME_ZUMOS, null, VGZumos(nombreZumo, cantidad));
    }

    private ContentValues valuesGeneratorAzafata(String azafata, String centro, String dia) {
        ContentValues values = new ContentValues();
        values.put(CN_NOMBRE, azafata);
        values.put(CN_CENTRO, centro);
        values.put(CN_RECOGIDA, dia);
        return values;
    }

    public void insertarDatosAzafata(String azafata, String centro, String dia) {
        db.insert(TABLE_NAME_AZAFATA, null, valuesGeneratorAzafata(azafata, centro, dia));
    }

    private ContentValues VGEstadisticas(String pregunta, float sM, float sP, float sN) {
        ContentValues values = new ContentValues();
        values.put(CN_PREGUNTAS_STATS, pregunta);
        values.put(CN_PORCENTAJE_MUCHO, sM);
        values.put(CN_PORCENTAJE_POCO, sP);
        values.put(CN_PORCENTAJE_NADA, sN);
        return values;
    }

    public void insertarDatosEstadisticos(String pregunta, float sM, float sP, float sN) {
        db.insert(TABLE_NAME_ESTADISTICAS, null, VGEstadisticas(pregunta, sM, sP, sN));
    }
}

