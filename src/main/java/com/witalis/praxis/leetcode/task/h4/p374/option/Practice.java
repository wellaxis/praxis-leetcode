package com.witalis.praxis.leetcode.task.h4.p374.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.task.h4.p374.content.GuessUtils.guess;

/**
 * ID: 374
 * Name: Guess Number Higher or Lower
 * URL: <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">Guess Number Higher or Lower</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return guessNumber(number);
    }

    public int guessNumber(int n) {
        if (n <= 0) return 0;

        int l = 0;
        while (l < n) {
            int mid = l / 2 + n / 2;
            int guess = guess(mid);

            if (guess == 0) return mid;
            if (guess < 0) n = mid - 1;
            if (guess > 0) l = mid + 1;
        }

        return n;
    }
}
