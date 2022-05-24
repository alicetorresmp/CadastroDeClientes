package com.example.trabalhomobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Nome da tabela e banco
    private static final String DB_NAME = "Users.db";
    private static final String DB_TABLE = "Users_Table";

    //Nome das colunas
    private static final String ID = "ID";
    private static final String NOME = "NOME";
    private static final String MATRICULA = "MATRICULA";
    private static final String ENDERECO = "ENDERECO";
    private static final String COMPLEMENTO = "COMPLEMENTO";
    private static final String NUMERO = "NUMERO";
    private static final String CIDADE = "CIDADE";

    private static final String CREATE_TABLE = "CREATE TABLE "+ DB_TABLE+" ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NOME+ " TEXT," +
            MATRICULA+ " TEXT, " +
            ENDERECO + " TEXT, " +
            COMPLEMENTO + " TEXT, " +
            NUMERO + " TEXT, " +
            CIDADE+ " TEXT " + ")";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE);

        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String nome, String matricula, String endereco, String complemento, String numero, String cidade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOME, nome);
        contentValues.put(MATRICULA, matricula);
        contentValues.put(ENDERECO, endereco);
        contentValues.put(COMPLEMENTO, complemento);
        contentValues.put(NUMERO, numero);
        contentValues.put(CIDADE, cidade);

        long result = db.insert(DB_TABLE, null, contentValues);
        return result != -1; // se for -1 quer dizer que os dados não foram inseridos
    }

    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+DB_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;

    } public Cursor searchData(String nome2){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+DB_TABLE+" WHERE "+NOME+" LIKE '%"+nome2+"%'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
}