package com.witalis.praxis.leetcode.task.h12.p1189.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1189
 * Name: Maximum Number of Balloons
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-balloons/">Maximum Number of Balloons</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String text;

    public Integer process() {
        return maxNumberOfBalloons(text);
    }

    public int maxNumberOfBalloons(String text) {
        if (text == null || text.isEmpty()) return 0;

        int[] frequencies = new int[26];
        for (int i = 0; i < text.length(); i++)
            frequencies[text.charAt(i) - 'a']++;

        int counter = Integer.MAX_VALUE;
        counter = Math.min(counter, frequencies['b' - 'a']);
        counter = Math.min(counter, frequencies['a' - 'a']);
        counter = Math.min(counter, frequencies['l' - 'a'] / 2);
        counter = Math.min(counter, frequencies['o' - 'a'] / 2);
        counter = Math.min(counter, frequencies['n' - 'a']);

        return counter;
    }
}
