package com.witalis.praxis.leetcode.task.h21.p2038.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2038
 * Name: Remove Colored Pieces if Both Neighbors are the Same Color
 * URL: <a href="https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/">Remove Colored Pieces if Both Neighbors are the Same Color</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String colors;

    public Boolean process() {
        return winnerOfGame(colors);
    }

    public boolean winnerOfGame(String colors) {
        if (colors == null || colors.isEmpty()) return false;

        final int[] counters = new int[] {0, 0};
        final char[] letters = colors.toCharArray();

        char color = colors.charAt(0);
        int count = 0;
        for (char letter : letters) {
            if (letter == color) {
                if (++count >= 3) counters[letter - 'A']++;
            } else {
                color = letter;
                count = 1;
            }
        }

        return counters[0] > counters[1];
    }
}
