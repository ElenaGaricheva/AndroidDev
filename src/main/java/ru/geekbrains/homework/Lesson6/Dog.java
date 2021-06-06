package ru.geekbrains.homework.Lesson6;

public class Dog extends Animal {
    public static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }
}
