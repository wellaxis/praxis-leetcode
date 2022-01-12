package com.witalis.praxis.leetcode.task.h1.p15.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 15
 * Name: 3Sum
 * URL: https://leetcode.com/problems/3sum/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<List<Integer>> process() {
        return threeSum(numbers);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();

        Set<List<Integer>> result = new HashSet<>();

        Set<Integer> processed = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (processed.contains(nums[i])) continue;

            Set<Integer> cache = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (cache.contains(nums[j])) {
                    int min = Math.min(nums[i], Math.min(nums[j], -(nums[i] + nums[j])));
                    int max = Math.max(nums[i], Math.max(nums[j], -(nums[i] + nums[j])));

                    result.add(List.of(min, -min-max, max));
                } else {
                    cache.add(-(nums[i] + nums[j]));
                }
            }
            processed.add(nums[i]);
        }
        return new ArrayList<>(result);
    }
}
