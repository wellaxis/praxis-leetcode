package com.witalis.praxis.leetcode.task.h1.p55.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 55
 * Name: Jump Game
 * URL: <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return canJump(numbers);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;

        int max = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            // check, if it is possible to jump over zero
            if (nums[i] == 0 && max <= i) return false;
            // recalculate current max
            max = Math.max(max, i + nums[i]);
            // check, if it is possible to reach the tail
            if (max >= nums.length - 1) return true;
        }
        return false;
    }
}
