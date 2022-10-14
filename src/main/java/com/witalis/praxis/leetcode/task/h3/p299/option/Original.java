package com.witalis.praxis.leetcode.task.h3.p299.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ID: 299
 * Name: Bulls and Cows
 * URL: <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String secret;
    private String guess;

    public String process() {
        return getHint(secret, guess);
    }

    public String getHint(String secret, String guess) {
        final String mask = "%dA%dB";

        int bulls = 0;
        int cows = 0;

        if (secret == null || guess == null || secret.length() != guess.length()) return String.format(mask, bulls, cows);

        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();

        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        // bulls
        for (int i = 0; i < secretArray.length; i++) {
            if (secretArray[i] == guessArray[i]) {
                bulls++;
            } else {
                secretMap.put(secretArray[i], secretMap.getOrDefault(secretArray[i], 0) + 1);
                guessMap.put(guessArray[i], guessMap.getOrDefault(guessArray[i], 0) + 1);
            }
        }

        // cows
        AtomicInteger counter = new AtomicInteger(0);
        secretMap.forEach(
            (character, frequency) -> {
                if (guessMap.containsKey(character)) {
                    counter.addAndGet(Math.min(frequency, guessMap.get(character)));
                }
            }
        );
        cows += counter.get();

        return String.format(mask, bulls, cows);
    }
}
