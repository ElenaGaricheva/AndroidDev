package ru.geekbrains.homework.Lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<String>(List.of(phoneNumber)));
        } else {
            phoneBook.get(name).add(phoneNumber);
        }
    }

    public void get(String name) {
        System.out.printf("%s: %s\n", name, phoneBook.get(name).toString());
    }
}
