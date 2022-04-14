package com.witalis.praxis.leetcode.task.h3.p217.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * ID: 217
 * Name: Contains Duplicate
 * URL: <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return containsDuplicate(numbers);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }

        return false;
    }
}
