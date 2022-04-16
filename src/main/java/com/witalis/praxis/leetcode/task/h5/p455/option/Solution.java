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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] factors;
    private int[] cookies;

    public Integer process() {
        return findContentChildren(factors, cookies);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
            }
            sIndex++;
        }

        return gIndex;
    }
}
