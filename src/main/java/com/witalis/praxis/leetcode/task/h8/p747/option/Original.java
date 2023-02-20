package com.witalis.praxis.leetcode.task.h8.p747.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 747
 * Name: Largest Number At Least Twice of Others
 * URL: <a href="https://leetcode.com/problems/largest-number-at-least-twice-of-others/">Largest Number At Least Twice of Others</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return dominantIndex(numbers);
    }

    public int dominantIndex(int[] nums) {
        if (nums == null) return -1;

        int index = -1;
        int max = -1;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        final int finalMax = max;
        final boolean isDominant = Arrays.stream(nums).filter(i -> i != finalMax).allMatch(i -> 2 * i <= finalMax);

        return isDominant ? index : -1;
    }
}
