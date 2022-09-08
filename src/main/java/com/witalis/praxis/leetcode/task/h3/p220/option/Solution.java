package com.witalis.praxis.leetcode.task.h3.p220.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * ID: 220
 * Name: Contains Duplicate III
 * URL: <a href="https://leetcode.com/problems/contains-duplicate-iii/">Contains Duplicate III</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int indexDiff;
    private int valueDiff;

    public Boolean process() {
        return containsNearbyAlmostDuplicate(numbers, indexDiff, valueDiff);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        SortedSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            final long num = nums[i];

            long left = num - t;
            long right = num + t;

            SortedSet<Long> subSet = set.subSet(left, right + 1);
            if (!subSet.isEmpty()) return true;

            set.add(num);
            if (i >= k) set.remove((long) nums[i - k]);
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicateSorting(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            final long num = nums[i];

            final Long ceiling = set.ceiling(num);
            if (ceiling != null && ceiling - num <= t) return true;

            final Long floor = set.floor(num);
            if (floor != null && num - floor <= t) return true;

            set.add(num);
            if (i >= k) set.remove((long) nums[i - k]);
        }

        return false;
    }
}
