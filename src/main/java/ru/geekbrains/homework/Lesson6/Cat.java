package ru.geekbrains.homework.Lesson6;

public class Cat extends Animal {
    public static int catCount = 0;
    private final int appetite;
    private boolean satiety;
    private static final int maxRunDistance = 200;
    private static final int maxSwimDistance = 0;

    public Cat(String name, int appetite) {
        super(name, maxRunDistance, maxSwimDistance);
        this.appetite = appetite;
        satiety = false;
        catCount++;
    }

    public void eat(Plate p) {
        if (p.getFood() >= this.appetite) {
            p.decreaseFood(appetite);
            this.satiety = true;
        } else {
            System.out.printf("This portion is too small for %s!\n", getName());
            this.satiety = false;
        }
    }

    public void isSatiety() {
        if (satiety) {
            System.out.println("The cat is full!");
        } else System.out.println("The cat is hungry!");
    }
}
