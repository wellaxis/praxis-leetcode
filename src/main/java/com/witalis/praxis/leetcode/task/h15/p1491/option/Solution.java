package com.witalis.praxis.leetcode.task.h15.p1491.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1491
 * Name: Average Salary Excluding the Minimum and Maximum Salary
 * URL: <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/">Average Salary Excluding the Minimum and Maximum Salary</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] salaries;

    public Double process() {
        return average(salaries);
    }

    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : salary) {
            max = Math.max(n, max);
            min = Math.min(n, min);
            sum += n;
        }
        sum -= min + max;

        return (sum + 0.0) / (salary.length - 2);
    }
}
