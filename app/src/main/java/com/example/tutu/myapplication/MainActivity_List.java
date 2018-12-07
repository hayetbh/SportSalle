package com.example.tutu.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
public abstract class MainActivity_List extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    protected ListView maListViewPerso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_main);
        // ListView
        // Récupération de la "ListView" créée dans le fichier activity_main.xml
        maListViewPerso = findViewById(R.id.listviewperso);

        // Création de la "ArrayList" qui nous permettra de remplir la "ListView"
        ArrayList<HashMap<String, String>> listItems = new ArrayList<>();

        // On déclare la "HashMap" qui contiendra les informations pour un item
        HashMap<String, String> item;

        // Titre des items
        String[] title = new String[]{
                getResources().getString(R.string.yoga),
                getResources().getString(R.string.cardio),
                getResources().getString(R.string.musculation),
                getResources().getString(R.string.gymna) ,
                getResources().getString(R.string.zumba)
        };
        // Description des items
        String[] description = new String[]{
                getResources().getString(R.string.yoga_description),
                getResources().getString(R.string.cardio_description),
                getResources().getString(R.string.muscule_description),
                getResources().getString(R.string.gymna_description),
                getResources().getString(R.string.zumba_description)
        };
        // Icones (images) des items
        String[] icon = new String[]{
                String.valueOf(R.drawable.yoga),
                String.valueOf(R.drawable.cardio),
                String.valueOf(R.drawable.muscule),
                String.valueOf(R.drawable.gymna),
                String.valueOf(R.drawable.zumba)};
        // Creation des items de la liste
        for (int i = 0; i < 4; i++) {
            item = new HashMap<>();
            // Titre
            item.put("title", title[i]);
            // Description
            item.put("description", description[i]);
            // Icone
            item.put("icon", icon[i]);
            listItems.add(item);
        }

        // Creation d l’Adapter
        SimpleAdapter adapter = new SimpleAdapter (this.getBaseContext(),
                listItems,
                R.layout.list_content,
                new String[] {"title", "description", "icon"},
                new int[] {R.id.title, R.id.desc, R.id.icon});
        // Association de l’adapter à la liste
        maListViewPerso.setAdapter(adapter);

        // Interaction avec les items de la liste
        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> item = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                Toast.makeText(MainActivity_List.this, item.get("title"), Toast.LENGTH_SHORT).show();
            }
        });

        maListViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> item = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_List.this);

                builder.setTitle("Choix du Produit  ");
                builder.setMessage("Vous avez choisi : " + item.get("title"));
                builder.setIcon(R.drawable.appicon);
                builder.setPositiveButton("Ok", null);
                builder.show();
                return true;
            }
        });
    }

    }

