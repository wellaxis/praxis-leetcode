package com.witalis.praxis.leetcode.task.h12.p1189.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 1189
 * Name: Maximum Number of Balloons
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-balloons/">Maximum Number of Balloons</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String text;

    public Integer process() {
        return maxNumberOfBalloons(text);
    }

    public int maxNumberOfBalloons(String text) {
        if (text == null || text.isEmpty()) return 0;

        char[] letters = text.toCharArray();
        int[] frequencies = new int[5];

        for (char letter : letters)
            switch (letter) {
                case 'a' -> frequencies[0]++;
                case 'b' -> frequencies[1]++;
                case 'l' -> frequencies[2]++;
                case 'n' -> frequencies[3]++;
                case 'o' -> frequencies[4]++;
            }

        IntStream stream = IntStream.of(frequencies[0], frequencies[1], frequencies[2] / 2, frequencies[3], frequencies[4] / 2);

        return stream.min().orElse(0);
    }
}
