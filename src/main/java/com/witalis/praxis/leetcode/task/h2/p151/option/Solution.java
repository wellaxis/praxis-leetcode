package com.witalis.praxis.leetcode.task.h2.p151.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 151
 * Name: Reverse Words in a String
 * URL: <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return reverseWords(string);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
