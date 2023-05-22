package com.witalis.praxis.leetcode.task.h6.p577.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 577
 * Name: Employee Bonus
 * URL: <a href="https://leetcode.com/problems/employee-bonus/">Employee Bonus</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return employeeBonus();
    }

    public String employeeBonus() {
        return
            """

            SELECT e.name,
                   (SELECT b.bonus
                    FROM   bonus b
                    WHERE  b.empId = e.empId
                   ) AS bonus
            FROM   employee e
            WHERE NOT EXISTS (
                SELECT NULL
                FROM   bonus b
                WHERE  b.empId = e.empId
                AND    b.bonus >= 1000
            )
            ORDER BY 2 ASC NULLS FIRST

            """;
    }
}
