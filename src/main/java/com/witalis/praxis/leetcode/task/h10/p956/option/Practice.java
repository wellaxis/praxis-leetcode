package com.witalis.praxis.leetcode.task.h10.p956.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 956
 * Name: Tallest Billboard
 * URL: <a href="https://leetcode.com/problems/tallest-billboard/">Tallest Billboard</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Practice {
    private int[] rods;

    public Practice(int[] rods) {
        this.rods = rods;
    }

    public Integer process() {
        return tallestBillboard(rods);
    }

    private Map<Integer, Integer>[] dp;

    public int tallestBillboard(int[] rods) {
        if (rods == null) return 0;

        final int n = rods.length;
        this.dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = new HashMap<>();

        return recursiveTravers(rods, 0, 0);
    }

    private int recursiveTravers(int[] rods, int index, int height) {
        if (index >= rods.length) {
            if (height != 0) return Integer.MIN_VALUE;
            return 0;
        }
        if (dp[index].containsKey(height)) return dp[index].get(height);

        int v1 = recursiveTravers(rods, index + 1, height);
        int v2 = rods[index] + recursiveTravers(rods, index + 1, height - rods[index]);
        int v3 = recursiveTravers(rods, index + 1, height + rods[index]);

        int maxHeight = Math.max(v1, Math.max(v2, v3));
        dp[index].put(height, maxHeight);

        return maxHeight;
    }
}
