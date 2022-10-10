package com.witalis.praxis.leetcode.task.h7.p657.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 657
 * Name: Robot Return to Origin
 * URL: <a href="https://leetcode.com/problems/robot-return-to-origin/">Robot Return to Origin</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String moves;

    public Boolean process() {
        return judgeCircle(moves);
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) return true;

        int abscissa = 0;
        int ordinate = 0;
        for (char direction : moves.toCharArray()) {
            switch (direction) {
                case 'U' -> ordinate++;
                case 'D' -> ordinate--;
                case 'R' -> abscissa++;
                case 'L' -> abscissa--;
                default -> throw new IllegalArgumentException("Unexpected direction: " + direction);
            }
        }

        return abscissa == 0 && ordinate == 0;
    }
}
