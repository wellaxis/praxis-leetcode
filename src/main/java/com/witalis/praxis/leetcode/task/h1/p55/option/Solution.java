package com.witalis.praxis.leetcode.task.h1.p55.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 55
 * Name: Jump Game
 * URL: https://leetcode.com/problems/jump-game/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return canJump(numbers);
    }

    public boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;

        //iterate from the right end of the array
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPosition)
                lastPosition = i;
        }

        return lastPosition == 0;
    }
}
