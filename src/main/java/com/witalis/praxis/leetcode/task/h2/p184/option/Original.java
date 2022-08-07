package com.witalis.praxis.leetcode.task.h2.p184.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 184
 * Name: Department Highest Salary
 * URL: <a href="https://leetcode.com/problems/department-highest-salary/">Department Highest Salary</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return departmentHighestSalary();
    }

    public String departmentHighestSalary() {
        return
            """

            SELECT d.name AS "Department",
                   e.name AS "Employee",
                   e.salary AS "Salary"
            FROM   department d,
                   employee e,
                   (SELECT em.departmentId,
                           MAX(em.salary) AS max_salary
                    FROM   employee em
                    GROUP BY em.departmentId
                   ) em
            WHERE  e.departmentId = d.id
            AND    em.departmentId = d.id
            AND    e.salary = em.max_salary

            """;
    }
}
