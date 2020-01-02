package com.example.recyclercoffee;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    String name;
    String description;
    int imageResId;

    Coffee(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }
    public static ArrayList<Coffee> initCoffee() {
        ArrayList<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee("Латте","Кофейный напиток родом из Италии, состоящий из молока (итал. latte) и кофе эспрессо.",R.drawable.latte));
        coffees.add(new Coffee("Капучино","Кофейный напиток итальянской кухни на основе эспрессо с добавлением в него подогретого вспененного молока.",R.drawable.capp));
        coffees.add(new Coffee("Макиато","Кофейный напиток, изготавливаемый из порции эспрессо и небольшого количества молока, обычно взбитого. Также известен как эспрессо макиато.",R.drawable.makiato));
        return coffees;
    }
}
