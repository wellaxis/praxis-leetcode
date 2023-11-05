package com.witalis.praxis.leetcode.task.h16.p1535.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1535
 * Name: Find the Winner of an Array Game
 * URL: <a href="https://leetcode.com/problems/find-the-winner-of-an-array-game/">Find the Winner of an Array Game</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int rounds;

    public Integer process() {
        return getWinner(numbers, rounds);
    }

    public int getWinner(int[] arr, int k) {
        if (arr == null || k <= 0) return 0;

        if (k == 1)
            return Math.max(arr[0], arr[1]);

        final int n = arr.length;
        if (k >= n)
            return Arrays.stream(arr).max().orElse(0);

        int winner = arr[0];
        int counter = 0;
        for (int i = 1; i < n; i++) {
            int candidate = arr[i];

            if (winner > candidate) {
                counter++;
                if (counter == k) return winner;
            } else {
                winner = candidate;
                counter = 1;
            }
        }

        return winner;
    }
}
