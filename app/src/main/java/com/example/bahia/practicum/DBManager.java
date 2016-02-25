package com.example.bahia.practicum;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    /* TABLA DE LOS ZUMOS */
    public static final String TABLE_NAME_BOTELLAS_ZUMOS = "botellas";
    public static final String CN_ID_ZUMOS = "_id";
    public static final String CN_BOTELLAS = "Tipo_Botella";
    public static final String CN_NUMERO = "Numero_Botellas";

    public static final String CREATE_TABLE_ZUMOS = "create table " + TABLE_NAME_BOTELLAS_ZUMOS + " ("
            + CN_ID_ZUMOS + " integer primary key autoincrement,"
            + CN_BOTELLAS + " text,"
            + CN_NUMERO + " integer);";

    /* TABLA DE PREGUNTAS ZUMOS MUCHO POCO NADA*/
    public static final String TABLE_NAME_ZUMOS = "Preguntas_Zumos";
    public static final String CN_ID_PREGUNTAS_ZUMOS = "_id";
    public static final String CN_PREGUNTAS_ZUMOS = "Preguntas";
    public static final String CN_MUCHO_ZUMOS = "Mucho";
    public static final String CN_POCO_ZUMOS = "Poco";
    public static final String CN_NADA_ZUMOS = "Nada";

    public static final String CREATE_TABLE_PREGUNTAS = "create table " + TABLE_NAME_ZUMOS + " ("
            + CN_ID_PREGUNTAS_ZUMOS + " integer primary key autoincrement,"
            + CN_PREGUNTAS_ZUMOS + " text,"
            + CN_MUCHO_ZUMOS + " integer,"
            + CN_POCO_ZUMOS + " integer,"
            + CN_NADA_ZUMOS + " integer);";

    /* TABLA DE PREGUNTAS ZUMOS MUCHO POCO NADA*/
    public static final String TABLE_NAME_VEGGIES = "Preguntas_Veggies";
    public static final String CN_ID_VEGGIES = "_id";
    public static final String CN_PREGUNTAS_VEGGIES = "Preguntas";
    public static final String CN_MUCHO_VEGGIES = "Mucho";
    public static final String CN_POCO_VEGGIES = "Poco";
    public static final String CN_NADA_VEGGIES = "Nada";

    public static final String CREATE_TABLE_VEGGIES = "create table " + TABLE_NAME_VEGGIES + " ("
            + CN_ID_VEGGIES + " integer primary key autoincrement,"
            + CN_PREGUNTAS_VEGGIES + " text,"
            + CN_MUCHO_VEGGIES + " integer,"
            + CN_POCO_VEGGIES + " integer,"
            + CN_NADA_VEGGIES + " integer);";

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

    private SQLiteDatabase db;

    public DBManager(Context context) {
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();

    }

    private ContentValues VGVeggies(String pregunta, int mucho, int poco, int nada) {
        ContentValues v = new ContentValues();
        v.put(CN_PREGUNTAS_VEGGIES, pregunta);
        v.put(CN_MUCHO_VEGGIES, mucho);
        v.put(CN_POCO_VEGGIES, poco);
        v.put(CN_NADA_VEGGIES, nada);
        return v;
    }

    public void insertarPreguntasVeggies(String pregunta, int mucho, int poco, int nada) {
        db.insert(TABLE_NAME_VEGGIES, null, VGVeggies(pregunta, mucho, poco, nada));
    }

    private ContentValues VGGenerales(String pregunta, int mucho, int poco, int nada) {
        ContentValues v = new ContentValues();
        v.put(CN_PREGUNTAS_ZUMOS, pregunta);
        v.put(CN_MUCHO_ZUMOS, mucho);
        v.put(CN_POCO_ZUMOS, poco);
        v.put(CN_NADA_ZUMOS, nada);
        return v;
    }

    public void insertarPreguntasGenerales(String pregunta, int mucho, int poco, int nada) {
        db.insert(TABLE_NAME_ZUMOS, null, VGGenerales(pregunta, mucho, poco, nada));
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
        db.insert(TABLE_NAME_BOTELLAS_ZUMOS, null, VGZumos(nombreZumo, cantidad));
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
}

