package ru.geegbrains.java02.lesson05;

import java.util.Arrays;

/**
 * 1. Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * <p>
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 * <p>
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 * <p>
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 * <p>
 * Пример деления одного массива на два:
 * <p>
 * System.arraycopy(arr, 0, a1, 0, h);
 * System.arraycopy(arr, h, a2, 0, h);
 * <p>
 * Пример обратной склейки:
 * <p>
 * System.arraycopy(a1, 0, arr, 0, h);
 * System.arraycopy(a2, 0, arr, h, h);
 * <p>
 * Примечание:
 * System.arraycopy() – копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * <p>
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 * <p>
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */
public class Main extends Thread {
    private final static Object monitor = new Object();
    static final int size = 10000000;
    static final int h = size / 2;

    // просто бежит по массиву и вычисляет значения
    public static void method1() {
        float[] arr = new float[size];
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.print("method1: ");
        System.out.println(System.currentTimeMillis() - a);
    }

    // Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
    public static void method2() {
        float[] arr = new float[size];
        float[] arr2 = new float[size];
        float[] arr3 = new float[size];
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        //деления одного массива на два:
        System.currentTimeMillis();
        System.arraycopy(arr, 0, arr2, 0, h);
        System.arraycopy(arr, h, arr3, 0, h);
        calculatesValues(arr2);

        calculatesValues(arr3);

        // обратная склейки:
        System.currentTimeMillis();
        System.arraycopy(arr2, 0, arr, 0, h);
        System.arraycopy(arr3, 0, arr, h, h);

        System.currentTimeMillis();
        System.out.print("method2: ");
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void calculatesValues(float[] arr) {
        System.out.println("Hello from " + Thread.currentThread().getName());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        new Thread(r).start();
    }

    public static void main(String[] args) {
        Main thread1 = new Main();
        Main thread2 = new Main();

        method1();
        method2();
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();

    }


}

