package com.witalis.praxis.leetcode.task.h2.p183.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 183
 * Name: Customers Who Never Order
 * URL: https://leetcode.com/problems/customers-who-never-order/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return customersWithoutOrders();
    }

    public String customersWithoutOrders() {
        return
            """

            SELECT c.name AS "Customers"
            FROM   customers c
            WHERE  c.id NOT IN (
                SELECT o.customerId
                FROM   orders o
            )
            ORDER BY c.name ASC

            """;
    }
}
