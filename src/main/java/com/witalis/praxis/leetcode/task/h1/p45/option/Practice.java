package com.witalis.praxis.leetcode.task.h1.p45.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 45
 * Name: Jump Game II
 * URL: https://leetcode.com/problems/jump-game-ii/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return jump(numbers);
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int steps = 0;

        int position = 0;
        while (position < nums.length - 1) {
            int number = nums[position];

            if (position + number >= nums.length - 1) return steps + 1;

            int maximum = 0;
            int current = position;
            for (int i = number; i >= 1; i--) {
                int step = nums[i + position] + i;
                if (step > maximum) {
                    maximum = step;
                    current = i + position;
                }
            }
            position = current;

            steps++;
        }
        return steps;
    }
}
