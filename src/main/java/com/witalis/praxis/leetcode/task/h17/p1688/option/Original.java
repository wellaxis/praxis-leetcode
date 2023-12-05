package com.witalis.praxis.leetcode.task.h17.p1688.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1688
 * Name: Count of Matches in Tournament
 * URL: <a href="https://leetcode.com/problems/count-of-matches-in-tournament/">Count of Matches in Tournament</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return numberOfMatches(number);
    }

    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return n / 2 + numberOfMatches(n / 2);
        } else {
            return (n - 1) / 2 + numberOfMatches((n - 1) / 2 + 1);
        }
    }
}
