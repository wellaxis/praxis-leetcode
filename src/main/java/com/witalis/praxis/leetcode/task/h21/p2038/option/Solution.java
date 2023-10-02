package com.witalis.praxis.leetcode.task.h21.p2038.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2038
 * Name: Remove Colored Pieces if Both Neighbors are the Same Color
 * URL: <a href="https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/">Remove Colored Pieces if Both Neighbors are the Same Color</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String colors;

    public Boolean process() {
        return winnerOfGame(colors);
    }

    public boolean winnerOfGame(String colors) {
        int aliceCount = 0;
        int bobCount = 0;
        int aliceTemp = 0;
        int bobTemp = 0;
        for (char color : colors.toCharArray()) {
            if (color == 'A') {
                bobTemp = 0;
                aliceTemp++;
                if (aliceTemp >= 3) {
                    aliceCount++;
                }
            } else {
                aliceTemp = 0;
                bobTemp++;
                if (bobTemp >= 3) {
                    bobCount++;
                }
            }
        }

        return aliceCount > bobCount;
    }
}
