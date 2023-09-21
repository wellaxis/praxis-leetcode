package com.witalis.praxis.leetcode.task.h29.p2810.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2810
 * Name: Faulty Keyboard
 * URL: <a href="https://leetcode.com/problems/faulty-keyboard/">Faulty Keyboard</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return finalString(string);
    }

    public String finalString(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder builder = new StringBuilder();

        final char[] letters = s.toCharArray();
        for (char letter : letters)
            if (letter == 'i')
                builder.reverse();
            else
                builder.append(letter);

        return builder.toString();
    }
}
