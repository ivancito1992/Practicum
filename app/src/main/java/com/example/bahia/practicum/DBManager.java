package com.example.bahia.practicum;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    public int numeroPreguntasGenerales = 11;
    public int numeroTiposZumos = 7;

    /* TABLA DE LOS ZUMOS */

    public static final String TABLE_NAME_ZUMOS = "botellas";
    public static final String CN_ID_ZUMOS = "_id";
    public static final String CN_BOTELLAS = "Tipo de botella";
    public static final String CN_NUMERO = "Numero de botellas";

    public static final String CREATE_TABLE_ZUMOS = "create table " + TABLE_NAME_ZUMOS + " ("
            + CN_ID_ZUMOS + " integer primary key autoincrement,"
            + CN_BOTELLAS + " text,"
            + CN_NUMERO + " integer);";

    /* TABLA DE PREGUNTAS MUCHO POCO NADA*/

    public static final String TABLE_NAME_PREGUNTAS = "preguntas";
    public static final String CN_ID_PREGUNTAS = "_id";
    public static final String CN_PREGUNTAS = "Preguntas";
    public static final String CN_MUCHO = "Respuesta Mucho";
    public static final String CN_POCO = "Respuesta Poco";
    public static final String CN_NADA = "Respuesta Nada";

    public static final String CREATE_TABLE_PREGUNTAS = "create table " + TABLE_NAME_PREGUNTAS + " ("
            + CN_ID_PREGUNTAS + " integer primary key autoincrement,"
            + CN_PREGUNTAS + " text,"
            + CN_MUCHO + " integer,"
            + CN_POCO + " integer,"
            + CN_NADA + " integer);";

    /* TABLA DE LOS DATOS DE LA AZAFATA */

    public static final String TABLE_NAME_AZAFATA = "azafata";
    public static final String CN_ID_AZAFATA = "DNI";
    public static final String CN_NOMBRE = "Nombre de la Azafata";
    public static final String CN_CENTRO = "Centro del evento";
    public static final String CN_RECOGIDA = "Dia del Evento";

    public static final String CREATE_TABLE_AZAFATA = "create table " + TABLE_NAME_AZAFATA + " ("
            + CN_ID_AZAFATA + " integer primary key autoincrement,"
            + CN_NOMBRE + " text,"
            + CN_CENTRO + " text,"
            + CN_RECOGIDA + " text);";

    /* TABLA DE PREGUNTAS SI O NO */

    public static final String TABLE_NAME_SINO = "sino";
    public static final String CN_ID_SINO = "_id";
    public static final String CN_PREGUNTAS_SINO = "Preguntas";
    public static final String CN_SI = "Respuesta SI";
    public static final String CN_NO = "Respuesta NO";

    public static final String CREATE_TABLE_SINO = "create table " + TABLE_NAME_SINO + " ("
            + CN_ID_SINO + " integer primary key autoincrement,"
            + CN_PREGUNTAS_SINO + " text,"
            + CN_SI + " integer,"
            + CN_NO + " integer);";

    /* TABLA ESTADISTICAS PARA VOLCADO DE DATOS */

    public static final String TABLE_NAME_ESTADISTICAS = "estadisticas";
    public static final String CN_ID_ESTADISTICAS = "_id";
    public static final String CN_PREGUNTAS_STATS = "Preguntas";
    public static final String CN_PORCENTAJE_MUCHO = "% Mucho";
    public static final String CN_PORCENTAJE_POCO = "% Poco";
    public static final String CN_PORCENTAJE_NADA = "% Nada";

    public static final String CREATE_TABLE_ESTADISTICAS = "create table " + TABLE_NAME_ESTADISTICAS + " ("
            + CN_ID_ESTADISTICAS + " integer primary key autoincrement,"
            + CN_PREGUNTAS_STATS + " text,"
            + CN_PORCENTAJE_MUCHO + " float,"
            + CN_PORCENTAJE_POCO + " float,"
            + CN_PORCENTAJE_NADA + " float);";


    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();

    }


    private ContentValues valuesGeneratorPreguntasGenerales(String[] textos, int[] mucho, int[] poco, int[] nada) {
        ContentValues values = new ContentValues();
        int i;
        for (i = 0; i < numeroPreguntasGenerales - 1; i++) {
            values.put(CN_PREGUNTAS, textos[i]);
            values.put(CN_MUCHO, mucho[i]);
            values.put(CN_POCO, poco[i]);
            values.put(CN_NADA, nada[i]);
        }
        return values;
    }

    public void insertarPreguntasGenerales(String[] textos, int[] mucho, int[] poco, int[] nada) {
        int i;
        for (i = 0; i < numeroPreguntasGenerales - 1; i++) {
            db.insert(TABLE_NAME_PREGUNTAS, null, valuesGeneratorPreguntasGenerales(textos, mucho, poco, nada));
        }
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

    private ContentValues valuesGeneratorZumos(String[] nombreZumo, int[] cantidad) {
        ContentValues values = new ContentValues();
        int i;
        for (i = 0; i < numeroTiposZumos - 1; i++) {
            values.put(CN_BOTELLAS, nombreZumo[i]);
            values.put(CN_NUMERO, cantidad[i]);
        }
        return values;
    }

    public void insertarZumos(String[] nombreZumo, int[] numeroZumos) {
        int i;
        for (i = 0; i < numeroTiposZumos - 1; i++) {
            db.insert(TABLE_NAME_ZUMOS, null, valuesGeneratorZumos(nombreZumo, numeroZumos)); /* esto devuelve 0 si correcto y -1 si error*/
            //db.execSQL("insert into "+TABLE_NAME_ZUMOS+" values (null,'"+nombreZumo[i]+"',"+numeroZumos[i]+")");
        }
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

    private ContentValues valuesGeneratorEstadisticas(String[] preguntas, float[] statMucho, float[] statPoco, float[] statNada){
        ContentValues values = new ContentValues();
        int i;
        for (i = 0; i < numeroPreguntasGenerales - 1; i++) {
            values.put(CN_PREGUNTAS_STATS, preguntas[i]);
            values.put(CN_PORCENTAJE_MUCHO, statMucho[i]);
            values.put(CN_PORCENTAJE_POCO, statPoco[i]);
            values.put(CN_PORCENTAJE_NADA, statNada[i]);
        }
        return values;
    }

    public void insertarDatosEstadisticos(String[] preguntas, float[] statMucho, float[] statPoco, float[] statNada){
        int i;
        for (i = 0; i < numeroPreguntasGenerales - 1; i++) {
            db.insert(TABLE_NAME_ESTADISTICAS, null, valuesGeneratorEstadisticas(preguntas, statMucho, statPoco, statNada));
        }
    }
}