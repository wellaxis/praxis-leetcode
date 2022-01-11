package com.witalis.praxis.leetcode.task.h1.p5.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 5
 * Name: Longest Palindromic Substring
 * URL: https://leetcode.com/problems/longest-palindromic-substring/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return longestPalindrome(string);
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";

        String palindrome = "";

        int counter = 0;
        while (counter < s.length()) {
            var substring = s.substring(counter);

            var single = positionPalindrome(substring);
            if (single.length() > palindrome.length()) {
                palindrome = single;
            }

            counter++;
        }

        return palindrome;
    }

    public String positionPalindrome(String s) {
        var palindrome = String.valueOf(s.charAt(0));

        StringBuilder builder = new StringBuilder(palindrome);
        for (int i = 1; i < s.length(); i++) {
            var variant = "";
            char ch = s.charAt(i);

            if (i == 1 && ch == palindrome.charAt(0)) {
                palindrome = builder.toString() + ch;
            }
            if (i + builder.length() + 1 < s.length()) {
                var sub2 = new StringBuilder(builder).append(ch).reverse();
                if (s.substring(i + 1, i + 1 + sub2.length()).equals(sub2.toString())) {
                    variant = builder.toString() + ch + sub2;
                    if (variant.length() > builder.length()) {
                        palindrome = variant;
                    }
                    builder.append(ch);
                    continue;
                }
            }
            if (i + builder.length() < s.length()) {
                var sub1 = new StringBuilder(builder).reverse();
                if (s.substring(i + 1, i + 1 + sub1.length()).equals(sub1.toString())) {
                    variant = builder.toString() + ch + sub1;
                    if (variant.length() > builder.length()) {
                        palindrome = variant;
                    }
                }
            }
            builder.append(ch);
        }
        return palindrome;
    }
}
