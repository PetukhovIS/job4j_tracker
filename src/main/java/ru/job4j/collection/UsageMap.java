package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Petukhov.IS.96@yandex.ru", "Petukhov");
        map.put("Petukhov.IS.96@yandex.ru", "Ilya Petukhov");
        map.put("Petukhov.IS.96@gmail.com", "Ilya Cashtanov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
