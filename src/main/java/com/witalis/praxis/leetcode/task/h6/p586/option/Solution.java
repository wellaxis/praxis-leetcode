package com.witalis.praxis.leetcode.task.h6.p586.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 586
 * Name: Customer Placing the Largest Number of Orders
 * URL: <a href="https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/">Customer Placing the Largest Number of Orders</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return customerPlacingLargestNumberOfOrders();
    }

    public String customerPlacingLargestNumberOfOrders() {
        return
            """

            SELECT mo.customer_number
            FROM   (
                SELECT o.customer_number,
                       RANK() OVER (ORDER BY COUNT(DISTINCT o.order_number) DESC) AS ranking
                FROM   orders o
                GROUP BY o.customer_number
            ) mo
            WHERE  mo.ranking = 1

            SELECT o.customer_number
            FROM   orders o
            GROUP BY o.customer_number
            HAVING COUNT(*) = (
                SELECT MAX(COUNT(*))
                FROM   orders mo
                GROUP BY mo.customer_number
            )

            """;
    }
}
