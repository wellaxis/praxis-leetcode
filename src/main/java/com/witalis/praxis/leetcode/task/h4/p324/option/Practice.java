package com.witalis.praxis.leetcode.task.h4.p324.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 324
 * Name: Wiggle Sort II
 * URL: <a href="https://leetcode.com/problems/wiggle-sort-ii/">Wiggle Sort II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        wiggleSort(numbers);
        return numbers;
    }

    public void wiggleSort(int[] nums) {
        final int size = 5_000;

        if (nums == null || nums.length < 2) return;

        int len = nums.length;
        int[] wiggle = new int[len];
        int[] frequencies = new int[size + 1];

        int max = 0;
        for (int num : nums) {
            frequencies[num]++;
            if (num > max) max = num;
        }

        int index = max;
        for (int i = 1; i < len; i += 2) {
            while (frequencies[index]-- == 0) index--;
            wiggle[i] = index;
        }

        for (int i = 0; i < len; i += 2) {
            while (frequencies[index]-- == 0) index--;
            wiggle[i] = index;
        }

        System.arraycopy(wiggle, 0, nums, 0, wiggle.length);
    }
}
