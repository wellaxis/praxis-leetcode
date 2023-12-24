package com.witalis.praxis.leetcode.task.h18.p1758.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1758
 * Name: Minimum Changes To Make Alternating Binary String
 * URL: <a href="https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/">Minimum Changes To Make Alternating Binary String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return minOperations(string);
    }

    public int minOperations(String s) {
        char c0 = s.charAt(0);
        int count1 = count(s, c0);
        int count2 = count(s, c0 == '0' ? '1' : '0') + 1;

        return Math.min(count1, count2);
    }

    private int count(String s, char cPre) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == cPre) {
                count++;
                cPre = cPre == '0' ? '1' : '0';
            } else {
                cPre = current;
            }
        }
        return count;
    }
}
