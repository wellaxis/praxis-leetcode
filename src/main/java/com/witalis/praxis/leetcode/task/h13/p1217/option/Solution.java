package com.witalis.praxis.leetcode.task.h13.p1217.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1217
 * Name: Minimum Cost to Move Chips to The Same Position
 * URL: <a href="https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/">Minimum Cost to Move Chips to The Same Position</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] positions;

    public Integer process() {
        return minCostToMoveChips(positions);
    }

    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int p : position) {
            if (p % 2 == 0) even++;
            else odd++;
        }

        return Math.min(even, odd);
    }
}
