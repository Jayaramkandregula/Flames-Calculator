package com.jayaram12.flamescalculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class FlamesResults extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FlamesRecyclerViewAdapter flamesRecyclerViewAdapter;
    private List<flames_class> flames_list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flames_results);
        recyclerView=findViewById(R.id.flames_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DataBaseHandler db = new DataBaseHandler(this);
        flames_list=db.getAll_flames_results();
        flamesRecyclerViewAdapter=new FlamesRecyclerViewAdapter(flames_list,FlamesResults.this);
        recyclerView.setAdapter(flamesRecyclerViewAdapter);

    }
}