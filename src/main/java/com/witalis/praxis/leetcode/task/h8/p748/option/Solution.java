package com.witalis.praxis.leetcode.task.h8.p748.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 748
 * Name: Shortest Completing Word
 * URL: <a href="https://leetcode.com/problems/shortest-completing-word/">Shortest Completing Word</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String licensePlate;
    private String[] words;

    public String process() {
        return shortestCompletingWord(licensePlate, words);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        final long charProduct = getCharProduct(licensePlate.toLowerCase());

        String shortest = "aaaaaaaaaaaaaaaaaaaa";
        for (final String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                shortest = word;

        return shortest;
    }

    private static long getCharProduct(String plate) {
        final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        long product = 1L;
        for (final char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25) product *= primes[index];
        }

        return product;
    }
}
