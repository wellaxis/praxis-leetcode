package com.witalis.praxis.leetcode.task.h5.p403.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 403
 * Name: Frog Jump
 * URL: <a href="https://leetcode.com/problems/frog-jump/">Frog Jump</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] stones;

    public Solution(int[] stones) {
        this.stones = stones;
    }

    public Boolean process() {
        return canCross(stones);
    }

    private boolean[][] dp;

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;

        int n = stones.length;

        this.dp = new boolean[n][n];

        return helper(stones, 0, 1);
    }

    boolean helper(int[] stones, int lastIndex, int currentIndex) {
        if (currentIndex == stones.length - 1) return true;
        if (dp[lastIndex][currentIndex]) return false;

        int lastJump = stones[currentIndex] - stones[lastIndex];
        int nextIndex = currentIndex + 1;

        while (nextIndex < stones.length && stones[nextIndex] <= stones[currentIndex] + lastJump + 1) {
            int nextJump = stones[nextIndex] - stones[currentIndex];

            int jump = nextJump - lastJump;

            if (jump >= -1 && jump <= 1) {
                if (helper(stones, currentIndex, nextIndex)) {
                    return true;
                }
            }
            nextIndex++;
        }
        dp[lastIndex][currentIndex] = true;

        return false;
    }
}
