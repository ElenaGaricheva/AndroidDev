package ru.geekbrains.homework;

import java.util.*;

public class Lesson3 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        guessNumberGame();
        guessWordGame();
    }

    //Task 1
    public static void guessNumberGame() {
        int makeNumber = random.nextInt(10);
        int counter = 0;

        System.out.println("Загадано число от 0 до 9. Попробуйте угадать его с трех попыток!");

        do {
            System.out.print("Введите число: ");
            checkNumber(scanner.nextInt(), makeNumber);
            counter++;
        }
        while (counter < 3);

        System.out.println("Игра завершена! Вы не угадали число( Повторить игру? YES/NO");
        restartGuessNumberGame();
    }

    public static void checkNumber(int userNumber, int makeNumber) {
        if (userNumber < makeNumber) {
            System.out.println("Введенное число меньше загаданного.");
        } else if (userNumber > makeNumber) {
            System.out.println("Введенное число больше загаданного.");
        } else {
            System.out.println("Поздравляю, вы угадали число! Повторить игру? YES/NO");
            restartGuessNumberGame();
        }
    }

    public static void restartGuessNumberGame() {
        switch (scanner.next()) {
            case "YES", "yes", "y", "Y" -> guessNumberGame();
            case "NO", "no", "N" -> System.exit(0);
        }
    }

    //Task 2
    public static void guessWordGame() {
        String[] words = new String[]{
                "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"
        };
        int wordPos = random.nextInt(words.length);
        String makeWord = words[wordPos];
        System.out.println(makeWord);

        System.out.println("Загадано слово! Попробуйте его угадать!");
        while (true) {
            System.out.print("Введите слово: ");
            checkWord(scanner.next(), makeWord);
        }
    }

    public static void checkWord(String userWord, String makeWord) {
        if (userWord.equals(makeWord)) {
            System.out.printf("Поздравляю! Вы угадали слово %s!\nПовторить игру? YES/NO\n", makeWord);
            restartGuessWordGame();
        } else {
            String mask = "###############";
            char[] guessChar = mask.toCharArray();
            int wordLength = Math.min(userWord.length(), makeWord.length());
            int counter = 0;

            for (int i = 0; i < wordLength; i++) {
                if (makeWord.charAt(i) == userWord.charAt(i)) {
                    guessChar[i] = makeWord.charAt(i);
                    counter++;
                }
            }

            mask = new String(guessChar);

            if (counter > 0) {
                System.out.printf("%s\nВы близки к победе! Попробуйте еще раз!\n", mask);
            } else {
                System.out.println("Не угадали! Попробуйте еще раз!");
            }
        }
    }

    public static void restartGuessWordGame() {
        switch (scanner.next()) {
            case "YES", "yes", "y", "Y" -> guessWordGame();
            case "NO", "no", "N" -> System.exit(0);
        }
    }
}
