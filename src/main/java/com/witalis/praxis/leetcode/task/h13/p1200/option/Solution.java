package com.witalis.praxis.leetcode.task.h13.p1200.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 1200
 * Name: Minimum Absolute Difference
 * URL: <a href="https://leetcode.com/problems/minimum-absolute-difference/">Minimum Absolute Difference</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<List<Integer>> process() {
        return minimumAbsDifference(numbers);
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i + 1 < arr.length; ++i) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                ans.clear();
            }
            if (diff == min) ans.add(Arrays.asList(arr[i], arr[i + 1]));
        }

        return ans;
    }
}
