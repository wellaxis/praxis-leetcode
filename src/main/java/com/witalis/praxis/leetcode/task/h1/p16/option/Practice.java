package com.witalis.praxis.leetcode.task.h1.p16.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 16
 * Name: 3Sum Closest
 * URL: <a href="https://leetcode.com/problems/3sum-closest/">3Sum Closest</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int target;

    public int process() {
        return threeSumClosest(numbers, target);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int diff = target - (nums[i] + nums[l] + nums[r]);

                if (diff == 0) {
                    return target - diff;
                } else if (diff > 0) {
                    l++;
                } else {
                    r--;
                }

                if (Math.abs(diff) < Math.abs(target - res)) {
                    res = target - diff;
                }
            }
        }

        return res;
    }
}
