package com.witalis.praxis.leetcode.task.h4.p344.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 344
 * Name: Reverse String
 * URL: <a href="https://leetcode.com/problems/reverse-string/">Reverse String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[] characters;

    public String process() {
        reverseString(characters);
        return String.valueOf(characters);
    }

    public void reverseString(char[] s) {
        int middle = s.length >> 1;
        for (int i = 0; i < middle; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    private void swap(char[] s, int start, int end) {
        char tmp = ' ';
        tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
    }
}
