package com.witalis.praxis.leetcode.task.h2.p177.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 177
 * Name: Nth Highest Salary
 * URL: <a href="https://leetcode.com/problems/nth-highest-salary/">Nth Highest Salary</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return getNthHighestSalary();
    }

    public String getNthHighestSalary() {
        return
            """

            CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
                result NUMBER;
            BEGIN
                /* Write your PL/SQL query statement below */
                SELECT DISTINCT e.salary
                INTO   result
                FROM   employee e
                ORDER BY e.salary DESC
                OFFSET N - 1 ROWS
                FETCH NEXT 1 ROWS ONLY;
                RETURN result;
            END;

            """;
    }
}
