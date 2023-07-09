package com.witalis.praxis.leetcode.task.h23.p2272.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2272
 * Name: Substring With Largest Variance
 * URL: <a href="https://leetcode.com/problems/substring-with-largest-variance/">Substring With Largest Variance</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return largestVariance(string);
    }

    public int largestVariance(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int n = s.length();

        final char[] direct = s.toCharArray();
        int v1 = helper(direct);

        final char[] reverse = new char[n];
        for (int i = 0; i < n; i++)
            reverse[i] = direct[n - 1 - i];
        int v2 = helper(reverse);

        return Math.max(v1, v2);
    }

    private static int helper(char[] letters) {
        int variance = 0;

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i != j) {
                    int count1 = 0;
                    int count2 = 0;
                    for (char letter : letters) {
                        if (letter == i) count1++;
                        if (letter == j) count2++;

                        if (count2 > count1) {
                            count1 = 0;
                            count2 = 0;
                        }
                        if (count1 > 0 && count2 > 0) {
                            variance = Math.max(variance, count1 - count2);
                        }
                    }
                }
            }
        }

        return variance;
    }
}
