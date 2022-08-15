package com.witalis.praxis.leetcode.task.h2.p185.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 185
 * Name: Department Top Three Salaries
 * URL: <a href="https://leetcode.com/problems/department-top-three-salaries/">Department Top Three Salaries</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

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
                   employee e,
                   (SELECT de.departmentId,
                           de.id,
                           DENSE_RANK() OVER (PARTITION BY de.departmentId ORDER BY de.salary DESC) AS rank
                    FROM   employee de
                   ) de
            WHERE  de.rank <= 3
            AND    de.departmentId = d.id
            AND    de.id = e.id
            ORDER BY de.departmentId, de.rank

            """;
    }
}
