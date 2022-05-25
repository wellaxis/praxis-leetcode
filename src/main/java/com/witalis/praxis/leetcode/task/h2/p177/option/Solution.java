package com.witalis.praxis.leetcode.task.h2.p177.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 177
 * Name: Nth Highest Salary
 * URL: <a href="https://leetcode.com/problems/nth-highest-salary/">Nth Highest Salary</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return getNthHighestSalary();
    }

    public String getNthHighestSalary() {
        return
            """

            CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
            BEGIN
                RETURN (
                    SELECT DISTINCT r.salary
                    FROM   (
                        SELECT e.salary,
                               DENSE_RANK () OVER (ORDER BY e.salary DESC) AS 'rank'
                        FROM employee e
                    ) r
                    WHERE  r.rank = N
                );
            END

            """;
    }
}
