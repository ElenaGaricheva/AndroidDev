package ru.geekbrains.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static char[][] map;
    public static int mapSize;
    public static int victorySize;
    static final char userIcon = 'X';
    static final char aiIcon = 'O';
    static final char emptyIcon = '.';
    static final Scanner scan = new Scanner(System.in);
    static final Random rand = new Random();

    public static void main(String[] args) {
        initGame();

        while (!isFullMap()) {
            userStep();

            if (checkVictory(userIcon, victorySize)) {
                System.out.println("Вы выиграли!");
                System.exit(0);
            } else if (!isFullMap()) {
                aiStep();
            }

            if (checkVictory(aiIcon, victorySize)) {
                System.out.println("Выиграл компьютер!");
                System.exit(0);
            }
        }
        if (isFullMap() && checkVictory(userIcon, victorySize) == checkVictory(aiIcon, victorySize)) {
            System.out.println("Ничья!");
            System.exit(0);
        }
    }

    public static void initGame() {
        System.out.print("Укажите размер игрового поля: ");
        mapSize = scan.nextInt();
        System.out.print("Укажите размер выигрышного набора: ");
        victorySize = scan.nextInt();
        initMap(mapSize);
        printMap();
    }

    private static void initMap(int mapSize) {
        map = new char[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = emptyIcon;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= mapSize; i++) {
            System.out.print(i + " ");
        }

        for (int i = 0; i < mapSize; i++) {
            System.out.println();
            System.out.print(i + 1 + " ");
            for (int j = 0; j < mapSize; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static void userStep() {
        System.out.println("Укажите координаты своего хода");
        System.out.print("Введите координату X: ");
        int userStepX = scan.nextInt() - 1;
        System.out.print("Введите координату Y: ");
        int userStepY = scan.nextInt() - 1;

        if (checkCell(userStepX, userStepY) && !isFullMap()) {
            map[userStepY][userStepX] = userIcon;
            printMap();
        } else if (!isFullMap()) {
            System.out.println("Вы ввели некорректные координаты!");
            userStep();
        }

    }

    private static void aiStep() {
        int aiStepX = rand.nextInt(mapSize);
        int aiStepY = rand.nextInt(mapSize);
        if (checkCell(aiStepX, aiStepY) && !isFullMap()) {
            map[aiStepY][aiStepX] = aiIcon;
            System.out.println("Ход компьютера с координатами X = " + (aiStepX + 1) + ", Y = " + (aiStepY + 1));
            printMap();
        } else aiStep();
    }

    private static boolean checkCell(int x, int y) {
        if ((x < mapSize) && (x >= 0) && (y >= 0) && (y < mapSize)) {
            return map[y][x] == emptyIcon;
        } else return false;
    }

    private static boolean isFullMap() {
        for (char[] s : map) {
            if (Arrays.toString(s).indexOf(emptyIcon) > -1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkVictory(char playerIcon, int victorySize) {
        boolean counter;

        counter = checkMap(victorySize, playerIcon, map);

        //Если при первой проверке строк и диагонали ничего не найдено, переворачиваю массив,
        // чтобы с той же логикой пройти по столбцам и диагоналям в другом направлении.
        if (!counter) {
            char[][] buffMap = turnMap(map);
            counter = checkMap(victorySize, playerIcon, buffMap);
        }

        return counter;
    }

    private static boolean checkMap(int victorySize, char playerIcon, char[][] map) {
        if (!checkLine(victorySize, playerIcon, map)) {
            return checkDiagonal(victorySize, playerIcon, map);
        }
        return true;
    }

    private static boolean checkLine(int victorySize, char playerIcon, char[][] map) {
        int counter = 0;

        for (int i = 0; i < mapSize; i++) {
            if (counter < victorySize) {
                counter = 0;
                for (int j = 0; j < mapSize; j++) {
                    if (counter < victorySize) {
                        counter = map[i][j] == playerIcon ? counter + 1 : 0;
                        if (counter == victorySize) return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonal(int victorySize, char playerIcon, char[][] map) {
        int counter = 0;
        int size = mapSize;

        for (int i = 0; i < mapSize; i++) {
            if (counter < victorySize) {
                counter = 0;
                for (int j = 0; j < size; j++) {
                    counter = map[i + j][j] == playerIcon ? counter + 1 : 0;
                    if (counter == victorySize) return true;
                }

                if (counter < victorySize) {
                    counter = 0;
                    for (int j = 0; j < size; j++) {
                        counter = map[j][i + j] == playerIcon ? counter + 1 : 0;
                        if (counter == victorySize) return true;
                    }
                }
            }
            size--;
        }
        return false;
    }

    private static char[][] turnMap(char[][] map) {
        char[][] buffMap = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                buffMap[i][j] = map[mapSize - 1 - j][i];
            }
        }
        return buffMap;
    }
}