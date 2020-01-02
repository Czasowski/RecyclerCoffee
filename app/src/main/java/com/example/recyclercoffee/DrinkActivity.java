package com.example.recyclercoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity implements CoffeeAdapter.onCoffeeListener { //имплементим
ArrayList<Coffee> coffees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        RecyclerView rvCoffee = findViewById(R.id.rvCoffee);
        coffees = Coffee.initCoffee();
        CoffeeAdapter adapter = new CoffeeAdapter(coffees, this);
        rvCoffee.setAdapter(adapter);
        rvCoffee.setLayoutManager(new LinearLayoutManager(this)); //LayoutManager отвечает за позиционирование view-компонентов в RecyclerView,
        // а также за определение того, когда следует переиспользовать view-компоненты, которые больше не видны пользователю.
        }
//для кликов метод
    @Override
    public void onCoffeeClick(int position) {
        String messagetext = coffees.get(position).name + " пить будешь, бедолага?";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messagetext);
        Intent chosenIntent = Intent.createChooser(intent, "Кому плеснуть кофейка?");
       startActivity(chosenIntent);
    }
}

