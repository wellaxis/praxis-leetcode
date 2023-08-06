package com.witalis.praxis.leetcode.task.h10.p920.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 920
 * Name: Number of Music Playlists
 * URL: <a href="https://leetcode.com/problems/number-of-music-playlists/">Number of Music Playlists</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int songs;
    private int goal;
    private int gap;

    public Solution(int songs, int goal, int gap) {
        this.songs = songs;
        this.goal = goal;
        this.gap = gap;
    }

    public Integer process() {
        return numMusicPlaylists(songs, goal, gap);
    }

    private static final long MOD = 1_000_000_007;

    // pre-calculated factorials and inverse factorials
    private long[] factorial;
    private long[] invFactorial;

    // calculates number of playlists
    public int numMusicPlaylists(int n, int goal, int k) {
        // pre-calculate factorials and inverse factorials
        precalculateFactorials(n);

        // initialize variables for calculation
        int sign = 1;
        long answer = 0;

        // loop from 'n' down to 'k'
        for (int i = n; i >= k; i--) {
            // calculate temporary result for this iteration
            long temp = power(i - k, goal - k);
            temp = (temp * invFactorial[n - i]) % MOD;
            temp = (temp * invFactorial[i - k]) % MOD;

            // add or subtract temporary result to/from answer
            answer = (answer + sign * temp + MOD) % MOD;

            // flip sign for next iteration
            sign *= -1;
        }

        // final result is n! * answer, all under modulo
        return (int) ((factorial[n] * answer) % MOD);
    }

    // pre-calculate factorials and inverse factorials up to 'n'
    private void precalculateFactorials(int n) {
        factorial = new long[n + 1];
        invFactorial = new long[n + 1];
        factorial[0] = invFactorial[0] = 1;

        // calculate factorials and inverse factorials for each number up to 'n'
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
            // inverse factorial calculated using Fermat's Little Theorem
            invFactorial[i] = power(factorial[i], (int) (MOD - 2));
        }
    }

    // calculate power of a number under modulo using binary exponentiation
    private long power(long base, int exponent) {
        long result = 1L;

        // loop until exponent is not zero
        while (exponent > 0) {
            // if exponent is odd, multiply result with base
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }
            // divide the exponent by 2 and square the base
            exponent >>= 1;
            base = (base * base) % MOD;
        }

        return result;
    }
}
