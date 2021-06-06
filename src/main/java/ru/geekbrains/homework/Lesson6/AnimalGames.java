package ru.geekbrains.homework.Lesson6;

public class AnimalGames {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Muska");
        new Cat("Puska");
        new Cat("Fedora");
        Dog dog1 = new Dog("Bublik");
        new Dog("Bobik");

        cat1.run(250);
        cat1.run(100);
        dog1.run(550);
        dog1.run(300);
        cat1.swim(15);
        dog1.swim(5);
        System.out.println(Cat.catCount);
        System.out.println(Dog.dogCount);
    }
}