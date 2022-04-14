package com.witalis.praxis.leetcode.task.h3.p217.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 217
 * Name: Contains Duplicate
 * URL: <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return containsDuplicate(numbers);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }

        return false;
    }
}
