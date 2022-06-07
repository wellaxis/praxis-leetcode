package com.witalis.praxis.leetcode.task.h4.p344.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 344
 * Name: Reverse String
 * URL: <a href="https://leetcode.com/problems/reverse-string/">Reverse String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[] characters;

    public String process() {
        reverseString(characters);
        return String.valueOf(characters);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            // swap
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            // increment
            l++;
            r--;
        }
    }
}
