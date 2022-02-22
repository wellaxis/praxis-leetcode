package com.witalis.praxis.leetcode.task.h2.p176.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 176
 * Name: Second Highest Salary
 * URL: https://leetcode.com/problems/second-highest-salary/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return secondHighestSalary();
    }

    public String secondHighestSalary() {
        return
            """

            SELECT MAX(e.salary) AS "SecondHighestSalary"
            FROM   employee e
            WHERE  e.salary < (
                SELECT MAX(me.salary)
                FROM   employee me
                WHERE  me.id <> e.id
            )

            """;
    }
}
