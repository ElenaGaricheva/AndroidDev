package ru.geekbrains.homework.Lesson8;

public class Competitions {
    public static void main(String[] args) {

        Human human = new Human(200, 1);
        Cat cat = new Cat(300, 2);

        Track track = new Track(200);
        track.run(human);

    }
}
