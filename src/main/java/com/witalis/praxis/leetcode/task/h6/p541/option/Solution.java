package com.witalis.praxis.leetcode.task.h6.p541.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 541
 * Name: Reverse String II
 * URL: <a href="https://leetcode.com/problems/reverse-string-ii/">Reverse String II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private int index;

    public String process() {
        return reverseStr(string, index);
    }

    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();

        // for every 2k characters
        for (int left = 0; left < array.length; left += 2 * k) {
            // reverse first k characters
            for (int i = left, j = Math.min(left + k - 1, array.length - 1); i < j; i++, j--) {
                char tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        return new String(array);
    }
}
