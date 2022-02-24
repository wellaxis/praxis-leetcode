package com.witalis.praxis.leetcode.task.h3.p292.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 292
 * Name: Nim Game
 * URL: https://leetcode.com/problems/nim-game/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return canWinNim(number);
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
