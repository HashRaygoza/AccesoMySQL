package com.example.accesomysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.accesomysql.accesoDB.AccesoDB;

public class MainActivity extends AppCompatActivity {
    public static final String RESULTADO_CONSULTA = "com.example.accesomysql.RESULTADO_CONSULTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, BaseDatosActivity.class);

        EditText urlTxt = (EditText) findViewById(R.id.url);
        EditText userTxt = (EditText) findViewById(R.id.user) ;
        EditText passTxt = (EditText) findViewById(R.id.password) ;

        String url = urlTxt.getText().toString();
        String user = userTxt.getText().toString();
        String pass = passTxt.getText().toString();

        AccesoDB accesoDB = new AccesoDB(url, user, pass);

        Thread hilo = new Thread(accesoDB);
        hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(accesoDB.getError().compareTo("") == 0) {
            intent.putExtra(RESULTADO_CONSULTA, accesoDB.getVersion());
        }else{
            intent.putExtra(RESULTADO_CONSULTA, accesoDB.getError());
        }

        startActivity(intent);
    }
}
