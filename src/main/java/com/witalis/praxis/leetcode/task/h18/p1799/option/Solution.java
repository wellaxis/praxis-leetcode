package com.witalis.praxis.leetcode.task.h18.p1799.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1799
 * Name: Maximize Score After N Operations
 * URL: <a href="https://leetcode.com/problems/maximize-score-after-n-operations/">Maximize Score After N Operations</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maxScore(numbers);
    }

    public int maxScore(int[] nums) {
        // 2^(nums array size)
        int maxStates = 1 << nums.length;
        int finalMask = maxStates - 1;

        // 'dp[i]' stores max score we can get after picking remaining numbers represented by 'i'
        int[] dp = new int[maxStates];

        // iterate on all possible states one-by-one
        for (int state = finalMask; state >= 0; state--) {
            // if we have picked all numbers, we know we can't get more score as no number is remaining
            if (state == finalMask) {
                dp[state] = 0;
                continue;
            }

            int numbersTaken = Integer.bitCount(state);
            int pairsFormed = numbersTaken / 2;
            // states representing even numbers are taken are only valid
            if (numbersTaken % 2 != 0) continue;

            // we have picked 'pairsFormed' pairs, we try all combinations of one more pair now
            // we iterate on two numbers using two nested for loops
            for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
                for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                    // we only choose those numbers which were not already picked
                    if (((state >> firstIndex) & 1) == 1 || ((state >> secondIndex) & 1) == 1) {
                        continue;
                    }
                    int currentScore = (pairsFormed + 1) * gcd(nums[firstIndex], nums[secondIndex]);
                    int stateAfterPickingCurrPair = state | (1 << firstIndex) | (1 << secondIndex);
                    int remainingScore = dp[stateAfterPickingCurrPair];
                    dp[state] = Math.max(dp[state], currentScore + remainingScore);
                }
            }
        }

        // returning score we get from 'n' remaining numbers of array
        return dp[0];
    }

    // calculate GCD using Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
