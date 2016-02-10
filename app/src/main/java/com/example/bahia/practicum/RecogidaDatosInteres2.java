package com.example.bahia.practicum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class RecogidaDatosInteres2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_interes2);
        siguienteLayout();
    }

    private void siguienteLayout() {
        Button continuar = (Button) findViewById(R.id.continuar3);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecogidaDatosInteres2.this, RecogidaDatosInteres3.class));
            }
        });
    }
}
