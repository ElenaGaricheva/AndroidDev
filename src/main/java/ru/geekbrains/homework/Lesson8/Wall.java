package ru.geekbrains.homework.Lesson8;

public class Wall extends Barrier {
    private final int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    boolean checkBarrier(Movable participant) {
        return participant.jump(wallHeight);
    }
}
