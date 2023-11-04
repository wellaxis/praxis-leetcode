package com.witalis.praxis.leetcode.task.h16.p1503.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1503
 * Name: Last Moment Before All Ants Fall Out of a Plank
 * URL: <a href="https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/">Last Moment Before All Ants Fall Out of a Plank</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[] left;
    private int[] right;

    public Integer process() {
        return getLastMoment(number, left, right);
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;

        for (int num : left) {
            ans = Math.max(ans, num);
        }

        for (int num : right) {
            ans = Math.max(ans, n - num);
        }

        return ans;
    }
}
