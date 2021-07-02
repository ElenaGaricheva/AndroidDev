package ru.geekbrains.homework.Lesson8;

public class Track extends Barrier {
    private final int trackLength;

    public Track(int trackLength) {
        this.trackLength = trackLength;
    }

    boolean checkBarrier(Movable participant) {
        return participant.run(trackLength);
    }
}
