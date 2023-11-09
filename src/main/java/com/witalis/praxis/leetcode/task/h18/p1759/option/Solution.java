package com.witalis.praxis.leetcode.task.h18.p1759.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1759
 * Name: Count Number of Homogenous Substrings
 * URL: <a href="https://leetcode.com/problems/count-number-of-homogenous-substrings/">Count Number of Homogenous Substrings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return countHomogenous(string);
    }

    public int countHomogenous(String s) {
        long res = 0;
        char[] c = s.toCharArray();
        int start = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != c[start]) {
                int appear = i - start;
                while (appear > 0) {
                    res += appear;
                    appear--;
                }
                start = i;
            }
        }

        int appear = c.length - start;
        while (appear > 0) {
            res += appear;
            appear--;
        }

        return (int) (res % (Math.pow(10, 9) + 7));
    }
}
