package com.witalis.praxis.leetcode.task.h2.p185.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 185
 * Name: Department Top Three Salaries
 * URL: <a href="https://leetcode.com/problems/department-top-three-salaries/">Department Top Three Salaries</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return departmentTop3Salaries();
    }

    public String departmentTop3Salaries() {
        return
            """

            SELECT d.name AS "Department",
                   e.name AS "Employee",
                   e.salary AS "Salary"
            FROM   department d,
                   (SELECT e.id,
                           e.name,
                           e.departmentId,
                           e.salary,
                           DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rank
                    FROM   employee e
                   ) e
            WHERE  e.rank <= 3
            AND    d.id = e.departmentId
            ORDER BY d.id, e.rank

            """;
    }
}
