package com.witalis.praxis.leetcode.task.p6.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 6
 * Name: Zigzag Conversion
 * URL: https://leetcode.com/problems/zigzag-conversion/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private int numRows;

    public String process() {
        return convert(string, numRows);
    }

    /*
     Visit all characters in row 0 first, then row 1, then row 2, and so on...

     For all whole numbers 'k',
     - Characters in row 0 are located at indexes k:
       k * (2 * numRows - 2)
     - Characters in row numRows − 1 are located at indexes k:
       k * (2 * numRows - 2) + numRows - 1
     - Characters in inner row 'i' are located at indexes k:
       k * (2 * numRows - 2) + i
       and to k + 1:
       (k + 1) * (2 * numRows − 2) - i
    */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
