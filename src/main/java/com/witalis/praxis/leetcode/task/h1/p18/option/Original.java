package com.witalis.praxis.leetcode.task.h1.p18.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 18
 * Name: 4Sum
 * URL: https://leetcode.com/problems/4sum/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int target;

    public List<List<Integer>> process() {
        return fourSum(numbers, target);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return Collections.emptyList();

        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {

                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int diff = target - (nums[i] + nums[j] + nums[l] + nums[r]);

                    if (diff == 0) {
                        result.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        r--;
                        l++;
                    } else if (diff < 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
