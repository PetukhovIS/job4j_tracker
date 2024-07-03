package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lim = Math.min(left.length(), right.length());
        int k = 0;
        while (k < lim) {
            if (left.charAt(k) != right.charAt(k)) {
                return Character.compare(left.charAt(k), right.charAt(k));
            }
            k++;
        }
        return Integer.compare(left.length(), right.length());
    }
}
