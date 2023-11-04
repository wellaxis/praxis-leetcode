package com.witalis.praxis.leetcode.task.h16.p1503.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1503
 * Name: Last Moment Before All Ants Fall Out of a Plank
 * URL: <a href="https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/">Last Moment Before All Ants Fall Out of a Plank</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[] left;
    private int[] right;

    public Integer process() {
        return getLastMoment(number, left, right);
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        if (n <= 0 || left == null || right == null) return 0;

        int lastMoment = 0;

        for (int leftPosition : left)
            lastMoment = Math.max(lastMoment, leftPosition);

        for (int rightPosition : right)
            lastMoment = Math.max(lastMoment, n - rightPosition);

        return lastMoment;
    }
}
