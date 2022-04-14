package com.witalis.praxis.leetcode.task.h2.p171.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 171
 * Name: Excel Sheet Column Number
 * URL: <a href="https://leetcode.com/problems/excel-sheet-column-number/">Excel Sheet Column Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String columnTitle;

    public Integer process() {
        return titleToNumber(columnTitle);
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A') + 1;
        }
        return result;
    }
}
