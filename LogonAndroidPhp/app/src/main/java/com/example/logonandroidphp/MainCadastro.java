package com.example.logonandroidphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

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

                String url = "http://env-9429261.jelastic.saveincloud.net/login/teste.json";

                Ion.with(MainCadastro.this)
                        .load(url)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                try {
                                    Toast.makeText(MainCadastro.this, "Retorno" + result.toString(), Toast.LENGTH_LONG).show();
                                } catch (Exception erro){
                                    Toast.makeText(MainCadastro.this, "Ocorreu um erro" + erro, Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                
            }
        });
    }
}