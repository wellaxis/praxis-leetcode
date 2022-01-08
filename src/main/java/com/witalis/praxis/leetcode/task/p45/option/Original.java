package com.witalis.praxis.leetcode.task.p45.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 45
 * Name: Jump Game II
 * URL: https://leetcode.com/problems/jump-game-ii/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return jump(numbers);
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int[][] matrix = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            matrix[i][0] = nums[i];
            matrix[i][1] = (nums[i] == 0) ? -1 : 0;
        }

        int result = jump(matrix, 0, 0);
        return Math.max(result, 0);
    }

    private int jump(int[][] matrix, int position, int steps) {
        int number = matrix[position][0];
        int minimum = matrix[position][1];

        if (minimum < 0) {
            return -1;
        } else if (minimum == 0) {

            if (number + position >= matrix.length - 1) return steps + 1;

            minimum = matrix.length;

            boolean unavailable = true;
            for (int i = number; i >= 1; i--) {
                int min = jump(matrix, position + i, steps + 1);
                if (min == -1) continue;

                minimum = Math.min(minimum, min);
                unavailable = false;
            }
            if (unavailable) {
                matrix[position][1] = -1;
                return -1;
            }
            matrix[position][1] = minimum - steps;
        }

        return steps + matrix[position][1];
    }
}
