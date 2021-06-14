package ru.geekbrains.homework.Lesson6;

public class Cat extends Animal {
    public static int catCount = 0;
    private static final int maxRunDistance = 200;
    private static final int maxSwimDistance = 0;
    public Cat(String name){
        super(name, maxRunDistance, maxSwimDistance);
        catCount++;
    }
}
