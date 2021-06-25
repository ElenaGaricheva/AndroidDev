package ru.geekbrains.homework.Lesson10;

import java.util.ArrayList;

public class Box {
    public ArrayList<Fruit> fruitBox;

    private final Class<? extends Fruit> typeFruit;
    private final float unitWeight;

    public Box(Fruit fruit) {
        fruitBox = new ArrayList<>();
        fruitBox.add(fruit);
        typeFruit = fruit.getClass();
        this.unitWeight = fruit.getWeight();
    }

    public void addFruit(Fruit fruit) {
        if (fruit.getClass().equals(typeFruit)) {
            fruitBox.add(fruit);
        }
    }

    public float getWeight() {
        return fruitBox.size() * unitWeight;
    }
}
