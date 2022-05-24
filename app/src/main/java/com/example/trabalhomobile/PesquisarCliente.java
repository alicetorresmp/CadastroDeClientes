package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PesquisarCliente extends AppCompatActivity {

    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_cliente);
        name = findViewById(R.id.txtName);
    }

    public void voltar(View view){

        Intent intent = new Intent(PesquisarCliente.this,
                CadastrarCliente.class);
        startActivity(intent);}

    public void procurar(View view){
        String name2 = name.getText().toString();

        Intent intent = new Intent(PesquisarCliente.this,
                ListarPesquisaCliente.class);
        intent.putExtra("ParametroName",
                name2);
        startActivity(intent);}

}