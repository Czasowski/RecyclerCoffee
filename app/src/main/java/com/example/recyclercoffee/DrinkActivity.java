package com.example.recyclercoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {
ArrayList<Coffee> coffees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        RecyclerView rvCoffee = findViewById(R.id.rvCoffee);
        coffees = Coffee.initCoffee();
        CoffeeAdapter adapter = new CoffeeAdapter(coffees);
        rvCoffee.setAdapter(adapter);
        rvCoffee.setLayoutManager(new LinearLayoutManager(this));
    }
}
