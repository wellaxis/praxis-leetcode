package com.witalis.praxis.leetcode.task.h7.p657.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 657
 * Name: Robot Return to Origin
 * URL: <a href="https://leetcode.com/problems/robot-return-to-origin/">Robot Return to Origin</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String moves;

    public Boolean process() {
        return judgeCircle(moves);
    }

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }

        return x == 0 && y == 0;
    }
}
