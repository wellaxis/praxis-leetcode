package com.witalis.praxis.leetcode.task.h7.p607.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 607
 * Name: Sales Person
 * URL: <a href="https://leetcode.com/problems/sales-person/">Sales Person</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return salesPersons();
    }

    public String salesPersons() {
        return
            """

            SELECT sp.name AS "name"
            FROM   SalesPerson sp
            WHERE NOT EXISTS (
                SELECT NULL
                FROM   Orders o
                WHERE  o.sales_id = sp.sales_id
                AND EXISTS (
                    SELECT NULL
                    FROM   Company c
                    WHERE  c.name = 'RED'
                    AND    c.com_id = o.com_id
                )
            )

            """;
    }
}
