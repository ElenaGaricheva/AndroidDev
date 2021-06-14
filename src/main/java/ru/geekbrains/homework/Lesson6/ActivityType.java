package ru.geekbrains.homework.Lesson6;

public enum ActivityType {
    SWIM ("swim"),
    RUN ("run"),
    RAN ("ran"),
    SWAM ("swam");

    public String activityType;


    ActivityType(String activityType) {
        this.activityType = activityType;
    }
}
