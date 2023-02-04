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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;

    public Boolean process() {
        return checkInclusion(string1, string2);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;

        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        char[] letters1 = s1.toCharArray();
        Arrays.sort(letters1);

        char[] letters2;
        for (int i = 0; i <= len2 - len1; i++) {
            letters2 = s2.substring(i, i + len1).toCharArray();
            Arrays.sort(letters2);
            if (Arrays.equals(letters1, letters2)) return true;
        }

        return false;
    }
}
