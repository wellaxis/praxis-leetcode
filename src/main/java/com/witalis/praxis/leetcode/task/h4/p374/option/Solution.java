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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return guessNumber(number);
    }

    public int guessNumber(int n) {
        // ternary search
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }

        return -1;
    }
}
