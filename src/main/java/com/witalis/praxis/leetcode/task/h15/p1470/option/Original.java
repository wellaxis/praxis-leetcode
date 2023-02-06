package com.witalis.praxis.leetcode.task.h15.p1470.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1470
 * Name: Shuffle the Array
 * URL: <a href="https://leetcode.com/problems/shuffle-the-array/">Shuffle the Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int number;

    public int[] process() {
        return shuffle(numbers, number);
    }

    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length == 0) return nums;

        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }

        return ans;
    }
}
