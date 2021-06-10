package ru.geekbrains.homework.Lesson6;

public class Animal {
    private final String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    void run(int distance) {
        checkAbilities(distance, this.maxRunDistance, "run");
    }

    void swim(int distance) {
        checkAbilities(distance, this.maxSwimDistance, "swim");
    }

    private boolean validate(int distance) {
        return distance > 0;
    }

    private void checkAbilities(int distance, int maxDistance, String abilities) {
        if (!validate(distance)) {
            System.out.println("distance can't be negative!");
            return;
        }
        if (maxDistance == 0) {
            System.out.printf("%s can't %s at all!\n", this.name, abilities);
        } else if (distance <= maxDistance) {
            abilities = abilities.equals("run") ? "ran" : "swam";
            System.out.printf("%s %s %dm!\n", this.name, abilities, distance);
        } else System.out.printf("%s can't %s such a long distance!\n", this.name, abilities);
    }

    public String getName() {
        return name;
    }
}
