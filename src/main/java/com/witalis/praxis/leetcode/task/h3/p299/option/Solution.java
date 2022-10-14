package com.witalis.praxis.leetcode.task.h3.p299.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 299
 * Name: Bulls and Cows
 * URL: <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String secret;
    private String guess;

    public String process() {
        return getHint(secret, guess);
    }

    public String getHint(String secret, String guess) {
        int contains = 0;
        int correct = 0;

        StringBuilder builder = new StringBuilder();
        int[] map = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) correct++;
            else {
                if (map[secret.charAt(i) - '0']++ < 0) contains++;
                if (map[guess.charAt(i) - '0']-- > 0) contains++;
            }
        }
        builder.append(correct).append("A").append(contains).append("B");

        return builder.toString();
    }
}
