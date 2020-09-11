package ru.geegbrains.java02.lesson03;

import java.util.*;

/*
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 *
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 *
 * С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 *
 * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять
 * еще дополнительные поля (имя, отчество, адрес),
 * делать взаимодействие с пользователем через консоль и т.д.).
 * Консоль желательно не использовать (в том числе Scanner),
 * тестировать просто из метода main() прописывая add() и get().
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


        Phonebook phonebook = new Phonebook();
        phonebook.addContact("Ivanov", "89267777711");
        phonebook.addContact("Petrov", "89263333333");
        phonebook.addContact("Sidorov", "89265555555");
        phonebook.addContact("Ivanov", "89267777722");

        System.out.println(phonebook.getContact("Ivanov"));
        System.out.println(phonebook.getContact("Petrov"));
        System.out.println(phonebook.getContact("Sidorov"));

    }
}
