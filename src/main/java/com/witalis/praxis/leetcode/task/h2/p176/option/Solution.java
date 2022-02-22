package com.witalis.praxis.leetcode.task.h2.p176.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 176
 * Name: Second Highest Salary
 * URL: https://leetcode.com/problems/second-highest-salary/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return secondHighestSalary();
    }

    public String secondHighestSalary() {
        return
            """

            SELECT (
                SELECT DISTINCT e.salary
                FROM   employee e
                ORDER BY e.salary DESC
                LIMIT 1 OFFSET 1
            ) AS "SecondHighestSalary"

            """;
    }
}
