package pe.usat.moviles.rapidisimoapp_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sesion.edit();
        final String token = sesion.getString("token", "");
        final Intent intent;
        //Evaluamos si hay una sesión iniciada
        if (!token.equals("")) {
            //Hay una sesión activa
            /*Llamar al NavigationActivity*/
            intent = new Intent(MainActivity.this, NavigationActivity.class);
            startActivity(intent);
        } else {
            /*Llamar al LoginActivity*/
            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        /*Cerrar el MainActivity*/
        MainActivity.this.finish();


    }
}