package com.witalis.praxis.leetcode.task.h4.p324.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 324
 * Name: Wiggle Sort II
 * URL: <a href="https://leetcode.com/problems/wiggle-sort-ii/">Wiggle Sort II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        wiggleSort(numbers);
        return numbers;
    }

    public void wiggleSort(int[] nums) {
        int median = quickSelect(nums, 0, nums.length - 1, (nums.length + 1) / 2);

        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (i <= k) {
            int it = index(i, nums.length);
            int jt = index(j, nums.length);
            int kt = index(k, nums.length);
            if (nums[it] > median) {
                int tmp = nums[it];
                nums[it] = nums[jt];
                nums[jt] = tmp;
                i++;
                j++;
            } else if (nums[it] < median) {
                int tmp = nums[it];
                nums[it] = nums[kt];
                nums[kt] = tmp;
                k--;
            } else {
                i++;
            }
        }
    }

    private int index(int i, int n) {
        if (i < n / 2) {
            return i * 2 + 1;
        } else {
            return (i - n / 2) * 2;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int x = nums[right];
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (nums[i] <= x) {
                i++;
            } else {
                if (nums[j] <= x) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
                j--;
            }
        }
        nums[right] = nums[i];
        nums[i] = x;

        return i;
    }

    private int quickSelect(int[] nums, int left, int right, int i) {
        if (left == right) return nums[left];

        int q = partition(nums, left, right);
        int k = q - left + 1;
        if (i == k) {
            return nums[q];
        } else if (i < k) {
            return quickSelect(nums, left, q - 1, i);
        } else {
            return quickSelect(nums, q + 1, right, i - k);
        }
    }
}
