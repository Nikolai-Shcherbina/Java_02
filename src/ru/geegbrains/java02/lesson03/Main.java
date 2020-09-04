package ru.geegbrains.java02.lesson03;

import java.util.*;

/*
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 */
public class Main {


    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "cucumber", "tomato", "banana", "watermelon", "bread",
                "banana", "potatoes", "corn", "cabbage", "plum",
                "apple", "plum", "carrot", "mushrooms", "water",
                "mushrooms", "cabbage", "corn", "carrot", "potatoes"
        );

        Set<String> uniqueList = new HashSet<String>(words);
        System.out.println("Уникальные слова из списка: " + uniqueList.toString());

        for (String key : uniqueList) {
            System.out.print(key + ": " + Collections.frequency(words, key) + "; ");
        }
    }
}
