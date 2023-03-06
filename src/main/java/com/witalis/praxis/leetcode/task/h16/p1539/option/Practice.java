package com.witalis.praxis.leetcode.task.h16.p1539.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1539
 * Name: Kth Missing Positive Number
 * URL: <a href="https://leetcode.com/problems/kth-missing-positive-number/">Kth Missing Positive Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int index;

    public Integer process() {
        return findKthPositive(numbers, index);
    }

    public int findKthPositive(int[] arr, int k) {
        if (arr == null || k <= 0) return -1;

        int current = 0;
        for (final int item : arr) {
            if (item - current > k) return current + k;

            k -= item - current - 1;
            current = item;
        }

        return (k > 0) ? current + k : current;
    }
}
