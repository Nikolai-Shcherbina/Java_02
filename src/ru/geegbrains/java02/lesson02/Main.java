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

    // task 1: преобразует строку в двумерный массив типа String[][]
    public static String[][] transformsArray(String s) {
        String[] arr = s.split("\n");
        String[][] twoDimensionalArray = new String[arr.length][arr.length];
        try{
            if (twoDimensionalArray.length != 4) throw new ArrayIndexOutOfBoundsException ("размер матрицы, полученной из строки, не равен 4x4");
            for (int i = 0; i < arr.length; i++) {
                twoDimensionalArray[i] = arr[i].split(" ");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("размер матрицы, полученной из строки, не равен 4x4");
        }

        return twoDimensionalArray;
    }

    // task: преобразует 2 все элементы массива в числа типа int
    public static int[][] transformsInt(String[][] arr) {
        int[][] intArr = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                intArr[i][j] = Integer.parseInt(arr[i][j]);
            }
        }
        return intArr;
    }

    // task 2: суммирует, делит полученную сумму на 2, и возвращает результат
    public static int sumDevNumbArr(int[][] arr) {
        int summ = 0;
        int result;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                summ += arr[i][j];
            }
        }
        result = summ / 2;
        return result;
    }

    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] strArray;
        int[][] intArray;

        strArray = transformsArray(str);
        intArray = transformsInt(strArray);
        System.out.println(sumDevNumbArr(intArray));


    }
}

