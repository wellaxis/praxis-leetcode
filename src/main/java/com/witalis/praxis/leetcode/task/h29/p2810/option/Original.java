package com.witalis.praxis.leetcode.task.h29.p2810.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2810
 * Name: Faulty Keyboard
 * URL: <a href="https://leetcode.com/problems/faulty-keyboard/">Faulty Keyboard</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return finalString(string);
    }

    public String finalString(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder builder = new StringBuilder();

        final int n = s.length();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == 'i')
                builder.reverse();
            else
                builder.append(s.charAt(i));

        return builder.toString();
    }
}
