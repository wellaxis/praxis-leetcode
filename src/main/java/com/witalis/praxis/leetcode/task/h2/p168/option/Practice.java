package com.witalis.praxis.leetcode.task.h2.p168.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 168
 * Name: Excel Sheet Column Title
 * URL: <a href="https://leetcode.com/problems/excel-sheet-column-title/">Excel Sheet Column Title</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int columnNumber;

    public String process() {
        return convertToTitle(columnNumber);
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber < 1) return "";

        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            builder.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return builder.reverse().toString();
    }
}
