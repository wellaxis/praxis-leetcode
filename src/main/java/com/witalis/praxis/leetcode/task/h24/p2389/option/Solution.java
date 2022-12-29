package com.witalis.praxis.leetcode.task.h24.p2389.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2389
 * Name: Longest Subsequence With Limited Sum
 * URL: <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/">Longest Subsequence With Limited Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int[] queries;

    public int[] process() {
        return answerQueries(numbers, queries);
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        // get the prefix sum array of the sorted 'nums'.
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i)
            nums[i] += nums[i - 1];

        // for each query, find its insertion index to the prefix sum array.
        int n = queries.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; ++i) {
            int index = binarySearch(nums, queries[i]);
            answer[i] = index;
        }

        return answer;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid + 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return nums[left] > target ? left : left + 1;
    }
}
