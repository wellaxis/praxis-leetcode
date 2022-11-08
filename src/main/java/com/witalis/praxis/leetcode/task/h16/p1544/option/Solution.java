package com.witalis.praxis.leetcode.task.h16.p1544.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1544
 * Name: Make The String Great
 * URL: <a href="https://leetcode.com/problems/make-the-string-great/">Make The String Great</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return makeGood(string);
    }

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pointer > 0 && Math.abs(sb.charAt(pointer - 1) - s.charAt(i)) == 32) {
                pointer--;
                sb.deleteCharAt(pointer);
            } else {
                sb.append(s.charAt(i));
                pointer++;
            }
        }

        return sb.toString();
    }

    public String recursiveMakeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }
}
