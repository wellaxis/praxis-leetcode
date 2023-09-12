package com.witalis.praxis.leetcode.task.h17.p1647.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ID: 1647
 * Name: Minimum Deletions to Make Character Frequencies Unique
 * URL: <a href="https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/">Minimum Deletions to Make Character Frequencies Unique</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return minDeletions(string);
    }

    public int minDeletions(String s) {
        if (s == null || s.isEmpty()) return 0;

        char[] letters = s.toCharArray();
        Map<Character, Integer> frequencies = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        AtomicInteger deletions = new AtomicInteger();

        for (char letter : letters)
            frequencies.put(letter, frequencies.getOrDefault(letter, 0) + 1);

        frequencies.forEach(
            (letter, frequency) -> {
                int quantity = frequency;
                while (quantity > 0 && seen.contains(quantity)) {
                    quantity--;
                    deletions.getAndIncrement();
                }
                seen.add(quantity);
            }
        );

        return deletions.get();
    }
}
