package com.witalis.praxis.leetcode.task.h5.p409.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 409
 * Name: Longest Palindrome
 * URL: <a href="https://leetcode.com/problems/longest-palindrome/">Longest Palindrome</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return longestPalindrome(string);
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] letters = s.toCharArray();
        Arrays.sort(letters);

        int length = 0;
        boolean odd = false;
        for (int i = 0; i < letters.length; i++) {
            int counter = i;
            while (i < letters.length - 1 && letters[i] == letters[i + 1]) i++;
            counter = i - counter + 1;
            if ((counter & 1) == 0) {
                length += counter;
            } else {
                odd = true;
                if (counter > 1) length += counter - 1;
            }
        }

        return length + (odd ? 1 : 0);
    }
}
