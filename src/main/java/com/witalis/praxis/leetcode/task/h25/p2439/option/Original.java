package com.witalis.praxis.leetcode.task.h25.p2439.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2439
 * Name: Minimize Maximum of Array
 * URL: <a href="https://leetcode.com/problems/minimize-maximum-of-array/">Minimize Maximum of Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return minimizeArrayValue(numbers);
    }

    public int minimizeArrayValue(int[] nums) {
        if (nums == null) return 0;

        int min = 0;
        int max = Arrays.stream(nums).max().orElse(0);
        while (min < max) {
            int mid = min + (max - min) / 2;

            if (check(nums, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean check(int[] nums, int value) {
        long steps = 0;
        for (int num : nums) {
            if (num <= value) {
                steps += (value - num);
            } else {
                if (steps < num - value) return false;

                steps -= (num - value);
            }
        }

        return true;
    }
}
