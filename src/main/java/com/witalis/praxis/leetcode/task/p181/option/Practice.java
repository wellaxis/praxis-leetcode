package com.witalis.praxis.leetcode.task.p181.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 181
 * Name: Employees Earning More Than Their Managers
 * URL: https://leetcode.com/problems/employees-earning-more-than-their-managers/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return employeesEarning();
    }

    public String employeesEarning() {
        return
            """
            SELECT e.name AS employee
            FROM   employee e,
                   employee m
            WHERE  m.id = e.managerid
            AND    e.salary > m.salary
            """;
    }
}
