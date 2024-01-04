package com.witalis.praxis.leetcode.task.h29.p2870.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2870
 * Name: Minimum Number of Operations to Make Array Empty
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/">Minimum Number of Operations to Make Array Empty</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return minOperations(numbers);
    }

    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        int s = 0;
        while (s < nums.length) {
            int e = s;

            while (e < nums.length && nums[e] == nums[s]) {
                e++;
            }

            int count = e - s;
            if (count == 1) return -1;

            res += count / 3;

            if (count % 3 != 0) res++;

            s = e;
        }

        return res;
    }
}
