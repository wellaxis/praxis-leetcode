package com.witalis.praxis.leetcode.task.h22.p2141.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2141
 * Name: Maximum Running Time of N Computers
 * URL: <a href="https://leetcode.com/problems/maximum-running-time-of-n-computers/">Maximum Running Time of N Computers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int computers;
    private int[] batteries;

    public Long process() {
        return maxRunTime(computers, batteries);
    }

    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries)
            sumPower += power;

        long left = 1;
        long right = sumPower / n;

        while (left < right){
            long target = right - (right - left) / 2;
            long extra = 0;

            for (int power : batteries)
                extra += Math.min(power, target);

            if (extra >= (n * target))
                left = target;
            else
                right = target - 1;
        }

        return left;
    }
}
