package com.example.accesomysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String RESULTADO_CONSULTA = "com.example.accesomysql.RESULTADO_CONSULTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, BaseDatosActivity.class);

        intent.putExtra(RESULTADO_CONSULTA, "-1");

        startActivity(intent);
    }
}
