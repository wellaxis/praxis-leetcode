package com.witalis.praxis.leetcode.task.h16.p1535.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1535
 * Name: Find the Winner of an Array Game
 * URL: <a href="https://leetcode.com/problems/find-the-winner-of-an-array-game/">Find the Winner of an Array Game</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int rounds;

    public Integer process() {
        return getWinner(numbers, rounds);
    }

    public int getWinner(int[] arr, int k) {
        int ans = arr[0];
        int wins = 0;

        for (int i = 1; i < arr.length && wins < k; ++i)
            if (arr[i] > ans) {
                ans = arr[i];
                wins = 1;
            } else {
                ++wins;
            }

        return ans;
    }
}
