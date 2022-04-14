package com.witalis.praxis.leetcode.task.h2.p183.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 183
 * Name: Customers Who Never Order
 * URL: <a href="https://leetcode.com/problems/customers-who-never-order/">Customers Who Never Order</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return customersWithoutOrders();
    }

    public String customersWithoutOrders() {
        return
            """

            SELECT c.name AS "Customers"
            FROM   customers c
            WHERE NOT EXISTS (
                SELECT NULL
                FROM   orders o
                WHERE  o.customerId = c.id
            )
            ORDER BY c.name ASC

            """;
    }
}
