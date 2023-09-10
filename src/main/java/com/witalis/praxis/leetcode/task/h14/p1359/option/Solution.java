package com.witalis.praxis.leetcode.task.h14.p1359.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1359
 * Name: Count All Valid Pickup and Delivery Options
 * URL: <a href="https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/">Count All Valid Pickup and Delivery Options</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int orders;

    public Integer process() {
        return countOrders(orders);
    }

    private static final int MOD = 1000000007;

    public int countOrders(int n) {
        long count = 1;
        for (int i = 2; i <= n; i++) {
            count = (count * (2L * i - 1) * i) % MOD;
        }
        return (int) count;
    }
}
