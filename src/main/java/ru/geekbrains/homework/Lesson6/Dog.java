package ru.geekbrains.homework.Lesson6;

public class Dog extends Animal {
    public static int dogCount = 0;
    private static final int maxRunDistance = 500;
    private static final int maxSwimDistance = 10;

    public Dog(String name) {
        super(name, maxRunDistance, maxSwimDistance);
        dogCount++;
    }
}
