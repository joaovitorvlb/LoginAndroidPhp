package com.example.logonandroidphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainLogin extends AppCompatActivity {

    EditText editEmailLogger, editSenhaLogar;
    Button btnEntrar;
    TextView txtCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        txtCadastro = findViewById(R.id.txtCadastrar);

        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCad = new Intent(MainLogin.this, MainCadastro.class);
                startActivity(abreCad);
            }
        });
    }
}