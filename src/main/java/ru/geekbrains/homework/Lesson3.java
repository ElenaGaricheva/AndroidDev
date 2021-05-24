package ru.geekbrains.homework;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        guessNumberGame();
    }

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
        restartGame();
    }

    public static void checkNumber(int userNumber, int makeNumber) {
        if (userNumber < makeNumber) {
            System.out.println("Введенное число меньше загаданного.");
        } else if (userNumber > makeNumber) {
            System.out.println("Введенное число больше загаданного.");
        } else {
            System.out.println("Поздравляю, вы угадали число! Повторить игру? YES/NO");
            restartGame();
        }
    }

    public static void restartGame() {
        switch (scanner.next()) {
            case "YES", "yes", "y", "Y" -> guessNumberGame();
            case "NO", "no", "N" -> System.exit(0);
        }
    }
}
