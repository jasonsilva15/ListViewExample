package com.example.service_admin.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ItemAdapter itemAdapter;
    List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList= new ArrayList<Item>();
        itemAdapter= new ItemAdapter(itemList, this );
        ListView listView = findViewById(R.id.List_viewPrincipal);

        listView.setAdapter(itemAdapter);
        Item newItem = new Item();

        newItem.setName("Carro");
        newItem.setDescription("un Carro");
        newItem.setImageId(R.mipmap.ic_launcher_round);
        itemAdapter.Additem(newItem);

        Button btnAdd = findViewById(R.id.AddItem);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item newItem = new Item();

                newItem.setName("Carro mas nuevo");
                newItem.setDescription("un Carro super nuevo");
                newItem.setImageId(R.mipmap.carro);
                itemAdapter.Additem(newItem);


            }
        });

    }
}
