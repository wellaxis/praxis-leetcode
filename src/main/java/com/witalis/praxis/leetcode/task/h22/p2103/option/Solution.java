package com.witalis.praxis.leetcode.task.h22.p2103.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2103
 * Name: Rings and Rods
 * URL: <a href="https://leetcode.com/problems/rings-and-rods/">Rings and Rods</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String rings;

    public Integer process() {
        return countPoints(rings);
    }

    public int countPoints(String rings) {
        int[][] result = new int[10][3];

        for (int i = 0; i < rings.length(); i += 2) {
            int rod = rings.charAt(i + 1) - '0';
            int color = rings.charAt(i) == 'R' ? 0 : rings.charAt(i) == 'G' ? 1 : 2;
            result[rod][color] = 1;
        }

        int count = 0;
        for (int[] colors : result) {
            if (colors[0] == 1 && colors[1] == 1 && colors[2] == 1) {
                count++;
            }
        }

        return count;
    }
}
