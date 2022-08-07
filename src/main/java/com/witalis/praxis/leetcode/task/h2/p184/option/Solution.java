package com.witalis.praxis.leetcode.task.h2.p184.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 184
 * Name: Department Highest Salary
 * URL: <a href="https://leetcode.com/problems/department-highest-salary/">Department Highest Salary</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return departmentHighestSalary();
    }

    public String departmentHighestSalary() {
        return
            """

            SELECT d.name AS "Department",
                   e.name AS "Employee",
                   e.salary AS "Salary"
            FROM   employee e,
                   department d
            WHERE  d.id = e.departmentId
            AND    (e.departmentId, e.salary) IN (
                SELECT em.departmentId,
                       MAX(em.salary)
                FROM   employee em
                GROUP BY em.departmentId
            )

            -- alternative
            WITH me AS (
                SELECT RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rank,
                       e.departmentId,
                       e.name,
                       e.salary
                FROM   employee e
            )
            SELECT d.name AS "Department",
                   me.name AS "Employee",
                   me.salary AS "Salary"
            FROM   me,
                   department d
            WHERE  d.id = me.departmentId
            AND    me.rank = 1

            """;
    }
}
