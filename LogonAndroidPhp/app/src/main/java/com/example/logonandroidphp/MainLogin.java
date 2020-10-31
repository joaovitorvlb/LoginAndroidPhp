package com.example.logonandroidphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainLogin extends AppCompatActivity {

    EditText editEmailLogar, editSenhaLogar;
    Button btnEntrar;
    TextView txtCadastro;

    String HOST = "http://env-9429261.jelastic.saveincloud.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        editEmailLogar = findViewById(R.id.editEmailLogar);
        editSenhaLogar = findViewById(R.id.editSenhaLogar);
        btnEntrar = findViewById(R.id.btnLogar);


        txtCadastro = findViewById(R.id.txtCadastrar);
        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCad = new Intent(MainLogin.this, MainCadastro.class);
                startActivity(abreCad);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmailLogar.getText().toString();
                String senha = editSenhaLogar.getText().toString();

                String url = HOST + "/login/logar.php";

                if(email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(MainLogin.this, "Todos os campos são Obrigatorios", Toast.LENGTH_SHORT);
                } else {
                    Ion.with(MainLogin.this)
                            .load(url)
                            .setBodyParameter("email", email)
                            .setBodyParameter("senha", senha)
                            .asJsonObject()
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {
                                    try {
                                        // Toast.makeText(MainCadastro.this, "Retorno" + result.toString(), Toast.LENGTH_LONG).show();
                                        String retorno = result.get("login").getAsString();

                                        if (retorno.equals("erro")){
                                            Toast.makeText(MainLogin.this, "Ops! Email ou senha incorretas!", Toast.LENGTH_SHORT).show();
                                        } else if (retorno.equals("sucesso")){
                                            Intent abrePrincipal = new Intent(MainLogin.this, MainActivity.class);
                                            startActivity(abrePrincipal);
                                        } else {
                                            Toast.makeText(MainLogin.this, "Ops! Ocorreu um erro!", Toast.LENGTH_SHORT).show();
                                        }

                                    } catch (Exception erro) {
                                        Toast.makeText(MainLogin.this, "Ocorreu um erro" + erro, Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}