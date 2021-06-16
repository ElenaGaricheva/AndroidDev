package ru.geekbrains.homework.Lesson8;

public class Wall {
    private final int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public void jump(Jump participant){
        participant.jump(wallHeight);
    }

    public int getWallHeight() {
        return wallHeight;
    }
}
