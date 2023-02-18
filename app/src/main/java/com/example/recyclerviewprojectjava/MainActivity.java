package com.example.recyclerviewprojectjava;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;

import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageUrl = new ArrayList<>();
    private ArrayList<String> dS = new ArrayList<>();

    public static Context context;

    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();
        context = getApplicationContext();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        floatingActionButton = findViewById(R.id.btnFloating);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmailActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        imageUrl.add("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Zagreb_%2829255640143%29.jpg/1024px-Zagreb_%2829255640143%29.jpg");
        names.add("Zagreb");
        dS.add("Zagreb, opis:");


        imageUrl.add("https://apartments-osijek.com/img/cms/1.jpg");
        names.add("Osijek");
        dS.add("Osijek, opis:");

        imageUrl.add("https://s27363.pcdn.co/wp-content/uploads/2021/01/Best-View-of-Split.jpg.optimal.jpg");
        names.add("Split");
        dS.add("Split, opis:");

        imageUrl.add("https://whc.unesco.org/uploads/thumbs/site_0095_0001-750-750-20151104150638.jpg");
        names.add("Dubrovnik");
        dS.add("Dubrovnik, opis:");

        imageUrl.add("https://turizamilok.hr/images/_theme/0/ilok_stara_jezgra.jpg");
        names.add("Ilok");
        dS.add("Ilok, opis:");

        imageUrl.add("https://www.karlovac.hr/UserDocsImages//2016/slike/Karlovac.jpg");
        names.add("Karlovac");
        dS.add("Karlovac, opis:");

        imageUrl.add("https://www.visit-croatia.hr/photos/destinations/thumbs/Pozega-61ba189f18429954121582_huge.jpg");
        names.add("Požega");
        dS.add("Požega, opis:");
        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recView);
        ListAdapter adapter = new ListAdapter(this, names, imageUrl, dS);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

}