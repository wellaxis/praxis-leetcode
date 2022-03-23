package com.witalis.praxis.leetcode.task.h3.p219.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;

/**
 * ID: 219
 * Name: Contains Duplicate II
 * URL: https://leetcode.com/problems/contains-duplicate-ii/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int distance;

    public Boolean process() {
        return containsNearbyDuplicate(numbers, distance);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) return false;

        var slide = new ArrayDeque<Integer>(k);
        for (int i = 0; i < nums.length; i++) {
            if (slide.contains(nums[i])) return true;
            if (i >= k) slide.poll();
            slide.offer(nums[i]);
        }

        return false;
    }
}
