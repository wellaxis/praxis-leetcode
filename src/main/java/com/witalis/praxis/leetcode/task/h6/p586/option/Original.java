package com.witalis.praxis.leetcode.task.h6.p586.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 586
 * Name: Customer Placing the Largest Number of Orders
 * URL: <a href="https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/">Customer Placing the Largest Number of Orders</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return customerPlacingLargestNumberOfOrders();
    }

    public String customerPlacingLargestNumberOfOrders() {
        return
            """

            SELECT o.customer_number
            FROM   (
                SELECT o.customer_number
                FROM   orders o
                WHERE  o.order_number IS NOT NULL
                GROUP BY o.customer_number
                ORDER BY COUNT(o.order_number) DESC
            ) o
            WHERE  ROWNUM = 1

            """;
    }
}
