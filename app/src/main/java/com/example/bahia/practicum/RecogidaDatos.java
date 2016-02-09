package com.example.bahia.practicum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecogidaDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recogida_datos);
        siguienteLayout();
    }

    private void siguienteLayout() {
        Button continuar1 = (Button) findViewById(R.id.siguiente_btn);
        continuar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecogidaDatos.this, RecogidaDatos2.class));
            }
        });
    }
}
