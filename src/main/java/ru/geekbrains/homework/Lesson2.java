package ru.geekbrains.homework;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(oneToZero()));
        System.out.println(Arrays.toString(fillArray()));
        System.out.println(Arrays.toString(multiplyArrayElements()));
        rewriteDiagonal();
        minMaxElement();
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        moveArrItems(new int[]{1, 2, 3, 4}, -3);
    }

    //Task 1
    public static int[] oneToZero() {
        int[] numArr = {1, 0, 0, 1, 0, 1, 1};

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (numArr[i] == 1) ? 0 : 1;
        }

        return numArr;
    }

    //Task 2
    public static int[] fillArray() {
        int[] newArray = new int[8];
        int newValue = 0;

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newValue;
            newValue += 3;
        }

        return newArray;
    }

    //Task 3
    public static int[] multiplyArrayElements() {
        int[] numbersArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] < 6) {
                numbersArray[i] *= 2;
            }
        }

        return numbersArray;
    }

    //Task 4
    public static void rewriteDiagonal() {
        int[][] twoDimArray = {
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4}
        };

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray.length; j++) {
                if (i == j) {
                    twoDimArray[i][j] = 1;
                }
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Task 5
    public static void minMaxElement() {
        int[] numArray = {5, 1, 9, 1, 2, 145, 3};
        int maxValue = numArray[0], minValue = numArray[0];

        for (int i : numArray) {
            maxValue = Math.max(maxValue, i);
            minValue = Math.min(minValue, i);
        }

        System.out.println("maxValue = " + maxValue + ", minValue = " + minValue);
    }

    //Task 6
    public static boolean checkBalance(int[] numArr) {
        int firstHalf = 0, secondHalf = 0;
        int lastIndex = numArr.length - 1;

        if (numArr.length <= 1) {
            return false;
        }

        for (int firstIndex = 0; firstIndex <= lastIndex; ) {
            if (firstHalf < secondHalf) {
                firstHalf += numArr[firstIndex];
                firstIndex++;
            } else {
                secondHalf += numArr[lastIndex];
                lastIndex--;
            }
        }
        return firstHalf == secondHalf;
    }

    //Task 7
    public static void moveArrItems(int[] numArr, int steps) {
        int arrLength = numArr.length;
        int numSteps = steps % arrLength;
        int[] addArr = new int[arrLength];

        if (numSteps != 0) {
            for (int i = 0; i < arrLength; i++) {
                int newPosition = numSteps > 0 ?
                        i + numSteps : i + arrLength - Math.abs(numSteps);
                if (newPosition < arrLength) {
                    addArr[newPosition] = numArr[i];
                } else {
                    addArr[newPosition - arrLength] = numArr[i];
                }
            }
            System.out.println(Arrays.toString(addArr));
        } else System.out.println(Arrays.toString(numArr));
    }
}
