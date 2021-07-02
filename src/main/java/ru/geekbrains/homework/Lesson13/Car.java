package ru.geekbrains.homework.Lesson13;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;

    static private long winTime = 0;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.startLine.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            try {
                race.getStages().get(i).go(this);
                if (i == race.getStages().size() - 1 && winTime == 0 || System.currentTimeMillis() < winTime) {
                    winTime = System.currentTimeMillis();
                    System.out.println(this.name + " WIN");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            MainClass.finishLine.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

