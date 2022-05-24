package com.witalis.praxis.leetcode.task.h2.p177.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 177
 * Name: Nth Highest Salary
 * URL: <a href="https://leetcode.com/problems/nth-highest-salary/">Nth Highest Salary</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

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
                SELECT e.salary
                INTO   result
                FROM (
                    SELECT ROW_NUMBER() OVER (ORDER BY e.salary DESC) AS id,
                           e.salary AS salary
                    FROM   (SELECT DISTINCT e.salary FROM employee e) e
                    ORDER BY e.salary DESC
                ) e
                WHERE e.id = N;
                RETURN result;
            END;

            """;
    }
}
