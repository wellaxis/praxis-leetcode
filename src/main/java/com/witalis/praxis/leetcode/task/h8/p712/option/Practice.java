package com.witalis.praxis.leetcode.task.h8.p712.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 712
 * Name: Minimum ASCII Delete Sum for Two Strings
 * URL: <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/">Minimum ASCII Delete Sum for Two Strings</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string1;
    private String string2;

    public Practice(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public Integer process() {
        return minimumDeleteSum(string1, string2);
    }

    record Pair(int i1, int i2) {}

    private Map<Pair, Integer> memo;

    public int minimumDeleteSum(String s1, String s2) {
        if (s1 == null || s2 == null || s1.equals(s2)) return 0;

        this.memo = new HashMap<>();

        return solver(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    private int solver(char[] c1, char[] c2, int i1, int i2) {
        if (i1 >= c1.length && i2 >= c2.length) return 0;

        Pair pair = new Pair(i1, i2);

        if (memo.containsKey(pair)) return memo.get(pair);

        int ascii;

        if (i1 == c1.length)
            ascii = c2[i2] + solver(c1, c2, i1, i2 + 1);
        else if (i2 == c2.length)
            ascii = c1[i1] + solver(c1, c2, i1 + 1, i2);
        else if (c1[i1] == c2[i2])
            ascii = solver(c1, c2, i1 + 1, i2 + 1);
        else
            ascii = Math.min(c1[i1] + solver(c1, c2, i1 + 1, i2), c2[i2] + solver(c1, c2,  i1, i2 + 1));

        memo.put(pair, ascii);

        return ascii;
    }
}
