package com.witalis.praxis.leetcode.task.h13.p1218.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1218
 * Name: Longest Arithmetic Subsequence of Given Difference
 * URL: <a href="https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/">Longest Arithmetic Subsequence of Given Difference</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int difference;

    public Integer process() {
        return longestSubsequence(numbers, difference);
    }

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null) return 0;

        final Map<Integer, Integer> dp = new HashMap<>();

        int max = 0;
        for (int number : arr) {
            int sequence = dp.getOrDefault(number - difference, 0) + 1;
            dp.put(number, sequence);
            if (sequence > max)
                max = sequence;
        }

        return max;
    }
}
