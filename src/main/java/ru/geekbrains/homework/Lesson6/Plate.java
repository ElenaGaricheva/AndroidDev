package ru.geekbrains.homework.Lesson6;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food){
        this.food += food;
    }
}
