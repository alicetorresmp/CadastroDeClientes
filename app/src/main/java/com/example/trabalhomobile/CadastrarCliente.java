package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CadastrarCliente extends AppCompatActivity {


    Button add_data;

    private EditText add_nome, add_matricula, add_endereco, add_numero, add_complemento,
            add_cidade;
    ListView listView;
    DatabaseHelper db = new DatabaseHelper(this);



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

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


        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = add_nome.getText().toString();
                String matricula = add_matricula.getText().toString();
                String endereco = add_endereco.getText().toString();
                String numero = add_numero.getText().toString();
                String complemento = add_complemento.getText().toString();
                String cidade = add_cidade.getText().toString();
                Cliente cliente = new Cliente(nome, matricula, endereco, numero, complemento, cidade);

                if (!nome.equals("") && db.insertData(nome, matricula, endereco, complemento, numero, cidade)) {
                    Toast.makeText(CadastrarCliente.this, "Informa????es cadastradas.", Toast.LENGTH_SHORT).show();
                    add_nome.setText("");
                    add_matricula.setText("");
                    add_endereco.setText("");
                    add_complemento.setText("");
                    add_numero.setText("");
                    add_cidade.setText("");


                } else {
                    Toast.makeText(CadastrarCliente.this, "Informa????es n??o cadastradas.", Toast.LENGTH_SHORT).show();
                }

            }



        });


    }



        @Override
        public boolean onCreateOptionsMenu( Menu menu) {
            getMenuInflater().inflate(R.menu.menu_res, menu);

            MenuItem actionSearch= menu.findItem(R.id.search_action);
            final SearchView searchViewEditText = (SearchView) actionSearch.getActionView();
            searchViewEditText .setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    Intent intent = new Intent(CadastrarCliente.this,
                            ListarPesquisaCliente.class);
                    intent.putExtra("ParametroNome",
                            query);
                    startActivity(intent);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    return false;
                }
            });

            return true;
        }



/*

        return super.onCreateOptionsMenu(menu);

    }


 */


    public void atualizar(View view)
    {   String nome = add_nome.getText().toString();
        String matricula = add_matricula.getText().toString();
        String endereco = add_endereco.getText().toString();
        String numero = add_numero.getText().toString();
        String complemento = add_complemento.getText().toString();
        String cidade = add_cidade.getText().toString();
        Cliente cliente = new Cliente(nome, matricula, endereco, numero, complemento, cidade);

        if (!nome.equals("") && db.updateData(nome, matricula, endereco, complemento, numero, cidade)) {
            Toast.makeText(CadastrarCliente.this, "Informa????es atualizadas.", Toast.LENGTH_SHORT).show();
            add_nome.setText("");
            add_matricula.setText("");
            add_endereco.setText("");
            add_complemento.setText("");
            add_numero.setText("");
            add_cidade.setText("");


        }}


    public void deletar(MenuItem item)
    {Intent it = new Intent(this, DeletarCliente.class);
        startActivity(it);}

    public void visualizar(MenuItem item)
    {Intent it = new Intent(this, ListarCliente.class);
        startActivity(it);}

    public void sair(MenuItem item)
    {Intent it = new Intent(this, MainActivity.class);
        startActivity(it);}




}