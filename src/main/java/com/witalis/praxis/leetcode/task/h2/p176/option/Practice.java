package com.witalis.praxis.leetcode.task.h2.p176.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 176
 * Name: Second Highest Salary
 * URL: <a href="https://leetcode.com/problems/second-highest-salary/">Second Highest Salary</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return secondHighestSalary();
    }

    public String secondHighestSalary() {
        return
            """

            SELECT e.salary AS "SecondHighestSalary"
            FROM (
                SELECT ROW_NUMBER() OVER (ORDER BY e.salary DESC) AS id,
                       LAG(e.salary) OVER (ORDER BY e.salary ASC) AS salary
                FROM   (SELECT DISTINCT e.salary FROM employee e) e
                ORDER BY e.salary DESC
            ) e
            WHERE  e.id = 1

            """;
    }
}
