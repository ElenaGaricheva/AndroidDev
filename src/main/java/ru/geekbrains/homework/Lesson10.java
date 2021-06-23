package ru.geekbrains.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson10 {
    public static void main(String[] args) {
        ArrayList<String> testList = new ArrayList<>(List.of("one", "two", "three", "four"));

        swapPlaces(testList, 0, 3);
    }

    //Task 1
    public static void swapPlaces(ArrayList<String> arrayList, int firstPos, int secondPos){
        Collections.swap(arrayList, firstPos, secondPos);
    }
}
