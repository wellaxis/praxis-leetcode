package com.witalis.praxis.leetcode.task.h13.p1251.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1251
 * Name: Average Selling Price
 * URL: <a href="https://leetcode.com/problems/average-selling-price/">Average Selling Price</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return averageSellingPrice();
    }

    public String averageSellingPrice() {
        return
            """

            SELECT p.product_id,
                   NVL(ROUND(SUM(us.units * p.price) / SUM(us.units), 2), 0) AS average_price
            FROM   Prices p
              LEFT OUTER JOIN UnitsSold us
            ON     p.product_id = us.product_id
            AND    us.purchase_date BETWEEN p.start_date AND p.end_date
            GROUP BY p.product_id

            """;
    }
}
