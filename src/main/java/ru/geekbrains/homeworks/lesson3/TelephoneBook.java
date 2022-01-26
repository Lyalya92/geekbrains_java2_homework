package ru.geekbrains.homeworks.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneBook {
    private Map<String, String> telephoneBook = new HashMap<>();

    public List<String> get (String surname){
        List<String> numbers = new ArrayList<>();
        for (String key : telephoneBook.keySet()) {
            if (telephoneBook.get(key).equals(surname)){
                numbers.add(key);
            }
        }
        return numbers;
    }

    public void add (String surname, String number) {
        this.telephoneBook.put(number,surname);
    }
}
