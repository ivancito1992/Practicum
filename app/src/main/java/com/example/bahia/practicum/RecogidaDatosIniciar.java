package com.example.bahia.practicum;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class RecogidaDatosIniciar extends AppCompatActivity {

    private boolean creadaBD = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_recogida_datos);



        //DataBaseHelper helper = new DataBaseHelper(this);
        //SQLiteDatabase db = helper.getWritableDatabase(); // La primera vez me crea la BD y luego la abre para poder leer y escribir

        siguienteLayout();
    }

    private void siguienteLayout() {
        Button continuar = (Button) findViewById(R.id.iniciar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecogidaDatosIniciar.this, RecogidaDatosConcepto.class));
            }
        });
    }
}
