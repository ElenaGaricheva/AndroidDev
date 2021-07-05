package ru.geekbrains.homework.Lesson14;

import java.util.Arrays;

public class LastTask {
    public static void main(String[] args) {
        int[] newArr = {1, 4, 3, 4, 3, 4, 7, 8, 9};
        filterArray(newArr);
    }

    public static int[] filterArray(int[] inputArray) throws RuntimeException {
        int lastIndex = -1;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] == 4) {
                lastIndex = i;
                break;
            }
        }

        if (lastIndex == -1) throw new RuntimeException();

        return Arrays.copyOfRange(inputArray, lastIndex + 1, inputArray.length);
    }
}
