package ru.geekbrains.homework.Lesson10;

public class Store {
    public static void main(String[] args) {
        Orange orange = new Orange();
        Apple apple = new Apple();

        Box appleBox = new Box(apple);
        Box orangeBox = new Box(orange);

        appleBox.addFruit(apple);
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));
        orangeBox.addFruitFromOtherBox(orangeBox);
        orangeBox.addFruitFromOtherBox(appleBox);

    }
}
