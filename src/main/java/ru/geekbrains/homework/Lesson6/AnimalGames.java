package ru.geekbrains.homework.Lesson6;

public class AnimalGames {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat cat1 = new Cat("Muska", 15);
        Cat cat2 = new Cat("Puska", 20);
        Cat cat3 = new Cat("Fedora", 20);
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

        cat1.eat(plate);
        cat2.eat(plate);
        cat3.eat(plate);

        cat1.isSatiety();
        cat2.isSatiety();
        cat3.isSatiety();

        plate.addFood(20);
        cat3.eat(plate);
        cat3.isSatiety();

    }
}