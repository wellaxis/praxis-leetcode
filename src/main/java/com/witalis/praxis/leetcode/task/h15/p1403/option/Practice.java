package com.witalis.praxis.leetcode.task.h15.p1403.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1403
 * Name: Minimum Subsequence in Non-Increasing Order
 * URL: <a href="https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/">Minimum Subsequence in Non-Increasing Order</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<Integer> process() {
        return minSubsequence(numbers);
    }

    public List<Integer> minSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> subsequence = new LinkedList<>();

        Arrays.sort(nums);
        final int half = Arrays.stream(nums).sum() / 2;

        int sum = 0;
        int index = nums.length - 1;
        while (sum <= half && index >= 0) {
            int num = nums[index--];
            sum += num;
            subsequence.add(num);
        }

        return subsequence;
    }
}
