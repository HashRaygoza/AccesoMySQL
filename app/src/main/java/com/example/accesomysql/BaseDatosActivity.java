package com.example.accesomysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BaseDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.RESULTADO_CONSULTA);

        TextView versionMysql = findViewById( R.id.textView3 );
        versionMysql.setText(message);
    }
}
