package com.witalis.praxis.leetcode.task.h19.p1887.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1887
 * Name: Reduction Operations to Make the Array Elements Equal
 * URL: <a href="https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/">Reduction Operations to Make the Array Elements Equal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return reductionOperations(numbers);
    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int si = nums.length;
        int ans = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] != nums[i]) {
                ans += si - i;
            }
        }

        return ans;
    }
}
