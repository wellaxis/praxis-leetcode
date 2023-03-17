package com.witalis.praxis.leetcode.task.h9.p806.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 806
 * Name: Number of Lines To Write String
 * URL: <a href="https://leetcode.com/problems/number-of-lines-to-write-string/">Number of Lines To Write String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] widths;
    private String string;

    public int[] process() {
        return numberOfLines(widths, string);
    }

    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];

        int sum = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            sum += widths[c - 'a'];
            if (sum > 100) {
                count++;
                sum = widths[c - 'a'];
            }
        }
        res[0] = count + 1;
        res[1] = sum;

        return res;
    }
}
