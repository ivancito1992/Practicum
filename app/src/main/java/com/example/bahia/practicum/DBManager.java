package com.example.bahia.practicum;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    /* TABLA DE LOS ZUMOS */

    public static final String TABLE_NAME_ZUMOS = "botellas";
    public static final String CN_ID_ZUMOS = "_id";
    public static final String CN_BOTELLAS = "Tipo de botella";
    public static final String CN_NUMERO = "Numero de botellas";

    public static final String CREATE_TABLE_ZUMOS =  "create table " +TABLE_NAME_ZUMOS+ " ("
            + CN_ID_ZUMOS + " integer primary key autoincrement,"
            + CN_BOTELLAS + " text not null,"
            + CN_NUMERO + " integer);";

    /* TABLA DE PREGUNTAS MUCHO POCO NADA*/

    public static final String TABLE_NAME_PREGUNTAS = "preguntas";
    public static final String CN_ID_PREGUNTAS = "_id";
    public static final String CN_PREGUNTAS = "Preguntas";
    public static final String CN_MUCHO = "Respuesta Mucho";
    public static final String CN_POCO = "Respuesta Poco";
    public static final String CN_NADA = "Respuesta Nada";

    public static final String CREATE_TABLE_PREGUNTAS =  "create table " +TABLE_NAME_PREGUNTAS+ " ("
            + CN_ID_PREGUNTAS + " integer primary key autoincrement,"
            + CN_PREGUNTAS + " text not null,"
            + CN_MUCHO + " integer,"
            + CN_POCO + " integer,"
            + CN_NADA + " integer);";

    /* TABLA DE LOS DATOS DE LA AZAFATA */

    public static final String TABLE_NAME_AZAFATA = "azafata";
    public static final String CN_DNI = "DNI";
    public static final String CN_NOMBRE = "Nombre de la Azafata";
    public static final String CN_CENTRO = "Centro del evento";
    public static final String CN_RECOGIDA = "Dia del Evento";

    public static final String CREATE_TABLE_AZAFATA =  "create table " +TABLE_NAME_AZAFATA+ " ("
            + CN_DNI + " text primary key,"
            + CN_NOMBRE + " text not null,"
            + CN_CENTRO + " text not null,"
            + CN_RECOGIDA + " text);";

    /* TABLA DE PREGUNTAS SI O NO */

    public static final String TABLE_NAME_SINO = "sino";
    public static final String CN_ID_SINO = "_id";
    public static final String CN_PREGUNTAS_SINO = "Preguntas";
    public static final String CN_SI = "Respuesta SI";
    public static final String CN_NO = "Respuesta NO";

    public static final String CREATE_TABLE_SINO =  "create table " +TABLE_NAME_SINO+ " ("
            + CN_ID_SINO + " integer primary key autoincrement,"
            + CN_PREGUNTAS_SINO + " text not null,"
            + CN_SI + " text not null,"
            + CN_NO + " integer);";

    /* TABLA ESTADISTICAS PARA VOLCADO DE DATOS */

    public static final String TABLE_NAME_ESTADISTICAS = "estadisticas";
    public static final String CN_ID_ESTADISTICAS = "_id";
    public static final String CN_PREGUNTAS_STATS = "Preguntas";
    public static final String CN_PORCENTAJE_MUCHO = "% Mucho";
    public static final String CN_PORCENTAJE_POCO = "% Poco";
    public static final String CN_PORCENTAJE_NADA = "% Nada";

    public static final String CREATE_TABLE_ESTADISTICAS =  "create table " +TABLE_NAME_ESTADISTICAS+ " ("
            + CN_ID_ESTADISTICAS + " integer primary key autoincrement,"
            + CN_PREGUNTAS_STATS + " text not null,"
            + CN_PORCENTAJE_MUCHO + " float,"
            + CN_PORCENTAJE_POCO + " float,"
            + CN_PORCENTAJE_NADA + " float);";


    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();

    }

    private ContentValues valuesGeneratorZumos (String nombreZumo, int cantidad){
        ContentValues values = new ContentValues();
        values.put(CN_BOTELLAS, nombreZumo);
        values.put(CN_NUMERO, cantidad);
        return values;
    }

    public void insertarZumos(String nombreZumo, int numeroZumos){
        db.insert(TABLE_NAME_ZUMOS, null, valuesGeneratorZumos(nombreZumo, numeroZumos)); /* esto devuelve 0 si correcto y -1 si error*/
        //db.execSQL("insert into "+TABLE_NAME_ZUMOS+" values (null,'"+nombreZumo+"',"+numeroZumos+")");
    }

    public void eliminar (String nombreZumo){
        db.delete(TABLE_NAME_ZUMOS, CN_BOTELLAS + "=?", new String[]{nombreZumo});
    }

    public void modificarCantidad(String nombreZumo, int nuevaCantidad){
        db.update(TABLE_NAME_ZUMOS, valuesGeneratorZumos(nombreZumo, nuevaCantidad), CN_BOTELLAS + "=?", new String[]{nombreZumo});
    }

    public Cursor cargarCursorBotellas(){
        String[] columnas = new String[]{CN_NUMERO};
        return db.query(TABLE_NAME_ZUMOS, columnas, null, null, null, null, null);
        // a lo mejor aqui con sacar solo la columna numero me dejaria volcarlo en un texto

    }

    public Cursor buscarCantidadZumo(String nombreZumo){
        String[] columnas = new String[]{CN_NUMERO};
        return db.query(TABLE_NAME_ZUMOS, columnas, CN_BOTELLAS + "=?", new String[]{nombreZumo}, null, null, null);
    }
}
