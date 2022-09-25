package com.witalis.praxis.leetcode.task.h7.p607.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 607
 * Name: Sales Person
 * URL: <a href="https://leetcode.com/problems/sales-person/">Sales Person</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return salesPersons();
    }

    public String salesPersons() {
        return
            """

            SELECT sp.name AS "name"
            FROM   SalesPerson sp
            WHERE  sp.sales_id NOT IN (
                SELECT o.sales_id
                FROM   Orders o,
                       Company c
                WHERE  c.com_id = o.com_id
                AND    c.name = 'RED'
            )

            """;
    }
}
