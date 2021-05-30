package ru.geekbrains.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static char[][] map;
    public static int mapSize;
    public static int victorySize;
    public static char userIcon = 'X';
    public static char aiIcon = 'O';
    public static char emptyIcon = '.';
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();

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

    public static void initMap(int mapSize) {
        map = new char[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = emptyIcon;
            }
        }
    }

    public static void printMap() {
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

    public static void userStep() {
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

    public static void aiStep() {
        int aiStepX = rand.nextInt(mapSize);
        int aiStepY = rand.nextInt(mapSize);
        if (checkCell(aiStepX, aiStepY) && !isFullMap()) {
            map[aiStepY][aiStepX] = aiIcon;
            System.out.println("Ход компьютера с координатами X = " + (aiStepX + 1) + ", Y = " + (aiStepY + 1));
            printMap();
        } else aiStep();
    }

    public static boolean checkCell(int x, int y) {
        if ((x < mapSize) && (x >= 0) && (y >= 0) && (y < mapSize)) {
            return map[y][x] == emptyIcon;
        } else return false;
    }

    public static boolean isFullMap() {
        for (char[] s : map) {
            if (Arrays.toString(s).indexOf(emptyIcon) > -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkVictory(char playerIcon, int victorySize) {
        int counter = 0;

        counter = checkMap(victorySize, playerIcon, map);

        //Если при первой проверке строк и диагонали ничего не найдено, переворачиваю массив,
        // чтобы с той же логикой пройти по столбцам и диагонали в другом направлении.
        if (counter < victorySize) {
            char[][] buffMap = new char[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    buffMap[i][j] = map[mapSize - 1 - j][i];
                }
            }
            counter = checkMap(victorySize, playerIcon, buffMap);
        }

        return counter == victorySize;
    }

    public static int checkMap(int victorySize, char playerIcon, char[][] buffMap) {
        int counter = 0;

        //Проверка строк
        for (int i = 0; i < mapSize; i++) {
            if (counter < victorySize) {
                counter = 0;
                for (int j = 0; j < mapSize; j++) {
                    if (counter < victorySize) {
                        counter = buffMap[i][j] == playerIcon ? counter + 1 : 0;
                    }
                }
            }
        }

        //Проверка всех диагональней
        if (counter < victorySize) {
            counter = 0;
            int size = mapSize;
            for (int i = 0; i < size; i++) {
                if (counter < victorySize) {
                    counter = 0;
                    for (int j = 0; j < size; j++) {
                        counter = buffMap[i + j][j] == playerIcon ? counter + 1 : 0;
                    }

                    if (counter < victorySize) {
                        counter = 0;
                        for (int j = 0; j < size; j++) {
                            counter = buffMap[j][i + j] == playerIcon ? counter + 1 : 0;
                        }
                    }
                }
                size--;
            }
        }
        return counter;
    }
}