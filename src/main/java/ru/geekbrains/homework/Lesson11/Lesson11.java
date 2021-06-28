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

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Test_1", "89999999999");
        phoneBook.add("Test_2", "87777777777");
        phoneBook.add("Test_1", "86666666666");
        phoneBook.get("Test_1");
        phoneBook.get("Test_2");
    }

    public static ArrayList<String> checkUniqueWords(String[] wordsArr) {
        ArrayList<String> foundWords = new ArrayList<>();
        for (String word : wordsArr) {
            if (!foundWords.contains(word)) {
                foundWords.add(word);
            }
        }
        return foundWords;
    }
}
