package com.witalis.praxis.leetcode.task.h16.p1539.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1539
 * Name: Kth Missing Positive Number
 * URL: <a href="https://leetcode.com/problems/kth-missing-positive-number/">Kth Missing Positive Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int index;

    public Integer process() {
        return findKthPositive(numbers, index);
    }

    public int findKthPositive(int[] arr, int k) {
        if (arr == null || k <= 0) return -1;

        int current = 0;
        for (int item : arr) {
            if (item - current > k) {
                return current + k;
            } else {
                k -= item - current - 1;
                current = item;
            }
        }
        if (k > 0) current += k;

        return current;
    }
}
