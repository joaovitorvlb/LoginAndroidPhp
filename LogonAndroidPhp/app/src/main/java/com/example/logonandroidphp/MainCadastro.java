package com.example.logonandroidphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    String HOST = "http://env-9429261.jelastic.saveincloud.net";

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

                String url = HOST + "/login/cadastrar.php";

                String nome = editNomeCad.getText().toString();
                String email = editEmailCad.getText().toString();
                String senha = editSenhaCad.getText().toString();
                String confirma = editSenhaConf.getText().toString();

                if (confirma.equals(senha)){
                    if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                        Toast.makeText(MainCadastro.this, "Todos os campos são Obrigatorios", Toast.LENGTH_SHORT);
                    } else {
                        Ion.with(MainCadastro.this)
                                .load(url)
                                .setBodyParameter("nome", nome)
                                .setBodyParameter("email", email)
                                .setBodyParameter("senha", senha)
                                .asJsonObject()
                                .setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {
                                        try {
                                            // Toast.makeText(MainCadastro.this, "Retorno" + result.toString(), Toast.LENGTH_LONG).show();
                                            String retorno = result.get("cadastro").getAsString();

                                            if (retorno.equals("erro")){
                                                Toast.makeText(MainCadastro.this, "Ops! Esse elmail já está cadastrado!", Toast.LENGTH_SHORT).show();
                                            } else if (retorno.equals("sucesso")){
                                                Toast.makeText(MainCadastro.this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                                                Intent abrePrincipal = new Intent(MainCadastro.this, MainActivity.class);
                                                startActivity(abrePrincipal);
                                            } else {
                                                Toast.makeText(MainCadastro.this, "Ops! Ocorreu um erro!", Toast.LENGTH_SHORT).show();
                                            }

                                        } catch (Exception erro) {
                                            Toast.makeText(MainCadastro.this, "Ocorreu um erro" + erro, Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    }
                } else {
                    Toast.makeText(MainCadastro.this, "As senhas não conferem" , Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}