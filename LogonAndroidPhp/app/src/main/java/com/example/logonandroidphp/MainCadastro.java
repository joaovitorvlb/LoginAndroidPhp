package com.example.logonandroidphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainCadastro extends AppCompatActivity {

    private EditText editNomeCad, editEmailCad, editSenhaCad, editSenhaConf;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_cadastro);

        editNomeCad = findViewById(R.id.editNomeCad);
        editEmailCad = findViewById(R.id.editEmailCad);
        editSenhaCad = findViewById(R.id.editSenhaCad);
        editSenhaConf = findViewById(R.id.editSenhaConf);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}