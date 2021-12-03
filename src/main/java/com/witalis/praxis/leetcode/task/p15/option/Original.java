package com.witalis.praxis.leetcode.task.p15.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ID: 15
 * Name: 3Sum
 * URL: https://leetcode.com/problems/3sum/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<List<Integer>> process() {
        return threeSum(numbers);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        var triplet = new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        triplet.sort(Comparator.naturalOrder());
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }
}
