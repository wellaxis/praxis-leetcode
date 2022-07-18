package com.witalis.praxis.leetcode.task.h5.p482.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 482
 * Name: License Key Formatting
 * URL: <a href="https://leetcode.com/problems/license-key-formatting/">License Key Formatting</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private int key;

    public String process() {
        return licenseKeyFormatting(string, key);
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            if (count == k) {
                sb.append('-');
                count = 0;
            }
            sb.append(Character.toUpperCase(c));
            count++;
        }

        return sb.reverse().toString();
    }
}
