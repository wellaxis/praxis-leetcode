package com.witalis.praxis.leetcode.task.h3.p299.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 299
 * Name: Bulls and Cows
 * URL: <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String secret;
    private String guess;

    public String process() {
        return getHint(secret, guess);
    }

    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) return "0A0B";

        int bulls = 0;
        int cows = 0;

        int[] frequency = new int[10];

        int secretDigit;
        int guessDigit;
        for (int i = 0; i < secret.length(); i++) {
            secretDigit = secret.charAt(i) - '0';
            guessDigit = guess.charAt(i) - '0';
            if (secretDigit == guessDigit) {
                bulls++;
            } else {
                if (frequency[secretDigit] < 0) cows++;
                frequency[secretDigit]++;
                if (frequency[guessDigit] > 0) cows++;
                frequency[guessDigit]--;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
