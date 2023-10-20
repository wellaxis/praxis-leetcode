package com.witalis.praxis.leetcode.task.h11.p1025.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1025
 * Name: Divisor Game
 * URL: <a href="https://leetcode.com/problems/divisor-game/">Divisor Game</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Boolean process() {
        return divisorGame(number);
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
