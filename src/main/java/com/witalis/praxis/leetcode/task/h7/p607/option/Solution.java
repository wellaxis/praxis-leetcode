package com.witalis.praxis.leetcode.task.h7.p607.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 607
 * Name: Sales Person
 * URL: <a href="https://leetcode.com/problems/sales-person/">Sales Person</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return salesPersons();
    }

    public String salesPersons() {
        return
            """

            SELECT s.name AS "name"
            FROM   SalesPerson s
            WHERE  s.sales_id NOT IN (
                SELECT o.sales_id
                FROM   Orders o
                    LEFT JOIN Company c
                    ON o.com_id = c.com_id
                WHERE  c.name = 'RED'
            )

            """;
    }
}
