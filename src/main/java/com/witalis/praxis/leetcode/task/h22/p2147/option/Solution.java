package com.witalis.praxis.leetcode.task.h22.p2147.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2147
 * Name: Number of Ways to Divide a Long Corridor
 * URL: <a href="https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/">Number of Ways to Divide a Long Corridor</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String corridor;

    public Integer process() {
        return numberOfWays(corridor);
    }

    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        long ans = 1;
        int prevSeat = -1;
        int numSeats = 0;

        for (int i = 0; i < corridor.length(); ++i) {
            if (corridor.charAt(i) == 'S') {
                if (++numSeats > 2 && numSeats % 2 == 1)
                    ans = ans * (i - prevSeat) % MOD;
                prevSeat = i;
            }
        }

        return numSeats > 1 && numSeats % 2 == 0 ? (int) ans : 0;
    }
}
