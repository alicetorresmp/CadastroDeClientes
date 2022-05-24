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
        String name = intent.getSerializableExtra("ParametroName").toString();

        searchData(name);

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String text = userlist.getItemAtPosition(i).toString();
                Toast.makeText(ListarPesquisaCliente.this, ""+text, Toast.LENGTH_SHORT).show();
            }


        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void searchData(String name) {
        Cursor cursor = db.searchData(name);


        if(cursor.getCount() == 0){
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){

                String nome = cursor.getString(1);
                String matricula = cursor.getString(2);




                listItem.add("\n" + "Nome: " + nome + "\n" +
                        "Matrícula: " + matricula + "\n");
                //        listItem.add(cursor.getString(1));
                //       listItem.add(cursor.getString(2)); // index 1 é nome, index 0 é ID
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);

        }
    }
}