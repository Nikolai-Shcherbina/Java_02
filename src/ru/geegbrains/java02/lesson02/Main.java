package ru.geegbrains.java02.lesson02;

import java.util.Arrays;

/**
 * 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 * 10 3 1 2
 * 2 3 2 2
 * 5 6 7 1
 * 300 3 1 0
 * Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 * ------------------------------------------------------------------------------------------------------------------------------
 * 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 * ------------------------------------------------------------------------------------------------------------------------------
 * 3. Ваши методы должны бросить исключения в случаях:
 * Если размер матрицы, полученной из строки, не равен 4x4;
 * Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 * ------------------------------------------------------------------------------------------------------------------------------
 * 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 * ------------------------------------------------------------------------------------------------------------------------------
 * 5. * Написать собственные классы исключений для каждого из случаев
 * ------------------------------------------------------------------------------------------------------------------------------
 */

public class Main {
    private static final class RowMismatchException extends RuntimeException {
        RowMismatchException(String message) {
            super("Rows exception: " + message);
        }
    }

    private static final class ColumnMismatchException extends RuntimeException {
        ColumnMismatchException(String message) {
            super("Columns exception: " + message);
        }
    }

    private static final class NumberIsNotNumberException extends RuntimeException {
        NumberIsNotNumberException(String message) {
            super("Not a number found: " + message);
        }
    }

    private static final String CORRECT_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private static final String EXTRA_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0\n1 2 3 4";
    private static final String EXTRA_COL_STRING = "1 3 1 2 1\n2 3 2 2 1\n5 6 7 1 1\n3 3 1 0 1";
    private static final String NO_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1";
    private static final String NO_COL_STRING = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static final String HAS_CHAR_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 A";

    private static final int MATRIX_ROWS = 4;
    private static final int MATRIX_COLS = 4;

    // task 1: преобразует строку в двумерный массив типа String[][]
    private static String[][] transformsArray(String s) {
        String[] arr = s.split("\n");
        if (arr.length != MATRIX_ROWS)
            throw new RowMismatchException(arr.length + ":\n" + s);

        String[][] twoDimensionalArray = new String[MATRIX_ROWS][];
        for (int i = 0; i < arr.length; i++) {
            twoDimensionalArray[i] = arr[i].split(" ");
            if (arr.length != MATRIX_COLS)
                throw new ColumnMismatchException(twoDimensionalArray[i].length + ":\n" + s);
        }
        return twoDimensionalArray;
    }

    private static float calcMatrix(String[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    result += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new NumberIsNotNumberException(matrix[i][j]);
                }
            }
        }
        return result / 2f;
    }

    public static void main(String[] args) {
        try {
//            final String[][] matrix = transformsArray(CORRECT_STRING);
//            final String[][] matrix = transformsArray(NO_ROW_STRING);
         final String[][] matrix = transformsArray(NO_COL_STRING);
            // final String[][] matrix = transformsArray(HAS_CHAR_STRING);
            System.out.println(Arrays.deepToString(matrix));
            System.out.println("Half sum = " + calcMatrix(matrix));
        } catch (NumberIsNotNumberException e) {
            System.out.println("A NumberFormatException is thrown: " + e.getMessage());
        } catch (RowMismatchException | ColumnMismatchException e) {
            System.out.println("A RuntimeException successor is thrown: " + e.getMessage());
        }
    }
}

