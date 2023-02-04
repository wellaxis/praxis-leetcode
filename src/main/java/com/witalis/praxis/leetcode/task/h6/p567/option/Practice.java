package com.witalis.praxis.leetcode.task.h6.p567.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * ID: 567
 * Name: Permutation in String
 * URL: <a href="https://leetcode.com/problems/permutation-in-string/">Permutation in String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string1;
    private String string2;

    public Boolean process() {
        return checkInclusion(string1, string2);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;

        final int len1 = s1.length();
        final int len2 = s2.length();
        if (len1 > len2) return false;

        final Map<Character, Long> permutations = s1.chars()
            .mapToObj(c -> (char) c)
            .collect(groupingBy(Function.identity(), counting()));

        int position = 0;
        int overlaps = 0;

        char left;
        char right;
        for (int i = 0; i < len2; i++) {
            left = s2.charAt(position);
            right = s2.charAt(i);

            if (permutations.containsKey(right)) {
                permutations.put(right, permutations.get(right) - 1);
                if (permutations.get(right) == 0) overlaps++;
            }

            if (overlaps == permutations.size()) return true;

            if (i >= len1 - 1) {
                if (permutations.containsKey(left)) {
                    if (permutations.get(left) == 0) overlaps--;
                    permutations.put(left, permutations.get(left) + 1);
                }
                position++;
            }
        }

        return false;
    }
}
