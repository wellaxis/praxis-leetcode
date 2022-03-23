package com.witalis.praxis.leetcode.task.h3.p219.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * ID: 219
 * Name: Contains Duplicate II
 * URL: https://leetcode.com/problems/contains-duplicate-ii/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int distance;

    public Boolean process() {
        return containsNearbyDuplicate(numbers, distance);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0) return false;

        HashSet<Integer> set = new HashSet<>();

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (!set.add(nums[j])) return true;

            if (set.size() >= k + 1) {
                set.remove(nums[i++]);
            }
        }

        return false;
    }
}
