package com.example.recyclercoffee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Создать OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this,DrinkActivity.class);
                    startActivity(intent);
                }
            }
        };
        //Добавить слушателя к списковому представлениюView
        ListView listView = findViewById(R.id.options);
        listView.setOnItemClickListener(itemClickListener);
        }
}
