package ru.geekbrains.homework.Lesson8;

public class Track {
    private final int trackLength;

    public Track(int trackLength) {
        this.trackLength = trackLength;
    }

    public void run(Run participant){
        participant.run(trackLength);
    }

    public int getTrackLength() {
        return trackLength;
    }
}
