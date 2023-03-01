package com.witalis.praxis.leetcode.task.h10.p912.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 912
 * Name: Sort an Array
 * URL: <a href="https://leetcode.com/problems/sort-an-array/">Sort an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return sortArray(numbers);
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m + 1 - l;
        int n2 = r - m;
        int[] left = new int[n1];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        int[] right = new int[n2];
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 || j < n2) {
            if (j == n2 || i < n1 && left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (high - low) / 2 + low;
            sort(arr, low, middle);
            sort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }
}
