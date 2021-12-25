package com.witalis.praxis.leetcode.task.p125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collector;

/**
 * ID: 125
 * Name: Valid Palindrome
 * URL: https://leetcode.com/problems/valid-palindrome/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Boolean process() {
        return isPalindrome(string);
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isBlank()) return true;

        return builderCheck(s);
    }

    public boolean builderCheck(String s) {
        var builder = new StringBuilder();
        for (char ch: s.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                builder.append(ch);
            }
        }

        return builder.toString().equals(builder.reverse().toString());
    }

    private boolean streamCheck(String s) {
        s = s.toLowerCase().chars()
            .mapToObj(c -> (char) c)
            .filter(c -> Character.isLetter(c) || Character.isDigit(c))
            .collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString
            ));

        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private boolean regexCheck(String s) {
        final String pattern = "[^a-zA-Z0-9]";

        s = s.toLowerCase().replaceAll(pattern, "");
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }

        return true;
    }
}
