package com.witalis.praxis.leetcode.task.h15.p1491.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1491
 * Name: Average Salary Excluding the Minimum and Maximum Salary
 * URL: <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/">Average Salary Excluding the Minimum and Maximum Salary</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] salaries;

    public Double process() {
        return average(salaries);
    }

    public double average(int[] salaries) {
        if (salaries == null || salaries.length < 3) return 0D;

        final int n = salaries.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0L;
        for (final int salary : salaries) {
            if (max < salary) max = salary;
            if (min > salary) min = salary;
            sum += salary;
        }

        return (double) (sum - min - max) / (n - 2);
    }
}
