package com.witalis.praxis.leetcode.task.h24.p2305.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2305
 * Name: Fair Distribution of Cookies
 * URL: <a href="https://leetcode.com/problems/fair-distribution-of-cookies/">Fair Distribution of Cookies</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] cookies;
    private int children;

    public Solution(int[] cookies, int children) {
        this.cookies = cookies;
        this.children = children;
    }

    public Integer process() {
        return distributeCookies(cookies, children);
    }

    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] freq = new int[k];
        backtrack(cookies, freq, 0, k);

        return ans;
    }

    private void backtrack(int[] cookies, int[] freq, int start, int k) {
        if (start == cookies.length) {
            int max = 0;
            for (int f : freq) {
                max = Math.max(f, max);
            }
            ans = Math.min(ans, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            freq[i] += cookies[start];
            backtrack(cookies, freq, start + 1, k);
            freq[i] -= cookies[start];
            if (freq[i] == 0) break;
        }
    }
}
