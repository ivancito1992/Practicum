package com.example.bahia.practicum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Zumosol extends AppCompatActivity implements View.OnClickListener {

    int contadorClasico, contadorAntiox, contadorOrganico, contadorPrisma, contadorRojo, contadorVerde, contadorNaranja = 0;

    int contadorMucho1, contadorMucho2, contadorMucho3, contadorMucho4, contadorMucho5, contadorMucho6, contadorMucho7,
            contadorMucho8, contadorMucho9, contadorMucho10, contadorMucho11 = 0;

    int contadorPoco1, contadorPoco2, contadorPoco3, contadorPoco4, contadorPoco5, contadorPoco6, contadorPoco7, contadorPoco8,
            contadorPoco9, contadorPoco10, contadorPoco11 = 0;

    int contadorNada1, contadorNada2, contadorNada3, contadorNada4, contadorNada5, contadorNada6, contadorNada7, contadorNada8,
            contadorNada9, contadorNada10, contadorNada11 = 0;

    //float sMucho1, sMucho2, sMucho3, sMucho4, sMucho5, sMucho6, sMucho7, sMucho8, sMucho9, sMucho10, sMucho11;
    //float sPoco1, sPoco2, sPoco3, sPoco4, sPoco5, sPoco6, sPoco7, sPoco8, sPoco9, sPoco10, sPoco11;
    //float sNada1, sNada2, sNada3, sNada4, sNada5, sNada6, sNada7, sNada8, sNada9, sNada10, sNada11;

    Button sumadorClasico, sumadorAntiox, sumadorOrganico, sumadorPrisma, sumadorRojo, sumadorVerde, sumadorNaranja;
    Button restadorClasico, restadorAntiox, restadorOrganico, restadorPrisma, restadorRojo, restadorVerde, restadorNaranja;

    Button sumMucho1,sumMucho2,sumMucho3,sumMucho4,sumMucho5,sumMucho6,sumMucho7,sumMucho8,sumMucho9,sumMucho10,sumMucho11;
    Button resMucho1,resMucho2,resMucho3,resMucho4,resMucho5,resMucho6,resMucho7,resMucho8,resMucho9,resMucho10,resMucho11;

    Button sumPoco1,sumPoco2,sumPoco3,sumPoco4,sumPoco5,sumPoco6,sumPoco7,sumPoco8,sumPoco9,sumPoco10,sumPoco11;
    Button resPoco1,resPoco2,resPoco3,resPoco4,resPoco5,resPoco6,resPoco7,resPoco8,resPoco9,resPoco10,resPoco11;

    Button sumNada1,sumNada2,sumNada3,sumNada4,sumNada5,sumNada6,sumNada7,sumNada8,sumNada9,sumNada10,sumNada11;
    Button resNada1,resNada2,resNada3,resNada4,resNada5,resNada6,resNada7,resNada8,resNada9,resNada10,resNada11;

    TextView cantidadClasico, cantidadAntiox, cantidadOrganico, cantidadPrisma, cantidadRojo, cantidadVerde, cantidadNaranja;
    TextView cantidadMucho1, cantidadMucho2, cantidadMucho3, cantidadMucho4, cantidadMucho5, cantidadMucho6, cantidadMucho7, cantidadMucho8, cantidadMucho9, cantidadMucho10, cantidadMucho11;
    TextView cantidadPoco1, cantidadPoco2, cantidadPoco3, cantidadPoco4, cantidadPoco5, cantidadPoco6, cantidadPoco7, cantidadPoco8, cantidadPoco9, cantidadPoco10, cantidadPoco11;
    TextView cantidadNada1, cantidadNada2, cantidadNada3, cantidadNada4, cantidadNada5, cantidadNada6, cantidadNada7, cantidadNada8, cantidadNada9, cantidadNada10, cantidadNada11;

    TextView nombreClasico, nombreAntiox, nombreOrganico, nombrePrisma, nombreRojo, nombreVerde, nombreNaranja;
    String clasico, antiox, organico, prisma, rojo, verde, naranja;
    TextView pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10, pregunta11, preguntaSN1, preguntaSN2, preguntaSN3;
    String preg1, preg2, preg3, preg4, preg5, preg6, preg7, preg8, preg9, preg10, preg11, pregSiNo1, pregSiNo2, pregSiNo3;

    RadioButton si1, si2, si3, no1, no2, no3;

    EditText azafata, centro, dia;
    String nombreAzafata, nombreCentro, diaRecogida;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zumosol);



        /* BOTONES PARA AUMENTAR EL CONTADOR DE ZUMOS */

        sumadorClasico = (Button) findViewById(R.id.sumClasico);
        sumadorClasico.setOnClickListener(this);
        sumadorAntiox = (Button) findViewById(R.id.sumAntiox);
        sumadorAntiox.setOnClickListener(this);
        sumadorOrganico = (Button) findViewById(R.id.sumOrganico);
        sumadorOrganico.setOnClickListener(this);
        sumadorPrisma = (Button) findViewById(R.id.sumPrisma);
        sumadorPrisma.setOnClickListener(this);
        sumadorRojo = (Button) findViewById(R.id.sumRojo);
        sumadorRojo.setOnClickListener(this);
        sumadorVerde = (Button) findViewById(R.id.sumVerde);
        sumadorVerde.setOnClickListener(this);
        sumadorNaranja = (Button) findViewById(R.id.sumNaranja);
        sumadorNaranja.setOnClickListener(this);

        /* BOTONOES PARA DECREMENTAR EL CONTADOR DE ZUMOS */

        restadorClasico = (Button) findViewById(R.id.resClasico);
        restadorClasico.setOnClickListener(this);
        restadorAntiox = (Button) findViewById(R.id.resAntiox);
        restadorAntiox.setOnClickListener(this);
        restadorOrganico = (Button) findViewById(R.id.resOrganico);
        restadorOrganico.setOnClickListener(this);
        restadorPrisma = (Button) findViewById(R.id.resPrisma);
        restadorPrisma.setOnClickListener(this);
        restadorRojo = (Button) findViewById(R.id.resRojo);
        restadorRojo.setOnClickListener(this);
        restadorVerde = (Button) findViewById(R.id.resVerde);
        restadorVerde.setOnClickListener(this);
        restadorNaranja = (Button) findViewById(R.id.resNaranja);
        restadorNaranja.setOnClickListener(this);

        /* BOTONES PARA AUMENTAR EL CONTADOR MUCHO DE LAS PREGUNTAS */

        sumMucho1 = (Button) findViewById(R.id.sumadorMuchoPregunta1);
        sumMucho1.setOnClickListener(this);
        sumMucho2 = (Button) findViewById(R.id.sumadorMuchoPregunta2);
        sumMucho2.setOnClickListener(this);
        sumMucho3 = (Button) findViewById(R.id.sumadorMuchoPregunta3);
        sumMucho3.setOnClickListener(this);
        sumMucho4 = (Button) findViewById(R.id.sumadorMuchoPregunta4);
        sumMucho4.setOnClickListener(this);
        sumMucho5 = (Button) findViewById(R.id.sumadorMuchoPregunta5);
        sumMucho5.setOnClickListener(this);
        sumMucho6 = (Button) findViewById(R.id.sumadorMuchoPregunta6);
        sumMucho6.setOnClickListener(this);
        sumMucho7 = (Button) findViewById(R.id.sumadorMuchoPregunta7);
        sumMucho7.setOnClickListener(this);
        sumMucho8 = (Button) findViewById(R.id.sumadorMuchoPregunta8);
        sumMucho8.setOnClickListener(this);
        sumMucho9 = (Button) findViewById(R.id.sumadorMuchoPregunta9);
        sumMucho9.setOnClickListener(this);
        sumMucho10 = (Button) findViewById(R.id.sumadorMuchoPregunta10);
        sumMucho10.setOnClickListener(this);
        sumMucho11 = (Button) findViewById(R.id.sumadorMuchoPregunta11);
        sumMucho11.setOnClickListener(this);

        /* BOTONES PARA DECREMENTAR EL CONTADOR MUCHO DE LAS PREGUNTAS */

        resMucho1 = (Button) findViewById(R.id.restadorMuchoPregunta1);
        resMucho1.setOnClickListener(this);
        resMucho2 = (Button) findViewById(R.id.restadorMuchoPregunta2);
        resMucho2.setOnClickListener(this);
        resMucho3 = (Button) findViewById(R.id.restadorMuchoPregunta3);
        resMucho3.setOnClickListener(this);
        resMucho4 = (Button) findViewById(R.id.restadorMuchoPregunta4);
        resMucho4.setOnClickListener(this);
        resMucho5 = (Button) findViewById(R.id.restadorMuchoPregunta5);
        resMucho5.setOnClickListener(this);
        resMucho6 = (Button) findViewById(R.id.restadorMuchoPregunta6);
        resMucho6.setOnClickListener(this);
        resMucho7 = (Button) findViewById(R.id.restadorMuchoPregunta7);
        resMucho7.setOnClickListener(this);
        resMucho8 = (Button) findViewById(R.id.restadorMuchoPregunta8);
        resMucho8.setOnClickListener(this);
        resMucho9 = (Button) findViewById(R.id.restadorMuchoPregunta9);
        resMucho9.setOnClickListener(this);
        resMucho10 = (Button) findViewById(R.id.restadorMuchoPregunta10);
        resMucho10.setOnClickListener(this);
        resMucho11 = (Button) findViewById(R.id.restadorMuchoPregunta11);
        resMucho11.setOnClickListener(this);

        /* BOTONES PARA AUMENTAR EL CONTADOR POCO DE LAS PREGUNTAS */

        sumPoco1 = (Button) findViewById(R.id.sumadorPocoPregunta1);
        sumPoco1.setOnClickListener(this);
        sumPoco2 = (Button) findViewById(R.id.sumadorPocoPregunta2);
        sumPoco2.setOnClickListener(this);
        sumPoco3 = (Button) findViewById(R.id.sumadorPocoPregunta3);
        sumPoco3.setOnClickListener(this);
        sumPoco4 = (Button) findViewById(R.id.sumadorPocoPregunta4);
        sumPoco4.setOnClickListener(this);
        sumPoco5 = (Button) findViewById(R.id.sumadorPocoPregunta5);
        sumPoco5.setOnClickListener(this);
        sumPoco6 = (Button) findViewById(R.id.sumadorPocoPregunta6);
        sumPoco6.setOnClickListener(this);
        sumPoco7 = (Button) findViewById(R.id.sumadorPocoPregunta7);
        sumPoco7.setOnClickListener(this);
        sumPoco8 = (Button) findViewById(R.id.sumadorPocoPregunta8);
        sumPoco8.setOnClickListener(this);
        sumPoco9 = (Button) findViewById(R.id.sumadorPocoPregunta9);
        sumPoco9.setOnClickListener(this);
        sumPoco10 = (Button) findViewById(R.id.sumadorPocoPregunta10);
        sumPoco10.setOnClickListener(this);
        sumPoco11 = (Button) findViewById(R.id.sumadorPocoPregunta11);
        sumPoco11.setOnClickListener(this);

        /* BOTONES PARA DECREMENTAR EL CONTADOR POCO DE LAS PREGUNTAS */

        resPoco1 = (Button) findViewById(R.id.restadorPocoPregunta1);
        resPoco1.setOnClickListener(this);
        resPoco2 = (Button) findViewById(R.id.restadorPocoPregunta2);
        resPoco2.setOnClickListener(this);
        resPoco3 = (Button) findViewById(R.id.restadorPocoPregunta3);
        resPoco3.setOnClickListener(this);
        resPoco4 = (Button) findViewById(R.id.restadorPocoPregunta4);
        resPoco4.setOnClickListener(this);
        resPoco5 = (Button) findViewById(R.id.restadorPocoPregunta5);
        resPoco5.setOnClickListener(this);
        resPoco6 = (Button) findViewById(R.id.restadorPocoPregunta6);
        resPoco6.setOnClickListener(this);
        resPoco7 = (Button) findViewById(R.id.restadorPocoPregunta7);
        resPoco7.setOnClickListener(this);
        resPoco8 = (Button) findViewById(R.id.restadorPocoPregunta8);
        resPoco8.setOnClickListener(this);
        resPoco9 = (Button) findViewById(R.id.restadorPocoPregunta9);
        resPoco9.setOnClickListener(this);
        resPoco10 = (Button) findViewById(R.id.restadorPocoPregunta10);
        resPoco10.setOnClickListener(this);
        resPoco11 = (Button) findViewById(R.id.restadorPocoPregunta11);
        resPoco11.setOnClickListener(this);

        /* BOTONES PARA AUMENTAR EL CONTADOR NADA DE LAS PREGUNTAS */

        sumNada1 = (Button) findViewById(R.id.sumadorNadaPregunta1);
        sumNada1.setOnClickListener(this);
        sumNada2 = (Button) findViewById(R.id.sumadorNadaPregunta2);
        sumNada2.setOnClickListener(this);
        sumNada3 = (Button) findViewById(R.id.sumadorNadaPregunta3);
        sumNada3.setOnClickListener(this);
        sumNada4 = (Button) findViewById(R.id.sumadorNadaPregunta4);
        sumNada4.setOnClickListener(this);
        sumNada5 = (Button) findViewById(R.id.sumadorNadaPregunta5);
        sumNada5.setOnClickListener(this);
        sumNada6 = (Button) findViewById(R.id.sumadorNadaPregunta6);
        sumNada6.setOnClickListener(this);
        sumNada7 = (Button) findViewById(R.id.sumadorNadaPregunta7);
        sumNada7.setOnClickListener(this);
        sumNada8 = (Button) findViewById(R.id.sumadorNadaPregunta8);
        sumNada8.setOnClickListener(this);
        sumNada9 = (Button) findViewById(R.id.sumadorNadaPregunta9);
        sumNada9.setOnClickListener(this);
        sumNada10 = (Button) findViewById(R.id.sumadorNadaPregunta10);
        sumNada10.setOnClickListener(this);
        sumNada11 = (Button) findViewById(R.id.sumadorNadaPregunta11);
        sumNada11.setOnClickListener(this);

        /* BOTONES PARA DECREMENTAR EL CONTADOR NADA DE LAS PREGUNTAS */

        resNada1 = (Button) findViewById(R.id.restadorNadaPregunta1);
        resNada1.setOnClickListener(this);
        resNada2 = (Button) findViewById(R.id.restadorNadaPregunta2);
        resNada2.setOnClickListener(this);
        resNada3 = (Button) findViewById(R.id.restadorNadaPregunta3);
        resNada3.setOnClickListener(this);
        resNada4 = (Button) findViewById(R.id.restadorNadaPregunta4);
        resNada4.setOnClickListener(this);
        resNada5 = (Button) findViewById(R.id.restadorNadaPregunta5);
        resNada5.setOnClickListener(this);
        resNada6 = (Button) findViewById(R.id.restadorNadaPregunta6);
        resNada6.setOnClickListener(this);
        resNada7 = (Button) findViewById(R.id.restadorNadaPregunta7);
        resNada7.setOnClickListener(this);
        resNada8 = (Button) findViewById(R.id.restadorNadaPregunta8);
        resNada8.setOnClickListener(this);
        resNada9 = (Button) findViewById(R.id.restadorNadaPregunta9);
        resNada9.setOnClickListener(this);
        resNada10 = (Button) findViewById(R.id.restadorNadaPregunta10);
        resNada10.setOnClickListener(this);
        resNada11 = (Button) findViewById(R.id.restadorNadaPregunta11);
        resNada11.setOnClickListener(this);

        /*INICIALIZAR EL TEXTVIEW CON LOS CONTADORES A 0*/

        cantidadClasico = (TextView) findViewById(R.id.cantidadClasico);
        cantidadAntiox = (TextView) findViewById(R.id.cantidadAntiox);
        cantidadOrganico = (TextView) findViewById(R.id.cantidadOrganico);
        cantidadPrisma = (TextView) findViewById(R.id.cantidadPrisma);
        cantidadRojo = (TextView) findViewById(R.id.cantidadRojo);
        cantidadVerde = (TextView) findViewById(R.id.cantidadVerde);
        cantidadNaranja = (TextView) findViewById(R.id.cantidadNaranja);
        cantidadMucho1 = (TextView) findViewById(R.id.contadorMuchoPregunta1);
        cantidadMucho2 = (TextView) findViewById(R.id.contadorMuchoPregunta2);
        cantidadMucho3 = (TextView) findViewById(R.id.contadorMuchoPregunta3);
        cantidadMucho4 = (TextView) findViewById(R.id.contadorMuchoPregunta4);
        cantidadMucho5 = (TextView) findViewById(R.id.contadorMuchoPregunta5);
        cantidadMucho6 = (TextView) findViewById(R.id.contadorMuchoPregunta6);
        cantidadMucho7 = (TextView) findViewById(R.id.contadorMuchoPregunta7);
        cantidadMucho8 = (TextView) findViewById(R.id.contadorMuchoPregunta8);
        cantidadMucho9 = (TextView) findViewById(R.id.contadorMuchoPregunta9);
        cantidadMucho10 = (TextView) findViewById(R.id.contadorMuchoPregunta10);
        cantidadMucho11 = (TextView) findViewById(R.id.contadorMuchoPregunta11);
        cantidadPoco1 = (TextView) findViewById(R.id.contadorPocoPregunta1);
        cantidadPoco2 = (TextView) findViewById(R.id.contadorPocoPregunta2);
        cantidadPoco3 = (TextView) findViewById(R.id.contadorPocoPregunta3);
        cantidadPoco4 = (TextView) findViewById(R.id.contadorPocoPregunta4);
        cantidadPoco5 = (TextView) findViewById(R.id.contadorPocoPregunta5);
        cantidadPoco6 = (TextView) findViewById(R.id.contadorPocoPregunta6);
        cantidadPoco7 = (TextView) findViewById(R.id.contadorPocoPregunta7);
        cantidadPoco8 = (TextView) findViewById(R.id.contadorPocoPregunta8);
        cantidadPoco9 = (TextView) findViewById(R.id.contadorPocoPregunta9);
        cantidadPoco10 = (TextView) findViewById(R.id.contadorPocoPregunta10);
        cantidadPoco11 = (TextView) findViewById(R.id.contadorPocoPregunta11);
        cantidadNada1 = (TextView) findViewById(R.id.contadorNadaPregunta1);
        cantidadNada2 = (TextView) findViewById(R.id.contadorNadaPregunta2);
        cantidadNada3 = (TextView) findViewById(R.id.contadorNadaPregunta3);
        cantidadNada4 = (TextView) findViewById(R.id.contadorNadaPregunta4);
        cantidadNada5 = (TextView) findViewById(R.id.contadorNadaPregunta5);
        cantidadNada6 = (TextView) findViewById(R.id.contadorNadaPregunta6);
        cantidadNada7 = (TextView) findViewById(R.id.contadorNadaPregunta7);
        cantidadNada8 = (TextView) findViewById(R.id.contadorNadaPregunta8);
        cantidadNada9 = (TextView) findViewById(R.id.contadorNadaPregunta9);
        cantidadNada10 = (TextView) findViewById(R.id.contadorNadaPregunta10);
        cantidadNada11 = (TextView) findViewById(R.id.contadorNadaPregunta11);

        /* CARGAR EL TEXTO DE LOS ZUMOS */

        nombreClasico = (TextView) findViewById(R.id.nombreClasico);
        clasico = nombreClasico.getText().toString();
        nombreAntiox = (TextView) findViewById(R.id.nombreAntiox);
        antiox = nombreAntiox.getText().toString();
        nombreOrganico = (TextView) findViewById(R.id.nombreOrganico);
        organico = nombreOrganico.getText().toString();
        nombrePrisma = (TextView) findViewById(R.id.nombrePrisma);
        prisma = nombrePrisma.getText().toString();
        nombreRojo = (TextView) findViewById(R.id.nombreRojo);
        rojo = nombreRojo.getText().toString();
        nombreVerde = (TextView) findViewById(R.id.nombreVerde);
        verde = nombreVerde.getText().toString();
        nombreNaranja = (TextView) findViewById(R.id.nombreNaranja);
        naranja = nombreNaranja.getText().toString();

        /* CARGAR EL TEXTO DE LAS PREGUNTAS */

        pregunta1 = (TextView) findViewById(R.id.pregunta1);
        preg1 = pregunta1.getText().toString();
        pregunta2 = (TextView) findViewById(R.id.pregunta2);
        preg2 = pregunta2.getText().toString();
        pregunta3 = (TextView) findViewById(R.id.pregunta3);
        preg3 = pregunta3.getText().toString();
        pregunta4 = (TextView) findViewById(R.id.pregunta4);
        preg4 = pregunta4.getText().toString();
        pregunta5 = (TextView) findViewById(R.id.pregunta5);
        preg5 = pregunta5.getText().toString();
        pregunta6 = (TextView) findViewById(R.id.pregunta6);
        preg6 = pregunta6.getText().toString();
        pregunta7 = (TextView) findViewById(R.id.pregunta7);
        preg7 = pregunta7.getText().toString();
        pregunta8 = (TextView) findViewById(R.id.pregunta8);
        preg8 = pregunta8.getText().toString();
        pregunta9 = (TextView) findViewById(R.id.pregunta9);
        preg9 = pregunta9.getText().toString();
        pregunta10 = (TextView) findViewById(R.id.pregunta10);
        preg10 = pregunta10.getText().toString();
        pregunta11 = (TextView) findViewById(R.id.pregunta11);
        preg11 = pregunta11.getText().toString();
        preguntaSN1 = (TextView) findViewById(R.id.preguntaSiNo1);
        pregSiNo1 = preguntaSN1.getText().toString();
        preguntaSN2 = (TextView) findViewById(R.id.preguntaSiNo2);
        pregSiNo2 = preguntaSN2.getText().toString();
        preguntaSN3 = (TextView) findViewById(R.id.preguntaSiNo3);
        pregSiNo3 = preguntaSN3.getText().toString();

        /* CARGAR EL ID DE LOS RADIOBUTTONS */

        si1 = (RadioButton) findViewById(R.id.SI1);
        si2 = (RadioButton) findViewById(R.id.SI2);
        si3 = (RadioButton) findViewById(R.id.SI3);
        no1 = (RadioButton) findViewById(R.id.NO1);
        no2 = (RadioButton) findViewById(R.id.NO2);
        no3 = (RadioButton) findViewById(R.id.NO3);

        /* CARGAR DATOS DE LA AZAFATA Y DEL CENTRO */

        azafata = (EditText) findViewById(R.id.azafata);
        centro = (EditText) findViewById(R.id.centro);
        dia = (EditText) findViewById(R.id.dia);

        Button guardar = (Button) findViewById(R.id.guardarEnDB);
        guardar.setOnClickListener(this);

    }





    @Override
    public void onClick(View v) {
        DBManager manager = new DBManager(this);

        if (v.getId()==R.id.guardarEnDB){
            /* INSERT DE LAS PREGUNTAS GENERALES */
            manager.insertarPreguntasGenerales(preg1, contadorMucho1, contadorPoco1, contadorNada1);
            manager.insertarPreguntasGenerales(preg2, contadorMucho2, contadorPoco2, contadorNada2);
            manager.insertarPreguntasGenerales(preg3, contadorMucho3, contadorPoco3, contadorNada3);
            manager.insertarPreguntasGenerales(preg4, contadorMucho4, contadorPoco4, contadorNada4);
            manager.insertarPreguntasGenerales(preg5, contadorMucho5, contadorPoco5, contadorNada5);
            manager.insertarPreguntasGenerales(preg6, contadorMucho6, contadorPoco6, contadorNada6);
            manager.insertarPreguntasGenerales(preg7, contadorMucho7, contadorPoco7, contadorNada7);
            manager.insertarPreguntasGenerales(preg8, contadorMucho8, contadorPoco8, contadorNada8);
            manager.insertarPreguntasGenerales(preg9, contadorMucho9, contadorPoco9, contadorNada9);
            manager.insertarPreguntasGenerales(preg10, contadorMucho10, contadorPoco10, contadorNada10);
            manager.insertarPreguntasGenerales(preg11, contadorMucho11, contadorPoco11, contadorNada11);
                /* INSERT DE LOS ZUMOS */
            manager.insertarZumos(clasico, contadorClasico);
            manager.insertarZumos(antiox, contadorAntiox);
            manager.insertarZumos(organico, contadorOrganico);
            manager.insertarZumos(prisma, contadorPrisma);
            manager.insertarZumos(rojo, contadorRojo);
            manager.insertarZumos(verde, contadorVerde);
            manager.insertarZumos(naranja, contadorNaranja);
                /* INSERT DE LAS PREGUNTAS SI O NO */
            if(si1.isChecked()){
                manager.insertarPreguntasSiNo(pregSiNo1,1,0);
            }
            else{
                manager.insertarPreguntasSiNo(pregSiNo1,0,1);
            }
            if(si2.isChecked()){
                manager.insertarPreguntasSiNo(pregSiNo2,1,0);
            }
            else{
                manager.insertarPreguntasSiNo(pregSiNo2,0,1);
            }
            if(si2.isChecked()){
                manager.insertarPreguntasSiNo(pregSiNo3,1,0);
            }
            else{
                manager.insertarPreguntasSiNo(pregSiNo3,0,1);
            }
                /* INSERT DE LOS DATOS DE LA AZAFATA */
            nombreAzafata = azafata.getText().toString();
            nombreCentro = centro.getText().toString();
            diaRecogida = dia.getText().toString();
            manager.insertarDatosAzafata(nombreAzafata, nombreCentro, diaRecogida);
                /* MOVER A LA SIGUIENTE VISTA */
            try {
                DB_Backup();
            } catch (IOException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(Zumosol.this, FinalizarApp.class));
            finish();
        }
        else {
            switch (v.getId()) {

            /* SUMAR CANTIDAD ZUMOS */
                case R.id.sumClasico:
                    contadorClasico++;
                    cantidadClasico.setText(Integer.toString(contadorClasico));
                    break;
                case R.id.sumAntiox:
                    contadorAntiox++;
                    cantidadAntiox.setText(Integer.toString(contadorAntiox));
                    break;
                case R.id.sumOrganico:
                    contadorOrganico++;
                    cantidadOrganico.setText(Integer.toString(contadorOrganico));
                    break;
                case R.id.sumPrisma:
                    contadorPrisma++;
                    cantidadPrisma.setText(Integer.toString(contadorPrisma));
                    break;
                case R.id.sumRojo:
                    contadorRojo++;
                    cantidadRojo.setText(Integer.toString(contadorRojo));
                    break;
                case R.id.sumVerde:
                    contadorVerde++;
                    cantidadVerde.setText(Integer.toString(contadorVerde));
                    break;
                case R.id.sumNaranja:
                    contadorNaranja++;
                    cantidadNaranja.setText(Integer.toString(contadorNaranja));
                    break;

            /* RESTAR CANTIDAD DE ZUMOS */
                case R.id.resClasico:
                    if (contadorClasico > 0) {
                        contadorClasico--;
                        cantidadClasico.setText(Integer.toString(contadorClasico));
                    }
                    break;
                case R.id.resAntiox:
                    if (contadorAntiox > 0) {
                        contadorAntiox--;
                        cantidadAntiox.setText(Integer.toString(contadorAntiox));
                    }
                    break;
                case R.id.resOrganico:
                    if (contadorOrganico > 0) {
                        contadorOrganico--;
                        cantidadOrganico.setText(Integer.toString(contadorOrganico));
                    }
                    break;
                case R.id.resPrisma:
                    if (contadorPrisma > 0) {
                        contadorPrisma--;
                        cantidadPrisma.setText(Integer.toString(contadorPrisma));
                    }
                    break;
                case R.id.resRojo:
                    if (contadorRojo > 0) {
                        contadorRojo--;
                        cantidadRojo.setText(Integer.toString(contadorRojo));
                    }
                    break;
                case R.id.resVerde:
                    if (contadorVerde > 0) {
                        contadorVerde--;
                        cantidadVerde.setText(Integer.toString(contadorVerde));
                    }
                    break;
                case R.id.resNaranja:
                    if (contadorNaranja > 0) {
                        contadorNaranja--;
                        cantidadNaranja.setText(Integer.toString(contadorNaranja));
                    }
                    break;

            /* SUMA CANTIDAD A MUCHOS DE PREGUNTAS */
                case R.id.sumadorMuchoPregunta1:
                    contadorMucho1++;
                    cantidadMucho1.setText(Integer.toString(contadorMucho1));
                    break;
                case R.id.sumadorMuchoPregunta2:
                    contadorMucho2++;
                    cantidadMucho2.setText(Integer.toString(contadorMucho2));
                    break;
                case R.id.sumadorMuchoPregunta3:
                    contadorMucho3++;
                    cantidadMucho3.setText(Integer.toString(contadorMucho3));
                    break;
                case R.id.sumadorMuchoPregunta4:
                    contadorMucho4++;
                    cantidadMucho4.setText(Integer.toString(contadorMucho4));
                    break;
                case R.id.sumadorMuchoPregunta5:
                    contadorMucho5++;
                    cantidadMucho5.setText(Integer.toString(contadorMucho5));
                    break;
                case R.id.sumadorMuchoPregunta6:
                    contadorMucho6++;
                    cantidadMucho6.setText(Integer.toString(contadorMucho6));
                    break;
                case R.id.sumadorMuchoPregunta7:
                    contadorMucho7++;
                    cantidadMucho7.setText(Integer.toString(contadorMucho7));
                    break;
                case R.id.sumadorMuchoPregunta8:
                    contadorMucho8++;
                    cantidadMucho8.setText(Integer.toString(contadorMucho8));
                    break;
                case R.id.sumadorMuchoPregunta9:
                    contadorMucho9++;
                    cantidadMucho9.setText(Integer.toString(contadorMucho9));
                    break;
                case R.id.sumadorMuchoPregunta10:
                    contadorMucho10++;
                    cantidadMucho10.setText(Integer.toString(contadorMucho10));
                    break;
                case R.id.sumadorMuchoPregunta11:
                    contadorMucho11++;
                    cantidadMucho11.setText(Integer.toString(contadorMucho11));
                    break;

            /* RESTA CANTIDAD A MUCHOS DE PREGUNTAS */
                case R.id.restadorMuchoPregunta1:
                    if (contadorMucho1 > 0) {
                        contadorMucho1--;
                        cantidadMucho1.setText(Integer.toString(contadorMucho1));
                    }
                    break;
                case R.id.restadorMuchoPregunta2:
                    if (contadorMucho2 > 0) {
                        contadorMucho2--;
                        cantidadMucho2.setText(Integer.toString(contadorMucho2));
                    }
                    break;
                case R.id.restadorMuchoPregunta3:
                    if (contadorMucho3 > 0) {
                        contadorMucho3--;
                        cantidadMucho3.setText(Integer.toString(contadorMucho3));
                    }
                    break;
                case R.id.restadorMuchoPregunta4:
                    if (contadorMucho4 > 0) {
                        contadorMucho4--;
                        cantidadMucho4.setText(Integer.toString(contadorMucho4));
                    }
                    break;
                case R.id.restadorMuchoPregunta5:
                    if (contadorMucho5 > 0) {
                        contadorMucho5--;
                        cantidadMucho5.setText(Integer.toString(contadorMucho5));
                    }
                    break;
                case R.id.restadorMuchoPregunta6:
                    if (contadorMucho6 > 0) {
                        contadorMucho6--;
                        cantidadMucho6.setText(Integer.toString(contadorMucho6));
                    }
                    break;
                case R.id.restadorMuchoPregunta7:
                    if (contadorMucho7 > 0) {
                        contadorMucho7--;
                        cantidadMucho7.setText(Integer.toString(contadorMucho7));
                    }
                    break;
                case R.id.restadorMuchoPregunta8:
                    if (contadorMucho8 > 0) {
                        contadorMucho8--;
                        cantidadMucho8.setText(Integer.toString(contadorMucho8));
                    }
                    break;
                case R.id.restadorMuchoPregunta9:
                    if (contadorMucho9 > 0) {
                        contadorMucho9--;
                        cantidadMucho9.setText(Integer.toString(contadorMucho9));
                    }
                    break;
                case R.id.restadorMuchoPregunta10:
                    if (contadorMucho10 > 0) {
                        contadorMucho10--;
                        cantidadMucho10.setText(Integer.toString(contadorMucho10));
                    }
                    break;
                case R.id.restadorMuchoPregunta11:
                    if (contadorMucho11 > 0) {
                        contadorMucho11--;
                        cantidadMucho11.setText(Integer.toString(contadorMucho11));
                    }
                    break;

            /* SUMA CANTIDAD A POCOS DE PREGUNTAS */
                case R.id.sumadorPocoPregunta1:
                    contadorPoco1++;
                    cantidadPoco1.setText(Integer.toString(contadorPoco1));
                    break;
                case R.id.sumadorPocoPregunta2:
                    contadorPoco2++;
                    cantidadPoco2.setText(Integer.toString(contadorPoco2));
                    break;
                case R.id.sumadorPocoPregunta3:
                    contadorPoco3++;
                    cantidadPoco3.setText(Integer.toString(contadorPoco3));
                    break;
                case R.id.sumadorPocoPregunta4:
                    contadorPoco4++;
                    cantidadPoco4.setText(Integer.toString(contadorPoco4));
                    break;
                case R.id.sumadorPocoPregunta5:
                    contadorPoco5++;
                    cantidadPoco5.setText(Integer.toString(contadorPoco5));
                    break;
                case R.id.sumadorPocoPregunta6:
                    contadorPoco6++;
                    cantidadPoco6.setText(Integer.toString(contadorPoco6));
                    break;
                case R.id.sumadorPocoPregunta7:
                    contadorPoco7++;
                    cantidadPoco7.setText(Integer.toString(contadorPoco7));
                    break;
                case R.id.sumadorPocoPregunta8:
                    contadorPoco8++;
                    cantidadPoco8.setText(Integer.toString(contadorPoco8));
                    break;
                case R.id.sumadorPocoPregunta9:
                    contadorPoco9++;
                    cantidadPoco9.setText(Integer.toString(contadorPoco9));
                    break;
                case R.id.sumadorPocoPregunta10:
                    contadorPoco10++;
                    cantidadPoco10.setText(Integer.toString(contadorPoco10));
                    break;
                case R.id.sumadorPocoPregunta11:
                    contadorPoco11++;
                    cantidadPoco11.setText(Integer.toString(contadorPoco11));
                    break;

            /* RESTA CANTIDAD A POCOS DE PREGUNTAS */
                case R.id.restadorPocoPregunta1:
                    if (contadorPoco1 > 0) {
                        contadorPoco1--;
                        cantidadPoco1.setText(Integer.toString(contadorPoco1));
                    }
                    break;
                case R.id.restadorPocoPregunta2:
                    if (contadorPoco2 > 0) {
                        contadorPoco2--;
                        cantidadPoco2.setText(Integer.toString(contadorPoco2));
                    }
                    break;
                case R.id.restadorPocoPregunta3:
                    if (contadorPoco3 > 0) {
                        contadorPoco3--;
                        cantidadPoco3.setText(Integer.toString(contadorPoco3));
                    }
                case R.id.restadorPocoPregunta4:
                    if (contadorPoco4 > 0) {
                        contadorPoco4--;
                        cantidadPoco4.setText(Integer.toString(contadorPoco4));
                    }
                    break;
                case R.id.restadorPocoPregunta5:
                    if (contadorPoco5 > 0) {
                        contadorPoco5--;
                        cantidadPoco5.setText(Integer.toString(contadorPoco5));
                    }
                    break;
                case R.id.restadorPocoPregunta6:
                    if (contadorPoco6 > 0) {
                        contadorPoco6--;
                        cantidadPoco6.setText(Integer.toString(contadorPoco6));
                    }
                    break;
                case R.id.restadorPocoPregunta7:
                    if (contadorPoco7 > 0) {
                        contadorPoco7--;
                        cantidadPoco7.setText(Integer.toString(contadorPoco7));
                    }
                    break;
                case R.id.restadorPocoPregunta8:
                    if (contadorPoco8 > 0) {
                        contadorPoco8--;
                        cantidadPoco8.setText(Integer.toString(contadorPoco8));
                    }
                    break;
                case R.id.restadorPocoPregunta9:
                    if (contadorPoco9 > 0) {
                        contadorPoco9--;
                        cantidadPoco9.setText(Integer.toString(contadorPoco9));
                    }
                    break;
                case R.id.restadorPocoPregunta10:
                    if (contadorPoco10 > 0) {
                        contadorPoco10--;
                        cantidadPoco10.setText(Integer.toString(contadorPoco10));
                    }
                    break;
                case R.id.restadorPocoPregunta11:
                    if (contadorPoco11 > 0) {
                        contadorPoco11--;
                        cantidadPoco11.setText(Integer.toString(contadorPoco11));
                    }
                    break;

            /* SUMA CANTIDAD A NADA DE PREGUNTAS */
                case R.id.sumadorNadaPregunta1:
                    contadorNada1++;
                    cantidadNada1.setText(Integer.toString(contadorNada1));
                    break;
                case R.id.sumadorNadaPregunta2:
                    contadorNada2++;
                    cantidadNada2.setText(Integer.toString(contadorNada2));
                    break;
                case R.id.sumadorNadaPregunta3:
                    contadorNada3++;
                    cantidadNada3.setText(Integer.toString(contadorNada3));
                    break;
                case R.id.sumadorNadaPregunta4:
                    contadorNada4++;
                    cantidadNada4.setText(Integer.toString(contadorNada4));
                    break;
                case R.id.sumadorNadaPregunta5:
                    contadorNada5++;
                    cantidadNada5.setText(Integer.toString(contadorNada5));
                    break;
                case R.id.sumadorNadaPregunta6:
                    contadorNada6++;
                    cantidadNada6.setText(Integer.toString(contadorNada6));
                    break;
                case R.id.sumadorNadaPregunta7:
                    contadorNada7++;
                    cantidadNada7.setText(Integer.toString(contadorNada7));
                    break;
                case R.id.sumadorNadaPregunta8:
                    contadorNada8++;
                    cantidadNada8.setText(Integer.toString(contadorNada8));
                    break;
                case R.id.sumadorNadaPregunta9:
                    contadorNada9++;
                    cantidadNada9.setText(Integer.toString(contadorNada9));
                    break;
                case R.id.sumadorNadaPregunta10:
                    contadorNada10++;
                    cantidadNada10.setText(Integer.toString(contadorNada10));
                    break;
                case R.id.sumadorNadaPregunta11:
                    contadorNada11++;
                    cantidadNada11.setText(Integer.toString(contadorNada11));
                    break;

            /* RESTA CANTIDAD A POCOS DE PREGUNTAS */
                case R.id.restadorNadaPregunta1:
                    if (contadorNada1 > 0) {
                        contadorNada1--;
                        cantidadNada1.setText(Integer.toString(contadorNada1));
                    }
                    break;
                case R.id.restadorNadaPregunta2:
                    if (contadorNada2 > 0) {
                        contadorNada2--;
                        cantidadNada2.setText(Integer.toString(contadorNada2));
                    }
                    break;
                case R.id.restadorNadaPregunta3:
                    if (contadorNada3 > 0) {
                        contadorNada3--;
                        cantidadNada3.setText(Integer.toString(contadorNada3));
                    }
                    break;
                case R.id.restadorNadaPregunta4:
                    if (contadorNada4 > 0) {
                        contadorNada4--;
                        cantidadNada4.setText(Integer.toString(contadorNada4));
                    }
                    break;
                case R.id.restadorNadaPregunta5:
                    if (contadorNada5 > 0) {
                        contadorNada5--;
                        cantidadNada5.setText(Integer.toString(contadorNada5));
                    }
                    break;
                case R.id.restadorNadaPregunta6:
                    if (contadorNada6 > 0) {
                        contadorNada6--;
                        cantidadNada6.setText(Integer.toString(contadorNada6));
                    }
                    break;
                case R.id.restadorNadaPregunta7:
                    if (contadorNada7 > 0) {
                        contadorNada7--;
                        cantidadNada7.setText(Integer.toString(contadorNada7));
                    }
                    break;
                case R.id.restadorNadaPregunta8:
                    if (contadorNada8 > 0) {
                        contadorNada8--;
                        cantidadNada8.setText(Integer.toString(contadorNada8));
                    }
                    break;
                case R.id.restadorNadaPregunta9:
                    if (contadorNada9 > 0) {
                        contadorNada9--;
                        cantidadNada9.setText(Integer.toString(contadorNada9));
                    }
                    break;
                case R.id.restadorNadaPregunta10:
                    if (contadorNada10 > 0) {
                        contadorNada10--;
                        cantidadNada10.setText(Integer.toString(contadorNada10));
                    }
                    break;
                case R.id.restadorNadaPregunta11:
                    if (contadorNada11 > 0) {
                        contadorNada11--;
                        cantidadNada11.setText(Integer.toString(contadorNada11));
                    }
                    break;
            }
        }
    }
    private void DB_Backup() throws IOException{
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        final String inFileName = "/data/data/com.example.bahia.practicum/databases/"+DBHelper.DB_NAME;
        File dbFile = new File(inFileName);
        FileInputStream fis = null;

        fis = new FileInputStream(dbFile);

        String directorio = "/storage/emulated/0/BasesDatos";
        File d = new File(directorio);
        if(!d.exists()){
            d.mkdir();
        }
        String outFileName = directorio+"/"+DBHelper.DB_NAME+"_"+timeStamp;
        OutputStream output = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while((length = fis.read(buffer))>0){
            output.write(buffer, 0, length);
        }
        output.flush();
        output.close();
        fis.close();
    }
}
