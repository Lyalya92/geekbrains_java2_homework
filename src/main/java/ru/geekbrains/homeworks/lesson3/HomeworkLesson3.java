package ru.geekbrains.homeworks.lesson3;

import java.util.*;

public class HomeworkLesson3 {
    public static void main(String[] args) {

//        Задание 1:
//        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать сколько раз встречается каждое слово.

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Banana","Apple","Pear","Banana","Pineapple",
                "Orange","Apple","Banana", "Pineapple", "Banana" ));
        Set<String> listUnique = new HashSet<>();
        listUnique.addAll(list);
        System.out.println("Список уникальных слов:");
        System.out.println(listUnique);

        Iterator<String> iter = listUnique.iterator();
        while (iter.hasNext()){
            int counter = 0;
            String str = iter.next();
            for (String s : list) {
               if (str.equals(s)) { counter++; }
            }
            System.out.printf("%s: %d\n",str,counter);
        }
        System.out.println();


//        Задание 2:
//        Создать телефонный справочник, в котором содержатся фамилии и номера телефона.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи.
//        С помощью метода get() искать номер телефона по фамилии.
        TelephoneBook telephoneBook = new TelephoneBook();
        telephoneBook.add("Иванова", "0998766789");
        telephoneBook.add("Петров", "065757554");
        telephoneBook.add("Козлова", "0985433456");
        telephoneBook.add("Иванова", "0933555589");

        System.out.println("Номера под фамилией Иванова:");
        System.out.println(telephoneBook.get("Иванова"));

        System.out.println("Номера под фамилией Петров:");
        System.out.println(telephoneBook.get("Петров"));
    }
}
