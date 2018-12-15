package com.example.service_admin.listviewexample;

import android.content.Intent;
import android.support.annotation.Nullable;
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

        DatabaseAdapter dbAdapter = new DatabaseAdapter(this);

        itemList= dbAdapter.getItemList();

      //  itemList= new ArrayList<Item>();
        itemAdapter= new ItemAdapter(itemList, this,dbAdapter );

        ListView itemListView = findViewById(R.id.List_viewPrincipal);

        itemListView.setAdapter(itemAdapter);

        /*Item newItem = new Item();

        newItem.setName("Carro");
        newItem.setDescription("un Carro");
        newItem.setImageId(R.mipmap.ic_launcher_round);
        itemAdapter.Additem(newItem);*/

        Button btnAdd = findViewById(R.id.AddItem);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Item newItem = new Item();

                newItem.setName("Carro mas nuevo");
                newItem.setDescription("un Carro super nuevo");
                newItem.setImageId(R.mipmap.carro);

                itemAdapter.Additem(newItem);*/

                Intent intent = new Intent(MainActivity.this,itemActivity.class);
                startActivityForResult(intent,1);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String name =data.getStringExtra("name");
        String description =data.getStringExtra("descripcion");
        int imagenid = data.getIntExtra("imagen",R.mipmap.ic_launcher);

        Item newItem = new Item();
        newItem.setName(name);
        newItem.setDescription(description);
        newItem.setImageId(imagenid);

        itemAdapter.Additem(newItem);

    }
}
