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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String word;

    public Integer process() {
        return numDifferentIntegers(word);
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();

        int start = 0;
        while (start < word.length()) {
            if (Character.isDigit(word.charAt(start))) {
                int end = start;
                while (end < word.length() && Character.isDigit(word.charAt(end))) {
                    end++;
                }
                while (start < end && word.charAt(start) == '0') {
                    start++;
                }
                set.add(word.substring(start, end));
                start = end;
            } else {
                start++;
            }
        }

        return set.size();
    }
}
