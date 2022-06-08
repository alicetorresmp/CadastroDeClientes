package com.example.trabalhomobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class ListarCliente extends AppCompatActivity {

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

        viewData();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String text = userlist.getItemAtPosition(i).toString();
                Toast.makeText(ListarCliente.this, "" + text, Toast.LENGTH_SHORT).show();
            }


        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private void viewData() {
        Cursor cursor = db.viewData();


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


    }