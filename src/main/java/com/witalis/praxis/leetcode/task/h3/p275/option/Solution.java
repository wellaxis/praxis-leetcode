package com.witalis.praxis.leetcode.task.h3.p275.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 275
 * Name: H-Index II
 * URL: <a href="https://leetcode.com/problems/h-index-ii/">H-Index II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] citations;

    public Integer process() {
        return hIndex(citations);
    }

    public int hIndex(int[] citations) {
        return helper(citations, 0, citations.length - 1);
    }

    public int helper(int[] citations, int low, int high) {
        if (low > high) return -1;

        int mid = low + high + 1 >> 1;
        int val = citations[mid];
        int count = citations.length - mid;
        if (val < count) {
            return Math.max(val, helper(citations, mid + 1, high));
        } else {
            return Math.max(count, helper(citations, low, mid - 1));
        }
    }
}
