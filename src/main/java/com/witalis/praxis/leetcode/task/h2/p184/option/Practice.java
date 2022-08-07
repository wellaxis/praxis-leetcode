package com.witalis.praxis.leetcode.task.h2.p184.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 184
 * Name: Department Highest Salary
 * URL: <a href="https://leetcode.com/problems/department-highest-salary/">Department Highest Salary</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return departmentHighestSalary();
    }

    public String departmentHighestSalary() {
        return
            """

            SELECT d.name AS "Department",
                   e.name AS "Employee",
                   d.max_salary AS "Salary"
            FROM   (SELECT d.id,
                           d.name,
                           (SELECT MAX(e.salary)
                            FROM   employee e
                            WHERE  e.departmentId = d.id
                           ) AS max_salary
                    FROM   department d
                   ) d,
                   employee e
            WHERE  e.departmentId = d.id
            AND    e.salary = d.max_salary

            """;
    }
}
