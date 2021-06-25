package ru.geekbrains.homework.Lesson10;

public class Store {
    public static void main(String[] args) {
        Orange orange = new Orange();
        Apple apple = new Apple();

        Box appleBox = new Box(apple);
        Box orangeBox = new Box(orange);

        appleBox.addFruit(apple);
        orangeBox.addFruit(orange);
        appleBox.addFruit(orange);

        System.out.println(appleBox.getWeight());
    }
}
