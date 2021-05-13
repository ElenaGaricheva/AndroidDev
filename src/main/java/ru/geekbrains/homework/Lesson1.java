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
    }

    //Task 3
    public static float mathCalc(Float a, Float b, Float c, Float d) {
        return a * (b + (c / d));
    }

    //Task 4
    public static boolean checkSum(Integer a, Integer b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //Task 5
    public static void checkNumber(Integer a) {
        if (a < 0) {
            System.out.println("Отрицательное");
        }
        else System.out.println("Положительное");
    }

    //Task 6
    public static boolean positiveOrNegative(Integer a) {
        return a < 0;
    }

    //Task 7
    public static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //Task 8
    public static void checkLeapYear(Integer year) {
        if (((year%4) == 0 && (year%100) != 0) || (year%400) == 0) {
            System.out.println("Високосный");
        }
        else System.out.println("Невисокосный");
    }
}