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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;

    public Integer process() {
        return minimumDeleteSum(string1, string2);
    }

    record Pair(int i1, int i2) {}

    public int minimumDeleteSum(String s1, String s2) {
        if (s1 == null || s2 == null || s1.equals(s2)) return 0;

        final Map<Pair, Integer> memo = new HashMap<>();

        return solver(s1, s2, memo, 0, 0);
    }

    private int solver(String s1, String s2, Map<Pair, Integer> memo, int i1, int i2) {
        final int n1 = s1.length();
        final int n2 = s2.length();

        if (i1 >= n1 && i2 >= n2) return 0;
        Pair pair = new Pair(i1, i2);

        if (memo.containsKey(pair)) return memo.get(pair);

        if (i1 == n1) {
            int ascii = s2.charAt(i2) + solver(s1, s2, memo, i1, i2 + 1);
            memo.put(pair, ascii);
            return ascii;
        }

        if (i2 == n2) {
            int ascii = s1.charAt(i1) + solver(s1, s2, memo, i1 + 1, i2);
            memo.put(pair, ascii);
            return ascii;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            int ascii = solver(s1, s2, memo, i1 + 1, i2 + 1);
            memo.put(pair, ascii);
            return ascii;
        }

        int ascii1 = s1.charAt(i1) + solver(s1, s2, memo, i1 + 1, i2);
        int ascii2 = s2.charAt(i2) + solver(s1, s2, memo, i1, i2 + 1);
        memo.put(pair, Math.min(ascii1, ascii2));

        return memo.get(pair);
    }
}
