package com.witalis.praxis.leetcode.task.h6.p577.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 577
 * Name: Employee Bonus
 * URL: <a href="https://leetcode.com/problems/employee-bonus/">Employee Bonus</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return employeeBonus();
    }

    public String employeeBonus() {
        return
            """

            SELECT e.name,
                   b.bonus
            FROM   employee e
                LEFT JOIN bonus b
                    ON e.empId = b.empId
            WHERE  NVL(b.bonus, 0) < 1000

            """;
    }
}
