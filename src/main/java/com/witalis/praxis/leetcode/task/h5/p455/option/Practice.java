package com.witalis.praxis.leetcode.task.h5.p455.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 455
 * Name: Assign Cookies
 * URL: <a href="https://leetcode.com/problems/assign-cookies/">Assign Cookies</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] factors;
    private int[] cookies;

    public Integer process() {
        return findContentChildren(factors, cookies);
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) return 0;

        int sum = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si++] >= g[gi]) {
                sum++;
                gi++;
            }
        }

        return sum;
    }
}
