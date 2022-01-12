package com.witalis.praxis.leetcode.task.h2.p181.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 181
 * Name: Employees Earning More Than Their Managers
 * URL: https://leetcode.com/problems/employees-earning-more-than-their-managers/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return employeesEarning();
    }

    public String employeesEarning() {
        return
            """

            SELECT e.name AS employee
            FROM   employee e
            WHERE  e.managerid IS NOT NULL
            AND    e.salary > (
                SELECT m.salary
                FROM   employee m
                WHERE  m.id = e.managerid
            )

            """;
    }
}
