package com.witalis.praxis.leetcode.task.h19.p1805.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 1805
 * Name: Number of Different Integers in a String
 * URL: <a href="https://leetcode.com/problems/number-of-different-integers-in-a-string/">Number of Different Integers in a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String word;

    public Integer process() {
        return numDifferentIntegers(word);
    }

    public int numDifferentIntegers(String word) {
        if (word == null || word.isEmpty()) return 0;

        final Set<String> integers = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) continue;

            int begin = i;
            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                if (begin == i - 1 && word.charAt(begin) == '0') {
                    begin++;
                }
                i++;
            }

            integers.add(word.substring(begin, i));
        }

        return integers.size();
    }
}
