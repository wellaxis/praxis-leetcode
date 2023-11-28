package com.witalis.praxis.leetcode.task.h22.p2147.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2147
 * Name: Number of Ways to Divide a Long Corridor
 * URL: <a href="https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/">Number of Ways to Divide a Long Corridor</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String corridor;

    public Integer process() {
        return numberOfWays(corridor);
    }

    public static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        if (corridor == null || corridor.isEmpty()) return 0;

        char[] letters = corridor.toCharArray();

        int seats = 0;
        for (char letter : letters)
            if (letter == 'S')
                seats++;

        if ((seats & 1) != 0) return 0;

        long ways = 1;
        int temp = 0;
        int count = 0;
        for (char letter : letters) {
            if (count != 2) {
                if (letter == 'S') count++;
            } else {
                temp++;
                if (letter == 'S') {
                    ways = (ways * temp) % MOD;
                    count = 1;
                    temp = 0;
                }
            }
        }

        return (count == 2) ? (int) ways : 0;
    }
}
