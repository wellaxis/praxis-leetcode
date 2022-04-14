package com.witalis.praxis.leetcode.task.h2.p168.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 168
 * Name: Excel Sheet Column Title
 * URL: <a href="https://leetcode.com/problems/excel-sheet-column-title/">Excel Sheet Column Title</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int columnNumber;

    public String process() {
        return convertToTitle(columnNumber);
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (--columnNumber >= 0) {
            sb.insert(0, (char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return sb.toString();
    }
}
