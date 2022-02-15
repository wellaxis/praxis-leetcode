package com.witalis.praxis.leetcode.task.h2.p171.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 171
 * Name: Excel Sheet Column Number
 * URL: https://leetcode.com/problems/excel-sheet-column-number/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String columnTitle;

    public Integer process() {
        return titleToNumber(columnTitle);
    }

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) return 0;

        int number = 0;

        int len = columnTitle.length();
        for (int i = len; i > 0; i--) {
            int base = columnTitle.charAt(len - i) - 64;
            number += base * (int) Math.pow(26, i - 1D);
        }

        return number;
    }
}
