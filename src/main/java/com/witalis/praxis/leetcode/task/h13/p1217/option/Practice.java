package com.witalis.praxis.leetcode.task.h13.p1217.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1217
 * Name: Minimum Cost to Move Chips to The Same Position
 * URL: <a href="https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/">Minimum Cost to Move Chips to The Same Position</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] positions;

    public Integer process() {
        return minCostToMoveChips(positions);
    }

    public int minCostToMoveChips(int[] position) {
        if (position == null) return 0;

        final int n = position.length;

        int cost = 0;
        for (int chips : position)
            if (chips % 2 != 0)
                cost++;

        return Math.min(cost, n - cost);
    }
}
