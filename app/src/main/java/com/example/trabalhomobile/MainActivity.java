package com.example.trabalhomobile;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText login;
    private EditText senha;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.txtLogin);
        senha = findViewById(R.id.txtSenha);

    }
    public void logar(View view){
        String login2 = login.getText().toString();
        String senha2 = senha.getText().toString();
        if(login2.equals("alicetorres") && senha2.equals("senha")) {
            Intent intent = new Intent(MainActivity.this,
                    CadastrarCliente.class);
            intent.putExtra("ParametroLogin",
                    login2);
            startActivity(intent);

        } else{
            Toast.makeText(this, "Login ou senha inválidos.", Toast.LENGTH_SHORT).show();
        }
    }

}