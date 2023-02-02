package com.witalis.praxis.leetcode.task.h10.p953.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 953
 * Name: Verifying an Alien Dictionary
 * URL: <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/">Verifying an Alien Dictionary</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;
    private String order;

    public Boolean process() {
        return isAlienSorted(words, order);
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || order == null) return false;

        final Map<Character, Integer> positions = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            positions.put(order.charAt(i), i);
        }

        int count = words.length;
        for (int w = 1; w < count; w++) {
            final String current = words[w];
            final String previous = words[w - 1];

            final int len = Math.min(current.length(), previous.length());
            int pos = 0;
            while (pos < len) {
                final int curr = positions.get(current.charAt(pos));
                final int prev = positions.get(previous.charAt(pos));

                if (curr < prev) return false;
                if (curr > prev) break;
                pos++;
            }
            if (pos == len && current.length() < previous.length()) return false;
        }

        return true;
    }
}
