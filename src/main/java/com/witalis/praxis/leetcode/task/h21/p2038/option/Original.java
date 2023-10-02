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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String colors;

    public Boolean process() {
        return winnerOfGame(colors);
    }

    public boolean winnerOfGame(String colors) {
        if (colors == null || colors.isEmpty()) return false;

        int[] counters = new int[2];
        Arrays.fill(counters, 0);

        final int n = colors.length();
        char color = colors.charAt(0);
        int count = 0;
        for (int i = 0; i < n; i++) {
            char current = colors.charAt(i);

            if (current == color) {
                if (++count >= 3) counters[current - 'A']++;
            } else {
                color = current;
                count = 1;
            }
        }

        return counters[0] > counters[1];
    }
}
