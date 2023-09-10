package com.witalis.praxis.leetcode.task.h14.p1359.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1359
 * Name: Count All Valid Pickup and Delivery Options
 * URL: <a href="https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/">Count All Valid Pickup and Delivery Options</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int orders;

    public Practice(int orders) {
        this.orders = orders;
    }

    public Integer process() {
        return countOrders(orders);
    }

    public static final int MOD = 1_000_000_007;

    private int[][] dp;

    public int countOrders(int n) {
        this.dp = new int[n + 1][n + 1];
        for (int[] item : dp)
            Arrays.fill(item, -1);

        return (int) solver(n, n);
    }

    private long solver(int pick, int deliver) {
        if (pick == 0 && deliver == 0) return 1;
        if (pick < 0 || deliver < 0 || deliver < pick) return 0;
        if (dp[pick][deliver] != -1) return dp[pick][deliver];

        // pick order
        long picks = (pick * solver(pick - 1, deliver)) % MOD;
        // deliver order
        long delivers = ((deliver - pick)  * solver(pick, deliver - 1)) % MOD;

        dp[pick][deliver] = (int) (picks + delivers) % MOD;

        return dp[pick][deliver];
    }
}
