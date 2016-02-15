package com.example.bahia.practicum;


public class DataBaseManagerBotellas {
    public static final String TABLE_NAME = "botellas";
    public static final String CN_ID = "_id";
    public static final String CN_BOTELLAS = "Tipo de botella";
    public static final String CN_NUMERO = "Numero de botellas";

    public static final String CREATE_TABLE =  "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_BOTELLAS + " text not null,"
            + CN_NUMERO + " integer) ;";
}
