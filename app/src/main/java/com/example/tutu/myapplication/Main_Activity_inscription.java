package com.example.tutu.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main_Activity_inscription extends AppCompatActivity {

    BD_sqllite bd = new BD_sqllite(this);
    EditText nom , prenom , mdp , email ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__inscription);

        nom = (EditText) findViewById(R.id.nom_text);
        prenom = (EditText) findViewById(R.id.prenom_text);
        email = (EditText) findViewById(R.id.email_text);
        mdp = (EditText) findViewById(R.id.password);

    }

    public void btn_add(View view) {
        String nom_txt = nom.getText().toString();
        String prenom_txt = prenom.getText().toString();
        String email_txt = email.getText().toString();
        String mdp_txt = mdp.getText().toString();
          boolean result =bd.insertData(nom,prenom,email,mdp);
          if(result==true)
          {
              Toast.makeText(Main_Activity_inscription.this,"ok" , Toast.LENGTH_LONG).show();
          } else
          {
              Toast.makeText(Main_Activity_inscription.this,"no" , Toast.LENGTH_LONG).show();
          }


    }
}
