package com.witalis.praxis.leetcode.task.h2.p137.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 137
 * Name: Single Number II
 * URL: <a href="https://leetcode.com/problems/single-number-ii/">Single Number II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return singleNumber(numbers);
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 3) {
            if (nums[i] != nums[i + 1]) return nums[i];
        }

        return nums[nums.length - 1];
    }
}
