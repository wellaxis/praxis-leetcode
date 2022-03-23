package com.witalis.praxis.leetcode.task.h3.p219.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * ID: 219
 * Name: Contains Duplicate II
 * URL: https://leetcode.com/problems/contains-duplicate-ii/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int distance;

    public Boolean process() {
        return containsNearbyDuplicate(numbers, distance);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) return false;

        var positions = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (positions.containsKey(nums[i])) {
                int position = positions.get(nums[i]);
                if (i - position <= k) return true;
            }
            positions.put(nums[i], i);
        }

        return false;
    }
}
