package com.example.service_admin.listviewexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class itemActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_layout);

        Button button =findViewById(R.id.Agregar);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView itemView= findViewById(R.id.List_viewPrincipal);

                TextView nameView = findViewById(R.id.nameTxt);
                TextView descVew = findViewById(R.id.descTxt);

                Item item = new Item();

                item.setName(nameView.getText().toString());
                item.setDescription(descVew.getText().toString());
                item.setImageId(R.mipmap.carro);

                Intent intent = new Intent();
                intent.putExtra("name", item.name);
                intent.putExtra("descripcion",item.description);
                intent.putExtra("imagen",item.imageId);

                setResult(RESULT_OK,intent);
                finish();


            }
        });



    }

    public itemActivity() {


    }
}
