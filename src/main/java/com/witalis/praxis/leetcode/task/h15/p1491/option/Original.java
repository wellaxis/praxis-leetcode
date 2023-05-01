package com.witalis.praxis.leetcode.task.h15.p1491.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1491
 * Name: Average Salary Excluding the Minimum and Maximum Salary
 * URL: <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/">Average Salary Excluding the Minimum and Maximum Salary</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] salaries;

    public Double process() {
        return average(salaries);
    }

    public double average(int[] salary) {
        if (salary == null || salary.length < 3) return 0D;

        Arrays.sort(salary);

        final int[] used = Arrays.copyOfRange(salary, 1, salary.length - 1);

        return Arrays.stream(used).summaryStatistics().getAverage();
    }
}
