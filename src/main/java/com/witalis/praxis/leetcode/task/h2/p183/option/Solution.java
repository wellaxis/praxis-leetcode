package com.witalis.praxis.leetcode.task.h2.p183.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 183
 * Name: Customers Who Never Order
 * URL: <a href="https://leetcode.com/problems/customers-who-never-order/">Customers Who Never Order</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return customersWithoutOrders();
    }

    public String customersWithoutOrders() {
        return
            """

            SELECT c.name AS "Customers"
            FROM   customers AS c
              LEFT JOIN orders AS o
            ON     c.id = o.customerId
            WHERE  o.customerId IS NULL
            ORDER BY c.name ASC

            """;
    }
}
