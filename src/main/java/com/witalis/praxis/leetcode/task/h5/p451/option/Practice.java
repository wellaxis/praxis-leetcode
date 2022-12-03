package com.witalis.praxis.leetcode.task.h5.p451.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * ID: 451
 * Name: Sort Characters By Frequency
 * URL: <a href="https://leetcode.com/problems/sort-characters-by-frequency/">Sort Characters By Frequency</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return frequencySort(string);
    }

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;

        Map<Character, Integer> frequencies = new HashMap<>();
        for (char letter : s.toCharArray()) {
            frequencies.put(letter, frequencies.getOrDefault(letter, 0) + 1);
        }
        Map<Character, Integer> sortedFrequencies = sortByValues(frequencies);
        StringBuilder builder = new StringBuilder();
        sortedFrequencies.forEach(
            (letter, frequency) -> builder.append(String.valueOf(letter.charValue()).repeat(frequency))
        );

        return builder.toString();
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = (k1, k2) -> {
            int compare = map.get(k2).compareTo(map.get(k1));
            if (compare == 0) return 1;
            else return compare;
        };
        Map<K, V> sortedByValues = new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
