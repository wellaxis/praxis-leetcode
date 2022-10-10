package com.witalis.praxis.leetcode.task.h7.p657.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 657
 * Name: Robot Return to Origin
 * URL: <a href="https://leetcode.com/problems/robot-return-to-origin/">Robot Return to Origin</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String moves;

    public Boolean process() {
        return judgeCircle(moves);
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) return true;

        int[] position = new int[] {0, 0};
        for (char direction : moves.toCharArray()) {
            switch (direction) {
                case 'U' -> position[1]++;
                case 'D' -> position[1]--;
                case 'R' -> position[0]++;
                case 'L' -> position[0]--;
                default -> throw new IllegalArgumentException("Unexpected direction: " + direction);
            }
        }

        return position[0] == 0 && position[1] == 0;
    }
}
