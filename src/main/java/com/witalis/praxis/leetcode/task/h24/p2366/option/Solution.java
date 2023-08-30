package com.witalis.praxis.leetcode.task.h24.p2366.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2366
 * Name: Minimum Replacements to Sort the Array
 * URL: <a href="https://leetcode.com/problems/minimum-replacements-to-sort-the-array/">Minimum Replacements to Sort the Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Long process() {
        return minimumReplacement(numbers);
    }

    public long minimumReplacement(int[] nums) {
        long answer = 0;
        int n = nums.length;

        // start from the second last element, as the last one is always sorted
        for (int i = n - 2; i >= 0; i--) {
            // no need to break if they are already in order
            if (nums[i] <= nums[i + 1]) continue;

            // count how many elements are made from breaking nums[i]
            long numElements = (long) (nums[i] + nums[i + 1] - 1) / (long) nums[i + 1];

            // it requires numElements - 1 replacement operations
            answer += numElements - 1;

            // maximize nums[i] after replacement.
            nums[i] = nums[i] / (int) numElements;
        }

        return answer;
    }
}
