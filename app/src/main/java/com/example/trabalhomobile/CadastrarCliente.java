package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastrarCliente extends AppCompatActivity {

    DatabaseHelper db;

    Button add_data;

    private EditText add_nome, add_matricula, add_endereco, add_numero, add_complemento,
            add_cidade;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        db = new DatabaseHelper(this);

        add_data = (Button) findViewById(R.id.cadastrar);
        add_nome = (EditText) findViewById((R.id.txtNome));
        add_matricula = (EditText) findViewById((R.id.txtMatricula));
        add_endereco = (EditText) findViewById((R.id.txtEndereco));
        add_numero = (EditText) findViewById((R.id.txtNumero));
        add_complemento = (EditText) findViewById((R.id.txtComplemento));
        add_cidade = (EditText) findViewById((R.id.txtCidade));


        Intent intent = getIntent();
        String nome2 =
                intent.getSerializableExtra("ParametroLogin").toString();
        TextView texto = (TextView) findViewById(R.id.txtRepeticao);
        texto.setText("Prezado(a) " + nome2 + ", seja bem-vindo ao app!");


        add_data.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String nome = add_nome.getText().toString();
                String matricula = add_matricula.getText().toString();
                String endereco = add_endereco.getText().toString();
                String numero = add_numero.getText().toString();
                String complemento = add_complemento.getText().toString();
                String cidade =  add_cidade.getText().toString();
                Cliente cliente = new Cliente(nome, matricula, endereco, numero, complemento, cidade);

                if (!nome.equals("")  &&  db.insertData(nome, matricula, endereco, complemento, numero, cidade)){
                    Toast.makeText(CadastrarCliente.this, "Informações cadastradas.", Toast.LENGTH_SHORT).show();
                    add_nome.setText("");
                    add_matricula.setText("");
                    add_endereco.setText("");
                    add_complemento.setText("");
                    add_numero.setText("");
                    add_cidade.setText("");




                }

                else {
                    Toast.makeText(CadastrarCliente.this,"Informações não cadastradas.", Toast.LENGTH_SHORT).show();
                }

            }

        });


    }

    public void visualizar(View view){

        Intent intent = new Intent(CadastrarCliente.this,
                ListarCliente.class);
        startActivity(intent);}

    public void pesquisar(View view){

        Intent intent = new Intent(CadastrarCliente.this,
                PesquisarCliente.class);
        startActivity(intent);}

}