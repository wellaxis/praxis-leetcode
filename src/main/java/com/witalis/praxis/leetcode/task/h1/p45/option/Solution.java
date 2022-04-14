package com.witalis.praxis.leetcode.task.h1.p45.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 45
 * Name: Jump Game II
 * URL: <a href="https://leetcode.com/problems/jump-game-ii/">Jump Game II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return jump(numbers);
    }

    public int jump(int[] nums) {
        int level = 0;
        int currentStep = 0;
        int i = 0;

        while (currentStep < nums.length - 1) {
            level++;

            int previousStep = currentStep;
            // traverse of preStep level and find the max step of this level
            for (; i <= previousStep; ++i) {
                currentStep = Math.max(currentStep, i + nums[i]);
            }
        }

        return level;
    }
}
