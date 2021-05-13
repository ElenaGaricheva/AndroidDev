package ru.geekbrains.homework;

public class Lesson1 {
    public static void main(String[] args) {
        int a,b;
        byte littleNumber = 120;
        short shortNumber = 1200;
        int midNumber = 12000;
        long longNumber = 1200000L;
        float floatNumber = 12.13f;
        double doubleNumber = 121.133;
        char symbol = '\u0430';
        boolean trueOrFalse = true;
        mathCalc(12.3f, 12.4f, 12.5f, 12.6f);
    }

    public static float mathCalc(Float a, Float b, Float c, Float d) {
        return a * (b + (c / d));
    }

}
