package ru.geekbrains.homework.Lesson6;

public class Cat extends Animal {
    public static int catCount = 0;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        super(name, 200, 0);
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
