package com.witalis.praxis.leetcode.task.p6.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 6
 * Name: Zigzag Conversion
 * URL: https://leetcode.com/problems/zigzag-conversion/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private int numRows;

    public String process() {
        return convert(string, numRows);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();

        int i = 0;
        while (i < Math.min(numRows, s.length())) {
            rows.add(new StringBuilder());
            i++;
        }

        int counter = 0;
        boolean down = true;
        int row = 0;

        while (counter < s.length()) {
            rows.get(row).append(s.charAt(counter++));

            if (down) {
                if (row == numRows - 1) {
                    down = false;
                    row--;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    down = true;
                    row++;
                } else {
                    row--;
                }
            }
        }

        return rows.stream()
            .reduce(
                new StringBuilder(),
                StringBuilder::append
            ).toString();
    }
}
