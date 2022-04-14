package com.witalis.praxis.leetcode.task.h2.p181.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 181
 * Name: Employees Earning More Than Their Managers
 * URL: <a href="https://leetcode.com/problems/employees-earning-more-than-their-managers/">Employees Earning More Than Their Managers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return employeesEarning();
    }

    public String employeesEarning() {
        return
            """

            SELECT a.name AS employee
            FROM   employee AS a
              JOIN employee AS b
            ON     a.managerId = b.id
            AND    a.salary > b.salary

            """;
    }
}
