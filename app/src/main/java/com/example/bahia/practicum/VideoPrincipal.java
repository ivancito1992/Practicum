package com.example.bahia.practicum;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoPrincipal extends Activity {
    VideoView presentacion;
    int tiempoDeEspera = 9100;
    boolean activo = true;

    @Override
     public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        presentacion = (VideoView) findViewById(R.id.videoView_video);

        Uri path = Uri.parse("android.resource://com.example.bahia.practicum/"+ R.raw.zumosolintro);
        presentacion.setVideoURI(path);
        presentacion.start();
        Thread esperar = new Thread(){
            public void run(){
                try{
                    int esperado = 0;
                    while(activo && esperado<tiempoDeEspera){
                        sleep(100);
                        if(activo){
                            esperado += 100;
                        }
                    }
                }
                catch (InterruptedException e){

                }
                finally {
                    siguiente();
                }
            }
        };
        esperar.start();
    }

    private void siguiente() {
        startActivity(new Intent(VideoPrincipal.this, RecogidaDatosIniciar.class));
        finish();
    }
}
