package com.witalis.praxis.leetcode.task.h2.p185.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 185
 * Name: Department Top Three Salaries
 * URL: <a href="https://leetcode.com/problems/department-top-three-salaries/">Department Top Three Salaries</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return departmentTop3Salaries();
    }

    public String departmentTop3Salaries() {
        return
            """

            SELECT d.name AS "Department",
                   e.name AS "Employee",
                   e.salary AS "Salary"
            FROM   employee e
            JOIN   department d
            ON e.departmentId = d.Id
            WHERE  3 > (
                SELECT COUNT(DISTINCT de.salary)
                FROM   employee de
                WHERE  de.salary > e.salary
                AND    de.departmentId = e.departmentId
            )
            ORDER BY d.id, e.salary DESC

            -- alternative
            WITH e AS (
                SELECT DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rank,
                       e.id,
                       e.name,
                       e.departmentId,
                       e.salary
                FROM   employee e
            )
            SELECT d.name AS "Department",
                   e.name AS "Employee",
                   e.salary AS "Salary"
            FROM   department d,
                   e
            WHERE  e.rank <= 3
            AND    d.id = e.departmentId

            """;
    }
}
