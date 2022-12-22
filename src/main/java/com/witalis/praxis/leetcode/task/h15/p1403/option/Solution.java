package com.witalis.praxis.leetcode.task.h15.p1403.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 1403
 * Name: Minimum Subsequence in Non-Increasing Order
 * URL: <a href="https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/">Minimum Subsequence in Non-Increasing Order</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<Integer> process() {
        return minSubsequence(numbers);
    }

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        int sum = 0;
        int curr = 0;
        for (int n : nums) sum += n;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum -= nums[i];
            curr += nums[i];
            res.add(nums[i]);

            if (curr > sum) break;
        }

        return res;
    }
}
