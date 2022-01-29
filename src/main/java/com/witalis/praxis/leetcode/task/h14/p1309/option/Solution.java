package com.witalis.praxis.leetcode.task.h14.p1309.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1309
 * Name: Decrypt String from Alphabet to Integer Mapping
 * URL: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return freqAlphabets(string);
    }

    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                ans.append((char) (Integer.parseInt(s.substring(i, i + 2)) + 'a' - 1));
                i += 3;
            } else {
                ans.append((char) ((s.charAt(i) - '0') + 'a' - 1));
                i += 1;
            }
        }

        return ans.toString();
    }
}
