package com.witalis.praxis.leetcode.task.h1.p55.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 55
 * Name: Jump Game
 * URL: <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return canJump(numbers);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        return recursiveJump(nums, 0);
    }

    private boolean recursiveJump(int[] nums, int index) {
        if (index == nums.length - 1) return true;

        int number = nums[index];
        if (index + number >= nums.length - 1) return true;

        while (number > 0) {
            if (recursiveJump(nums, index + number)) return true;
            number--;
        }
        return false;
    }
}
