package ru.geekbrains.homework.Lesson11;

import java.util.ArrayList;
import java.util.Collections;

public class Lesson11 {
    public static void main(String[] args) {
        String[] wordsArray = {
                "one", "two", "three",
                "four", "five", "six",
                "six", "six", "six", "two",
                "two", "two", "two", "five",
                "five", "five"
        };
        System.out.println(checkUniqueWords(wordsArray));
    }

    public static ArrayList<String> checkUniqueWords(String[] wordsArr){
        ArrayList<String> foundWords = new ArrayList<>();
        for (String word: wordsArr) {
            if (!foundWords.contains(word)) {
                foundWords.add(word);
            }
        }
        return foundWords;
    }
}
