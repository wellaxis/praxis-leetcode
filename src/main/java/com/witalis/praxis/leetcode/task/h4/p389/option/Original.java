package com.witalis.praxis.leetcode.task.h4.p389.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 389
 * Name: Find the Difference
 * URL: <a href="https://leetcode.com/problems/find-the-difference/">Find the Difference</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String s;
    private String t;

    public Character process() {
        return findTheDifference(s, t);
    }

    public char findTheDifference(String s, String t) {
        if (s == null || t == null) throw new IllegalArgumentException("incorrect input data");

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] != tArray[i]) return tArray[i];
        }

        return tArray[t.length() - 1];
    }
}
