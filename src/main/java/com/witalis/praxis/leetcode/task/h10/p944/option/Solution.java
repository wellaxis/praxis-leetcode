package com.witalis.praxis.leetcode.task.h10.p944.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 944
 * Name: Delete Columns to Make Sorted
 * URL: <a href="https://leetcode.com/problems/delete-columns-to-make-sorted/">Delete Columns to Make Sorted</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] strings;

    public Integer process() {
        return minDeletionSize(strings);
    }

    public int minDeletionSize(String[] strs) {
        int deleted = 0;
        if (strs == null || strs.length == 0) return deleted;
        int rowSize = strs[0].length();

        for (int col = 0; col < rowSize; col++) {
            if (!isSorted(strs, col)) deleted++;
        }

        return deleted;
    }

    boolean isSorted(String[] strs, int col) {
        char prev = (char) 0;
        for (String str : strs) {
            char c = str.charAt(col);
            if (c < prev) return false;
            prev = c;
        }

        return true;
    }
}
