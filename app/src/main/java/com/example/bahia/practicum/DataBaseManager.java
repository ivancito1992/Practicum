package com.example.bahia.practicum;


public class DataBaseManager{
    public static final String TABLE_NAME = "datos";
    public static final String CN_ID = "_id";
    public static final String CN_PREGUNTAS = "Preguntas";
    public static final String CN_MUCHO = "Mucho";
    public static final String CN_POCO = "Poco";
    public static final String CN_NADA = "Nada";

    public static final String CREATE_TABLE =  "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_PREGUNTAS + " text not null,"
            + CN_MUCHO + " integer,"
            + CN_POCO + " integer,"
            + CN_NADA + " integer) ;";
}
