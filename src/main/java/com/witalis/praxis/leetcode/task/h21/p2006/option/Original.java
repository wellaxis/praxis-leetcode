package com.witalis.praxis.leetcode.task.h21.p2006.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2006
 * Name: Count Number of Pairs With Absolute Difference K
 * URL: <a href="https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/">Count Number of Pairs With Absolute Difference K</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int difference;

    public Integer process() {
        return countKDifference(numbers, difference);
    }

    public int countKDifference(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) count++;
            }
        }

        return count;
    }
}
