package ru.geekbrains.homework.Lesson10;

import java.util.ArrayList;
import java.util.Collections;

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
        } else {
            System.out.printf("%s can't be added to this box!\n", fruit.getClass().getSimpleName());
        }
    }

    public float getWeight() {
        return fruitBox.size() * unitWeight;
    }

    public boolean compare(Box fruitBox2) {
        return getWeight() == fruitBox2.getWeight();
    }

    public void addFruitFromOtherBox(Box fruitBox2) {
        if (fruitBox2.typeFruit.equals(typeFruit)) {
            fruitBox.addAll(fruitBox2.fruitBox);
        } else {
            System.out.printf("Box of %s can't be moved to this box!\n", fruitBox2.typeFruit.getSimpleName());
        }
    }
}
