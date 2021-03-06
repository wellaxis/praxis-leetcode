package com.witalis.praxis.leetcode.task.h1.p65.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 65
 * Name: Valid Number
 * URL: <a href="https://leetcode.com/problems/valid-number/">Valid Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Boolean process() {
        return isNumber(string);
    }

    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.length() == 1) return Character.isDigit(s.charAt(0));

        s = s.trim().toLowerCase();

        String t = s.replaceAll("[+-.e]", "");
        if (t.isEmpty()) return false;
        for (int i = 0; i < t.length(); i++) {
            if (!Character.isDigit(t.charAt(i))) return false;
        }

        if (s.length() - s.replace("e", "").length() > 1) return false;
        if (s.length() - s.replace(".", "").length() > 1) return false;

        boolean numbers = false;
        int index = 0;
        while (index < s.length()) {
            switch (s.charAt(index)) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                    numbers = true;
                }
                case 'e', 'E' -> {
                    if (index == 0 || index == s.length() - 1) return false;
                    if (!numbers) return false;
                }
                case '+', '-' -> {
                    if (index == s.length() - 1) return false;
                    if (index > 0 && s.charAt(index - 1) != 'e') return false;
                }
                case '.' -> {
                    if (index == s.length() - 1 && !numbers) return false;
                    if (s.substring(0, index).indexOf("e") > 0) return false;
                }
            }
            index++;
        }
        return true;
    }
}
