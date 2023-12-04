package pe.usat.moviles.rapidisimoapp_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final MaterialButton btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(view -> {


            /*Llamar al NavigationActivity*/
            final Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
            startActivity(intent);

            /*Cerrar el MainActivity*/
            LoginActivity.this.finish();
        });
    }
}