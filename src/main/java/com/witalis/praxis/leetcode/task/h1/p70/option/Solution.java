package com.witalis.praxis.leetcode.task.h1.p70.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 70
 * Name: Climbing Stairs
 * URL: <a href="https://leetcode.com/problems/climbing-stairs/">Climbing Stairs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return climbStairs(number);
    }

    public int climbStairs(int n) {
        int pre = 1;
        int curr = 1;
        int temp;

        for (int i = 1; i < n; i++) {
            temp = curr;
            curr += pre;
            pre = temp;
        }
        return curr;
    }
}
