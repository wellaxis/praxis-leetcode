package com.witalis.praxis.leetcode.task.h8.p704.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 704
 * Name: Binary Search
 * URL: <a href="https://leetcode.com/problems/binary-search/">Binary Search</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int target;

    public Integer process() {
        return search(numbers, target);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}
