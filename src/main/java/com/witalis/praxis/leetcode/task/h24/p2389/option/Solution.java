package com.witalis.praxis.leetcode.task.h24.p2389.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
        return new int[0];
    }
}
