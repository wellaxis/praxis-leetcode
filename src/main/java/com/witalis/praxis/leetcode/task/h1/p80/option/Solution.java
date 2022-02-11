package com.witalis.praxis.leetcode.task.h1.p80.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 80
 * Name: Remove Duplicates from Sorted Array II
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return removeDuplicates(numbers);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int last = nums[0];
        int cnt = 1;
        int pos = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == last && cnt == 1) {
                nums[pos++] = last;
                cnt++;
            } else if (nums[i] != last) {
                nums[pos++] = nums[i];
                last = nums[i];
                cnt = 1;
            }
        }

        return pos;
    }
}
