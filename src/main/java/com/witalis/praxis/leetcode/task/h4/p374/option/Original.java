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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return guessNumber(number);
    }

    public int guessNumber(int n) {
        if (n <= 0) return 0;

        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = Math.toIntExact(((long) left + right) / 2);
            int guess = guess(mid);

            if (guess < 0) {
                right = mid - 1;
            } else if (guess > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
