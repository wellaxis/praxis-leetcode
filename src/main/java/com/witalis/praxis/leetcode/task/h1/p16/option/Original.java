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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int target;

    public int process() {
        return threeSumClosest(numbers, target);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                int diff = target - sum;
                if (diff > 0) {
                    l++;
                } else if (diff < 0) {
                    r--;
                } else {
                    return sum;
                }

                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
            }
        }

        return res;
    }
}
