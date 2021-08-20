package ru.geekbrains.homework.Lesson8;

public class Competitions {
    public static void main(String[] args) {
        Barrier[] barriers = new Barrier[3];
        barriers[0] = new Track(200);
        barriers[1] = new Wall(2);
        barriers[2] = new Wall(1);

        Movable[] participants = new Movable[3];
        participants[0] = new Human(100, 1);
        participants[1] = new Cat(250, 3);
        participants[2] = new Robot(300, 2);

        for (Movable participant : participants) {
            for (Barrier barrier : barriers) {
                if (!barrier.checkBarrier(participant)) {
                    break;
                } else System.out.printf("Participant %s passed the barrier %s!\n",
                        participant.getClass().getSimpleName(), barrier.getClass().getSimpleName());
            }
        }
    }
}
