package com.witalis.praxis.leetcode.task.h8.p709.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 709
 * Name: To Lower Case
 * URL: <a href="https://leetcode.com/problems/to-lower-case/">To Lower Case</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return toLowerCase(string);
    }

    public String toLowerCase(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
                charArr[i] += 32;
            }
        }

        return new String(charArr);
    }
}
