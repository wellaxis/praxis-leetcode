package com.witalis.praxis.leetcode.task.h27.p2616.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2616
 * Name: Minimize the Maximum Difference of Pairs
 * URL: <a href="https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/">Minimize the Maximum Difference of Pairs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int pairs;

    public Integer process() {
        return minimizeMax(numbers, pairs);
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;

            // if there are enough pairs, look for a smaller threshold
            // otherwise, look for a larger threshold.
            if (countValidPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // find the number of valid pairs by greedy approach
    private int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while (index < nums.length - 1) {
            // If a valid pair is found, skip both numbers.
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
}
