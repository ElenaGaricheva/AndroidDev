package ru.geekbrains.homework.Lesson12;

import java.util.Arrays;

public class Lesson12 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        changeArrayValues(arr);

        System.out.println("Method_1 " + (System.currentTimeMillis() - a));
    }

    public static void method2() {
        float[] arr = new float[size];
        final float[] arr_1 = new float[size / 2];
        final float[] arr_2 = new float[size / 2];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr_1, 0, h / 2);
        System.arraycopy(arr, h / 2, arr_2, 0, h / 2);

        new Thread(() -> {
            float[] arr_buff = changeArrayValues(arr_1);
            System.arraycopy(arr_buff, 0, arr, 0, h / 2);
        }).start();

        new Thread(() -> {
            float[] arr_buff = changeArrayValues(arr_2);
            System.arraycopy(arr_buff, 0, arr, h / 2, h / 2);
        }).start();

        System.out.println("Method_2 " + (System.currentTimeMillis() - a));

    }

    private static float[] changeArrayValues(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

}
