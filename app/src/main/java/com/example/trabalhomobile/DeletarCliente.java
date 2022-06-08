package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DeletarCliente extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_cliente);
        name = findViewById(R.id.txtNameDelete);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void delete(View view){
        String name2 = name.getText().toString();

        db.deleteData(name2);

        Intent intent = new Intent(DeletarCliente.this,
                ListarCliente.class);
        intent.putExtra("nome",
                name2);
        startActivity(intent);
    }
    public void deleteAll(View view){

        db.deleteAllData();

        Intent intent = new Intent(DeletarCliente.this,
                ListarCliente.class);
        startActivity(intent);
    }
}
