package com.example.tutu.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.EditText;

public class BD_sqllite  extends SQLiteOpenHelper {
    public static final String name="data.db";
    public BD_sqllite(@Nullable Context context) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table sport (id integer  primary key autoincrement ,  nom TEXT ,  prenom  TEXT , email TEXT , mdp TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if  exists sport ");
     onCreate(db);
    }

public boolean insertData (EditText nom , EditText prenom , EditText email , EditText mdp) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("nom", nom);
    contentValues.put("prenom", prenom);
    contentValues.put("email", email);
    contentValues.put("mot de passe", mdp);
    long result = db.insert("sport", null, contentValues);
    if (result == -1)

        return false;
    else
        return true;
}
}