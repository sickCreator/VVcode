package com.example.vcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.Items;
import android.os.Bundle;
import android.widget.Button;

public class Editor extends AppCompatActivity {
    private RecyclerView rev;
    private MyAdapter adapter;
    private List<Items> items;
    Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        rev=(RecyclerView) findViewById(R.id.recyclerView);
        buttonBack=findViewById(R.id.backBtn);
        rev.setLayoutManager(new LinearLayoutManager(this));
        items=new ArrayList<>();
        Items items1=new Items("Quiz:Variables");
        Items items2=new Items("Quiz:literals");
        Items items3=new Items("Quiz:Operators");
        Items items4=new Items("Quiz:Decision making");
        Items items5=new Items("Quiz:Loops");
        Items items6=new Items("Quiz:Functions");
        Items items7=new Items("Quiz:Arrays");
        Items items8=new Items("Quiz:Structures");
        Items items9=new Items("Quiz:Pointers");


        items.add(items1);
        items.add(items2);
        items.add(items3);
        items.add(items4);
        items.add(items5);
        items.add(items6);
        items.add(items7);
        items.add(items8);
        items.add(items9);
        adapter=new MyAdapter(this,items);
        rev.setAdapter(adapter);
buttonBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
});
    }

}