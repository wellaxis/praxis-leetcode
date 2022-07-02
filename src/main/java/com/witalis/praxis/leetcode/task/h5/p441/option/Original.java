package com.witalis.praxis.leetcode.task.h5.p441.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 441
 * Name: Arranging Coins
 * URL: <a href="https://leetcode.com/problems/arranging-coins/">Arranging Coins</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return arrangeCoins(number);
    }

    public int arrangeCoins(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long sum;
        int mid = 0;
        int min = 0;
        int max = n;
        while (min <= max) {
            mid = min + (max - min) / 2;
            sum = (long) mid * (mid + 1) / 2;
            if (sum == n) return mid;
            if (sum > n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return max;
    }
}
