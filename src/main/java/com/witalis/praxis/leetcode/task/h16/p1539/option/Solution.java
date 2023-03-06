package com.witalis.praxis.leetcode.task.h16.p1539.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1539
 * Name: Kth Missing Positive Number
 * URL: <a href="https://leetcode.com/problems/kth-missing-positive-number/">Kth Missing Positive Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int index;

    public Integer process() {
        return findKthPositive(numbers, index);
    }

    // binary search
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k;
    }

    // sequential processing
    public int findKthPositiveSeq(int[] arr, int k) {
        for (int i : arr) {
            if (i <= k) k++;
            else break;
        }
        return k;
    }
}
