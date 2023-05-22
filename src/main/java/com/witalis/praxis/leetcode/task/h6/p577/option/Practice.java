package com.witalis.praxis.leetcode.task.h6.p577.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 577
 * Name: Employee Bonus
 * URL: <a href="https://leetcode.com/problems/employee-bonus/">Employee Bonus</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return employeeBonus();
    }

    public String employeeBonus() {
        return
            """

            SELECT e.name,
                   e.bonus
            FROM (
                SELECT e.name,
                       (SELECT b.bonus
                        FROM   bonus b
                        WHERE  b.empId = e.empId
                       ) AS bonus
                FROM   employee e
            ) e
            WHERE NVL(e.bonus, 0) < 1000

            """;
    }
}
