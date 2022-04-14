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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int target;

    public int process() {
        return threeSumClosest(numbers, target);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int clo = nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            int sum = target - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    return target;
                } else if (nums[lo] + nums[hi] < sum) {
                    if (Math.abs(target - nums[i] - nums[lo] - nums[hi]) < Math.abs(target - clo)) {
                        clo = nums[i] + nums[lo] + nums[hi];
                    }
                    lo++;
                } else {
                    if (Math.abs(target - nums[i] - nums[lo] - nums[hi]) < Math.abs(target - clo)) {
                        clo = nums[i] + nums[lo] + nums[hi];
                    }
                    hi--;
                }
            }
        }
        return clo;
    }
}
