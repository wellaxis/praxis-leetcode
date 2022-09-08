package com.witalis.praxis.leetcode.task.h3.p220.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 220
 * Name: Contains Duplicate III
 * URL: <a href="https://leetcode.com/problems/contains-duplicate-iii/">Contains Duplicate III</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int indexDiff;
    private int valueDiff;

    public Boolean process() {
        return containsNearbyAlmostDuplicate(numbers, indexDiff, valueDiff);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) return false;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len && j <= i + k; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t) return true;
            }
        }

        return false;
    }
}
