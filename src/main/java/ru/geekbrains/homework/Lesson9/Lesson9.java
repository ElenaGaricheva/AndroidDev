package ru.geekbrains.homework.Lesson9;

public class Lesson9 {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] stringsArr = {
                {"1", "2", "3", "4"},
                {"A", "_", "7", "8"},
                {"9", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        checkArray(stringsArr);
    }

    public static void checkArray(String[][] stringsArr) throws MyArraySizeException, MyArrayDataException {
        if (!checkArrSize(stringsArr, 4)) {
            throw new MyArraySizeException(
                    "Размер массива не соответствует ожидаемому");
        }
        arrFormat(stringsArr);
    }


    private static int arrFormat(String[][] stringsArr) throws MyArrayDataException {
        int arrElementSum = 0;
        for (int i = 0; i < stringsArr.length; i++) {
            for (int j = 0; j < stringsArr.length; j++)
                try {
                    arrElementSum += Integer.parseInt(stringsArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Не удалось преобразовать элемент массива %s " +
                            "в ячейке [%d, %d]", stringsArr[i][j], i, j));
                }
        }
        return arrElementSum;
    }

    private static boolean checkArrSize(String[][] stringsArr, int expectedSize) {
        if (stringsArr.length == expectedSize) {
            for (String[] stringArr : stringsArr) {
                if (stringArr.length != expectedSize) {
                    return false;
                }
            }
            return true;
        } else return false;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
}