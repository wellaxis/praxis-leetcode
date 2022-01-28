package com.witalis.praxis.leetcode.task.h3.p217.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * ID: 217
 * Name: Contains Duplicate
 * URL: https://leetcode.com/problems/contains-duplicate/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return containsDuplicate(numbers);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        var cache = new HashSet<Integer>();

        for (int number: nums) {
            if (cache.contains(number)) return true;
            cache.add(number);
        }

        return false;
    }
}
