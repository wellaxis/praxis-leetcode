package com.witalis.praxis.leetcode.task.h18.p1793.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1793
 * Name: Maximum Score of a Good Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-score-of-a-good-subarray/">Maximum Score of a Good Subarray</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int gap;

    public Integer process() {
        return maximumScore(numbers, gap);
    }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int ans = nums[k];
        int currMin = nums[k];

        while (left > 0 || right < n - 1) {
            if ((left > 0 ? nums[left - 1]: 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                right++;
                currMin = Math.min(currMin, nums[right]);
            } else {
                left--;
                currMin = Math.min(currMin, nums[left]);
            }

            ans = Math.max(ans, currMin * (right - left + 1));
        }

        return ans;
    }
}
