package ru.geekbrains.homework.Lesson6;

public enum ActivityType {
    SWIM ("swim"),
    RUN ("run"),
    RAN ("ran"),
    SWAM ("swam");

    private final String activityType;

    ActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getType() {
        return activityType;
    }
}
