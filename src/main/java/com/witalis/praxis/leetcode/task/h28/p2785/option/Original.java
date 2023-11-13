package com.witalis.praxis.leetcode.task.h28.p2785.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * ID: 2785
 * Name: Sort Vowels in a String
 * URL: <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">Sort Vowels in a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return sortVowels(string);
    }

    public String sortVowels(String s) {
        if (s == null || s.isEmpty()) return "";

        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        final Comparator<Character> byAscii = Comparator.naturalOrder();
        final Queue<Character> heap = new PriorityQueue<>(byAscii);

        char[] letters = s.toCharArray();
        for (char letter : letters)
            if (vowels.contains(letter))
                heap.offer(letter);

        StringBuilder builder = new StringBuilder();
        for (char letter : letters)
            if (vowels.contains(letter))
                builder.append(heap.poll());
            else
                builder.append(letter);

        return builder.toString();
    }
}
