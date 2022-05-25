package com.witalis.praxis.leetcode.task.h14.p1399.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1399
 * Name: Count Largest Group
 * URL: <a href="https://leetcode.com/problems/count-largest-group/">Count Largest Group</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return countLargestGroup(number);
    }

    public int countLargestGroup(int n) {
        int[] cnt = new int[37];
        for (int i = 0; i < 37; i++) cnt[i] = 0;

        int mx = 0;
        for (int i = 1; i <= n; i++) {
            int s = sumDigits(i);
            cnt[s]++;
            if (cnt[s] > mx) mx = cnt[s];
        }

        int ans = 0;
        for (int i = 0; i < 37; i++) {
            if (cnt[i] == mx) ans++;
        }
        return ans;
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
