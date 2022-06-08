package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarPesquisaCliente extends AppCompatActivity {

    DatabaseHelper db;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    ListView userlist;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cliente);

        userlist = findViewById(R.id.users_list);

        db = new DatabaseHelper(this);

        listItem = new ArrayList<>();

        Intent intent = getIntent();
        String name = intent.getSerializableExtra("ParametroNome").toString();

        searchData(name);

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String text = userlist.getItemAtPosition(i).toString();
                Toast.makeText(ListarPesquisaCliente.this, ""+text, Toast.LENGTH_SHORT).show();
            }


        });

    }



    private void searchData(String name) {

        Cursor cursor = db.searchData(name);


        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {

                String nome = cursor.getString(1);
                String matricula = cursor.getString(2);
                String endereco = cursor.getString(3);
                String numero = cursor.getString(4);
                String complemento = cursor.getString(5);
                String cidade = cursor.getString(6);


                listItem.add("\n" + "Nome: " + nome + "\n\n" +
                        "Matrícula: " + matricula + "\n\n" +
                        "Endereço: " + endereco + "\n\n" +
                        "Número: " + numero + "\n\n" +
                        "Complemento: " + complemento + "\n\n" +
                        "Cidade: " + cidade + "\n");

            }



            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);

        }
    }

    public void voltar(View view) {
        Intent it = new Intent(this, CadastrarCliente.class);
        it.putExtra("ParametroLogin",
                "alicetorres");
        startActivity(it);

    }
}